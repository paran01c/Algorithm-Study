import java.util.Arrays;

public class Operation {

    public byte[] karatsubaMultiply(byte[] x, byte[] y) {

        int digitsX = x.length;
        int digitsY = y.length;

        if(digitsX == 1) {
            return multiplyOneNumber(y, x[0]);
        } else if( digitsY == 1) {
            return multiplyOneNumber(x, y[0]);
        } else {

            int m = digitsX <= digitsY ? digitsX / 2 : digitsY / 2;

            //spliting the numbers by the smallest number half digits
            byte[] a = firstDigits(x, m);
            byte[] b = lastDigits(x, m);
            byte[] c = firstDigits(y, m);
            byte[] d = lastDigits(y, m);

            //revursivly calculating the multiplications
            //only 3 recursive calls
            byte[] ac = karatsubaMultiply(a, c);
            byte[] bd = karatsubaMultiply(b, d);
            byte[] aSumb = a.length >= b.length ? add(a, b) : add(b, a);
            byte[] cSumd = c.length >= d.length ? add(c, d) : add(d, c);
            byte[] sumParts = karatsubaMultiply(aSumb, cSumd);

            //moving the results by the apropriare amount
            byte[] movedAc = moveBy(ac, 2 * m);
            byte[] remainingMinusAC = sub(sumParts, ac);
            byte[] remaining = sub(remainingMinusAC, bd);
            byte[] moveRemaining = moveBy(remaining, m);

            //calculating step by step
            byte[] firstResult = movedAc.length >= moveRemaining.length ? add(movedAc, moveRemaining) : add(moveRemaining, movedAc);
            byte[] result = bd.length > firstResult.length ? add(bd, firstResult) : add(firstResult, bd);

            return result;
        }
    }

    public byte[] add (byte[] largest, byte[] smallest) {

        //result array is 1 size larger than the input to acount for the last carry
        byte[] result = new byte[largest.length + 1];
        byte carry = 0;
        byte temp = 0;
        byte extraSpace = 0;

        for(int i = result.length - 1, j = smallest.length - 1; i >= 0; i--, j--) {

            //checks if the resulting array need the first space or not
            if(i == 0 && carry != 0) {
                extraSpace = 1;
            }

            result[i] = carry;
            carry = 0;

            if (j >= 0) {

                temp = (byte)(result[i] + largest[i - 1] + smallest[j]);
                if(temp > 9) {
                    carry = (byte)(temp / 10);
                    temp = (byte)(temp % 10);
                }

                result[i] = temp;
            } else if (i != 0){
                temp = (byte)(result[i] + largest[i - 1]);
                if(temp > 9) {
                    carry = (byte)(temp / 10);
                    temp = (byte)(temp % 10);
                }

                result[i] = temp;
            }
        }


        if(extraSpace == 0) {

            byte[] newResult = new byte[result.length - 1];
            for(int i = 0, n = newResult.length; i < n; i++) {
                newResult[i] = result[i + 1];
            }
            return newResult;
        } else {
            return result;
        }

    }

    public byte[] sub (byte[] largest, byte[] smallest) {

        byte[] result = new byte[largest.length];
        int temp = 0;

        for(int i = result.length - 1, j = smallest.length - 1; i >= 0; i--, j--) {

            if(j >= 0) {

                if (largest[i] >= smallest[j]) {
                    result[i] = (byte)(largest[i] - smallest[j]);
                } else {
                    largest[i - 1] = (byte)(largest[i - 1] - 1);
                    //the value of temp can be >15 so w eneed int;
                    temp = largest[i] + 10;
                    result[i] = (byte)(temp - smallest[j]);
                }
            } else {
                result[i] = largest[i];
            }
        }

        return result;
    }

    public byte[] clasicMultiplication (byte[] largest, byte[] smallest) {

        byte[] permanentRow = new byte[largest.length + 1 + (smallest.length - 1)];
        Arrays.fill(permanentRow,(byte)0);
        byte[] tempRow;

        for(int i = smallest.length - 1, j = 0; i >= 0; i--, j++) {

            if(i == smallest.length - 1) {
                tempRow = multiplyOneNumber(largest, smallest[i]);
            }
            else {
                tempRow = moveBy(multiplyOneNumber(largest, smallest[i]), j);
            }

            permanentRow = add(permanentRow, tempRow);
        }

        //remove the 0 from the first pozitio if it is there
        if(permanentRow[0] == 0) {
            byte[] result = new byte[permanentRow.length - 1];

            for(int i = 1, n = permanentRow.length; i < n; i++) {
                result[i - 1] = permanentRow[i];
            }

            return result;

        } else {
            return permanentRow;
        }
    }

    //functions used by clasicmultiplication
    private byte[] multiplyOneNumber (byte[] numberArray, int oneNumber) {

        //result array is 1 size larger than the input to acount for the last carry
        byte[] result = new byte[numberArray.length + 1];
        byte carry = 0;
        byte temp = 0;
        int extraSpace = 0;

        for (int i = result.length - 1; i >= 0; i--) {

            //checks if the resulting array need the first space or not
            if(i == 0 && carry != 0) {
                extraSpace = 1;
            }

            result[i] = carry;
            carry = 0;

            if(i != 0) {
                temp = (byte)(result[i] + numberArray[i - 1] * oneNumber);

                if(temp > 9) {
                    carry = (byte)(temp / 10);
                    temp = (byte)(temp % 10);
                }

                result[i] = temp;
            }
        }

        if(extraSpace == 0) {
            byte[] newResult = new byte[result.length - 1];
            for(int i = 0, n = newResult.length; i < n; i++) {
                newResult[i] = result[i + 1];
            }
            return newResult;
        } else {
            return result;
        }
    }

    private byte[] moveBy (byte[] array, int moveIndex) {
        byte[] result = new byte[array.length + moveIndex];

        for(int i = 0, n = result.length; i < n; i++){

            if(i < array.length) {
                result[i] = array[i];
            } else{
                result[i] = 0;
            }
        }

        return result;
    }

    //functions used by karatsuba
    private byte[] firstDigits(byte[] array, int digits) {
        int n = array.length;
        byte[] newNumber = new byte[n - digits];

        for(int i = 0; i < n - digits; i++) {
            newNumber[i] = array[i];
        }

        return newNumber;
    }

    private byte[] lastDigits(byte[] array, int digits) {
        int n = array.length;
        byte[] newNumber = new byte[digits];

        for(int i = n - digits, j = 0; i < n; i++, j++) {
            newNumber[j] = array[i];
        }

        return newNumber;
    }
}
