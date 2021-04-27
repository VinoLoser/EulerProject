package EulerProject;

public class recursifepermutations {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        permutate(array, 0);
    }
    public static void permutate(int[] a, int l) {
        if (l == a.length) {
            for (int i : a) {
                System.out.print(i + ", ");
            }
            System.out.println();
            return;
        }
        for (int j = l; j < a.length; j++) {
            int temp = a[j];
            a[j] = a[l];
            a[l] = temp;
            permutate(a,l+1);
            temp = a[j];
            a[j] = a[l];
            a[l] = temp;
        }
    }
}
