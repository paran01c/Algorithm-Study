import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x = new int[n];

        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        int[] result = mergeSort(x);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] array) {

        int n = array.length;

        if(n == 1) {
            return array;
        } else {
            int childLength = n / 2;

            //creating and populating the new arrays
            int[] A = new int[childLength];
            for (int i = 0; i < childLength; i++) {
                A[i] = array[i];
            }

            int[] B = new int[n - childLength];
            for (int i = childLength, j = 0; i < n; i++, j++) {
                B[j] = array[i];
            }

            A = mergeSort(A);
            B = mergeSort(B);

            return merge(A, B);
        }
    }

    public static int[] merge (int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        boolean firstEnd = false;
        boolean secondEnd = false;

        for(int i = 0; i < result.length; i++) {

            if(secondEnd || (A[a] <= B[b] && !firstEnd)) {
                result[i] = A[a];
                a++;

                if(a == A.length) {
                    a--;
                    firstEnd = true;
                }
            } else if(firstEnd || (A[a] > B[b] && !secondEnd)){
                result[i] = B[b];
                b++;

                if(b == B.length) {
                    b--;
                    secondEnd = true;
                }
            }
        }

        return result;

    }
}
