import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //gets the input from the user and puts those numbers in a array
        String stringX = sc.nextLine();
        String stringY = sc.nextLine();
        String operationToken = sc.nextLine();


        char[] charX = stringX.toCharArray();
        char[] charY = stringY.toCharArray();

        byte[] x = new byte[charX.length];
        for (int i = 0, n = x.length; i < n; i++) {
            x[i] = (byte)Character.getNumericValue(charX[i]);
        }

        byte[] y = new byte[charY.length];
        for (int i = 0, n = y.length; i < n; i++) {
            y[i] = (byte)Character.getNumericValue(charY[i]);
        }

        Operation operation = new Operation();
        byte[] result = new byte[1];

        switch (operationToken) {
            case "+":
                result = x.length >= y.length ? operation.add(x, y) : operation.add(y, x);
                break;
            case "*":
                result = x.length >= y.length ? operation.clasicMultiplication(x, y) : operation.clasicMultiplication(y, x);
                break;
            case "K":
                result = x.length >= y.length ? operation.karatsubaMultiply(x, y) : operation.karatsubaMultiply(y, x);
                break;
            case "-":
                result = x.length >= y.length ? operation.sub(x, y) : operation.sub(y, x);
            default:
                System.out.println("Unknown Comand Or Wrong Order");
                result[0] = 0;
        }

        //printing result
        for(int i = 0, n = result.length; i < n; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}
