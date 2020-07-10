import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();


        System.out.println(multiplication(x, y));
    }

    public static long multiplication (long x, long y) {

        int halfDigits = 0;

        if(x < 10 || y < 10) {
            return x * y;
        } else {

            if(x <= y) {
                halfDigits = getDigits(x) / 2;
            } else {
                halfDigits = getDigits(y) / 2;
            }

            long a = x / (long)Math.pow(10, halfDigits);
            long b = x % (long)Math.pow(10, halfDigits);

            long c = y / (long)Math.pow(10, halfDigits);
            long d = y % (long)Math.pow(10, halfDigits);

            long ac = multiplication(a ,c);
            long bd = multiplication(b, d);
            long all = multiplication((a + b),(c + d));
            long lastStep = all - ac - bd;

            return ac * (long)Math.pow(10, 2 * halfDigits) + lastStep * (long)Math.pow(10, halfDigits) + bd;
        }
    }

    //return the number of digits of the inputed number
    public static int getDigits (long x) {

        int number = 10;
        int digits = 1;

        while(x >= number) {
            digits++;
            number *= 10;
        }

        return digits;

    }
}
