package EulerProject.EulerProject61;

import java.util.ArrayList;
import java.util.HashMap;

interface PolyFun{
    int run(int num);
}

public class test {

    private ArrayList<HashMap<Integer, ArrayList<Integer>>> tables = new ArrayList<HashMap<Integer, ArrayList<Integer>>>();
    
    public static void main(String[] args)
    {
        final long startTime = System.currentTimeMillis();
        var numbers = new ArrayList<Integer>();
        var groups = new ArrayList<Integer>();
        try {
            new test().search(numbers, groups);
        } catch(Exception e) {

        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public test()
    {
        maketables();
    }
    
    public void search(ArrayList<Integer> numbers, ArrayList<Integer> groups) throws Exception {
        if (numbers.size() == 6) {
            if (numbers.get(0) / 100 == numbers.get(5) % 100) {
                int sum = 0;
                for (int i : numbers) {
                    sum += i;
                }
                System.out.println(sum);
                throw new Exception("Done");
            }
            return;
        }
        for (int g = 0; g <= 5; g++) {
            if (groups.contains(g)) {
                continue;
            }
            var table = tables.get(g);
            ArrayList<Integer> candidates = null;
            if (numbers.isEmpty()) {
                candidates = new ArrayList<Integer>();
                for (var entry : table.entrySet()) {
                    for (int candidate : entry.getValue()) {
                        candidates.add(candidate);
                    }
                }
            } else {
                int lastnum = numbers.get(numbers.size()-1) % 100;
                if (table.containsKey(lastnum)) {
                    candidates = table.get(lastnum);
                }
            }
            if (candidates == null) {
                continue;
            }
            for (int candidate : candidates) {
                numbers.add(candidate);
                groups.add(g);
                search(numbers, groups);
                numbers.remove(numbers.size() - 1);
                groups.remove(groups.size() - 1);
            }
        }
    }

    private HashMap<Integer, ArrayList<Integer>> maketable(PolyFun f) {
        var hashMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; ; i++) {
            int result = f.run(i);
            if (result >= 10000) {
                break;
            }
            if (result > 999) {
                ArrayList<Integer> list = null;
                int key = result / 100;
                if (!hashMap.containsKey(key)) {
                    list = new ArrayList<Integer>();
                    hashMap.put(key, list);
                } else {
                    list = hashMap.get(key);
                }
                list.add(result);
            }
        }
        return hashMap;
    }

    private void maketables() {
        PolyFun[] funtab = {n -> n*(n+1)/2, 
                            n -> n*n,
                            n -> n*(3*n-1)/2, 
                            n -> n*(2*n-1), 
                            n -> n*(5*n-3)/2, 
                            n -> n*(3*n-2)};

        for (PolyFun fun : funtab) {
            tables.add(maketable(fun));
        }
    }
}
