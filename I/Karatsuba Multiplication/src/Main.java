import java.util.Scanner;

public class Main {

    public static long karatsubaMultiply(long x, long y) {

        long digitsX = numberDigits(x);
        long digitsY = numberDigits(y);
        //m = power of 10 used for the algorithm
        long m = 0;
        long minDigits = 0;

        if(digitsX >= digitsY) {
            m = digitsX % 2 == 0 ? digitsX / 2 : digitsX / 2 + 1;
            minDigits = digitsY;
        } else if (digitsX < digitsY) {
            m = digitsY % 2 == 0 ? digitsY / 2 : digitsY / 2 + 1;
            minDigits = digitsX;
        }

        //check that the diference betwen the 2 numbers is not to big
        while(m > minDigits) {
            m--;
        }

        //base case
        if(digitsX == 1 || digitsY == 1) {
            return x * y;
        } else {

            long a = (long)(Math.pow(10, ))
        }

        return 1;
    }

    private static long numberDigits(long n) {

        if(n == 1) {
            return 1;
        }

        long digits = 0;
        double number = 0;
        while (true) {

            number = Math.pow(10, digits);

            if (number > n) {
                return digits;
            } else if(number == n) {
                return digits + 1;
            } else

            digits++;
        }
    }

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);


        System.out.println(karatsubaMultiply(12345, 6789));


    }
}
