import java.util.Scanner;

public class Main {

    public static long karatsubaMultiply(long x, long y) {

        // digitsX need to be equal to digits y
        //gets the digits of the 2 numbers
        long digitsX = numberDigits(x);
        long digitsY = numberDigits(y);

        // base case
        if(digitsX == 1|| digitsY == 1) {

            return x * y;

        } else {

            //decomposes the numbers as (10^n * a + b)
            long digitsComponents = digitsX / 2;
            long a = x / (long)Math.pow(10, digitsComponents);
            digitsComponents = digitsX - digitsComponents;
            long b = 0;
            if(digitsX % 2 == 0) {
                b = x % (long) Math.pow(10, digitsComponents);
            } else {
                b = x % (long) Math.pow(10, digitsComponents - 1);
            }

            digitsComponents = digitsY / 2;
            long c = y / (long)Math.pow(10, digitsComponents);
            digitsComponents = digitsY - digitsComponents;

            long d = 0;
            if(digitsY % 2 == 0) {
                d = y % (long) Math.pow(10, digitsComponents);
            } else {
                d = y % (long) Math.pow(10, digitsComponents - 1);
            }

            System.out.println("-------");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println("-------");

            long ac = karatsubaMultiply(a, c);
            System.out.println("!!!!!!!!!!!!!!");
            System.out.println("ac" + ac);
            long bd = karatsubaMultiply(b, d);
            System.out.println("!!!!!!!!!!!!!!");
            System.out.println("bd" + bd);
            long all = karatsubaMultiply((a + b), (c + d));
            System.out.println("!!!!!!!!!!!!!!");
            System.out.println("all" + all);

            System.out.println("?????????");
            long k = (long)(Math.pow(10, numberDigits(bd)) * ac) + (long)(Math.pow(10, (int)numberDigits(bd) / 2) * (all - ac - bd)) + bd;
            System.out.println(k);
            System.out.println("?????????");
            return k;
        }

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


        System.out.println(karatsubaMultiply(5678, 1234));


    }
}
