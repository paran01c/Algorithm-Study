import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //gets the input from the user and puts those numbers in a array
        String stringX = sc.nextLine();
        String stringY = sc.nextLine();

        char[] charX = stringX.toCharArray();
        char[] charY = stringY.toCharArray();

        int[] x = new int[charX.length];
        for (int i = 0, n = x.length; i < n; i++) {
            x[i] = (int)charX[i];
        }

        int[] y = new int[charY.length];
        for (int i = 0, n = y.length; i < n; i++) {
            y[i] = (int)charY[i];
        }

        Operation operation = new Operation();
        int[] result = operation.KaratsubaMultiply(x, y, x.length, y.length);

        for(int i = 0, n = result.length; i < n; i++) {
            System.out.println(result);
        }
    }

}
