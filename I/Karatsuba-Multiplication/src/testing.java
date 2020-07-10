import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {

        File inputFile = new File("./inputTest.txt");
        String stringX, stringY, numberOfTest = "0", stringResult;
        Operation operation = new Operation();
        String maxNumberTestCases = "8";

        try {
            Scanner inputScanner = new Scanner(inputFile);

            while (!numberOfTest.equals(maxNumberTestCases)) {

                numberOfTest = inputScanner.nextLine();

                //get the testing values from the file
                stringX = inputScanner.nextLine();
                stringY = inputScanner.nextLine();

                //apli the function to them
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

                int[] result = x.length > y.length ? operation.karatsubaMultiply(x, y) : operation.karatsubaMultiply(y, x);

                //get the solution reuslt from the file and turn it into a array
                stringResult = inputScanner.nextLine();
                char[] charResult = stringResult.toCharArray();

                int[] resultExpected = new int[charResult.length];
                for (int i = 0, n = resultExpected.length; i < n; i++) {
                    resultExpected[i] = Character.getNumericValue(charResult[i]);
                }

                System.out.println(numberOfTest + " " + Arrays.equals(result, resultExpected));
            }

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
