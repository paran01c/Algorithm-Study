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
            x[i] = Character.getNumericValue(charX[i]);
        }

        int[] y = new int[charY.length];
        for (int i = 0, n = y.length; i < n; i++) {
            y[i] = Character.getNumericValue(charY[i]);
        }

        Operation operation = new Operation();
        int[] result = x.length > y.length ? operation.Add(x, y) : operation.Add(y, x);

        //printing result
        for(int i = 0, n = result.length; i < n; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}
