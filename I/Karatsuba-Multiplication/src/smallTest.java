import java.util.Scanner;

public class smallTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //gets the input from the user and puts those numbers in a array
        String stringX = sc.nextLine();


        char[] charX = stringX.toCharArray();

        int[] x = new int[charX.length];
        for (int i = 0, n = x.length; i < n; i++) {
            x[i] = Character.getNumericValue(charX[i]);
        }

        Operation operation = new Operation();

        int[] firstX = operation.firstDigits(x , 3);
        int[] lastX = operation.lastDigits(x, 3);
        int[] movex = operation.moveBy(firstX, 3);

        for(int i = 0; i < firstX.length; i ++) {
            System.out.print(firstX[i]);
        }
        System.out.println();

        for(int i = 0; i < lastX.length; i ++) {
            System.out.print(lastX[i]);
        }
        System.out.println();


        for(int i = 0; i < movex.length; i ++) {
            System.out.print(movex[i]);
        }
        System.out.println();
    }
}
