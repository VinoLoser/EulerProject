public class Main{
    public static void main(String[] args) {
        int size = 2000000;
        boolean [] array = new boolean[size];
        long sum = 0l;
        for (int div = 2; div < size; div++) {
            if (array[div] == false) {
                sum += div;
                int i = div;
                while ( div <= Math.sqrt(size) && div * i < size) {
                    array[div*i] = true;
                    i++;
                }
            }
        }
        System.out.println(sum);

        
    }
}