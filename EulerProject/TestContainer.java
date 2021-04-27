package EulerProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

interface ContainerBase {
    public abstract boolean add(String key, long value);
    public abstract Long get(String key);
    public abstract int maxload();
}

class MyContainer1 implements ContainerBase
{
    public class set {
        String key;
        long value;
    }

    private static final int N = 1000 * 1000;

    ArrayList<set>[] array = new ArrayList[N];

    @Override
    public int maxload()
    {
        int res = 0;
        for (var slot : array) {
            if (slot != null) {
                res = Math.max(res, slot.size());
            }
        }
        return res;
    }

    public int hash(String string) {
        int res = 0;
        //return string.hashCode();
        for (int i = 0; i < string.length(); ++i) {
            res = res * 26 + (string.charAt(i) - 'A');
        }
        return res;
    }

    @Override
    public boolean add(String key, long value)
    {
        int hash = hash(key);
        int pos = Math.abs(hash % N);

        if (array[pos] != null) {
            for (set i : array[pos]) {
                if (i.key.equals(key)) {
                    return false;
                }
            }
            set i = new set();
            i.key = key;
            i.value = value;
            array[pos].add(i);
            return true;
        }
        ArrayList<set> arrayList = new ArrayList<set>();
        set i = new set();
        i.key = key;
        i.value = value;
        arrayList.add(i);
        array[pos] = arrayList;
        return true;
    }

    @Override
    public Long get(String key)
    {
        int hash = hash(key);
        int pos = Math.abs(hash % N);
        if (array[pos] == null) {
            return null;
        }
        for (set i : array[pos]) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }
}


public class TestContainer {
    private static String randStr(Random r)
    {
        String s = "";
        for (int i = 0; i < 6; ++i) {
            s += 'A' + r.nextInt(26);
        }
        return s;
    }

    public static void main(String[] args) {
        HashMap<String, Long> allKeys = new HashMap<>();
        ContainerBase container1 = new MyContainer1();

        Random rand = new Random();
        final int N = 1000 * 1000 * 10;
        for (int i = 1; i <= N; ++i) {
            var key = randStr(rand);
            var value = rand.nextLong();

            boolean dup = allKeys.containsKey(key);
            if (!dup) {
                allKeys.put(key, value);
            }
            var rc1 = container1.add(key, value);
            
            if (rc1 == dup) {
                System.err.println( "Error1" );
                return;
            }
        }

        System.out.println("MaxLoad:" + container1.maxload());

        for (var entry : allKeys.entrySet()) {
            var value = container1.get(entry.getKey());
            if (value == null || !value.equals(entry.getValue())) {
                System.err.println( "Error1" );
                return;
            }
        }

        for (int i = 1; i <= N; ++i) {
            var key = randStr(rand);
            boolean rc1 = container1.get(key) != null;
            boolean rc2 = allKeys.containsKey(key);
            if (rc1 != rc2) {
                System.err.println( "Error2" );
                return;
            }
        }
        System.out.println("Pass");
    }
    
}
