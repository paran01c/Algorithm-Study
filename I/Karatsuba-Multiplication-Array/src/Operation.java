import java.util.Arrays;

public class Operation {

    public int[] karatsubaMultiply(int[] x, int[] y) {


        int digitsX = x.length;
        int digitsY = y.length;

        if(digitsX == 1) {
            return multiplyOneNumber(y, x[0]);
        } else if( digitsY == 1) {
            return multiplyOneNumber(x, y[0]);
        } else {

            int m = digitsX <= digitsY ? digitsX / 2 : digitsY / 2;

            //spliting the numbers by the smallest number half digits
            int[] a = firstDigits(x, m);
            int[] b = lastDigits(x, m);
            int[] c = firstDigits(y, m);
            int[] d = lastDigits(y, m);

            //revursivly calculating the multiplications
            int[] ac = karatsubaMultiply(a, c);
            int[] bd = karatsubaMultiply(b, d);
            int[] ad = karatsubaMultiply(a, d);
            int[] bc = karatsubaMultiply(b, c);

            //moving the results by the apropriare amount
            int[] movedAc = moveBy(ac, 2 * m);
            int[] remaining = ad.length >= bc.length ? add(ad, bc) : add(bc, ad);
            int[] moveRemaining = moveBy(remaining, m);

            //calculating step by step
            int[] firstResult = movedAc.length >= moveRemaining.length ? add(movedAc, moveRemaining) : add(moveRemaining, movedAc);
            int[] result = bd.length > firstResult.length ? add(bd, firstResult) : add(firstResult, bd);

            return result;
        }
    }

    public int[] add (int[] largest, int[] smallest) {

        //result array is 1 size larger than the input to acount for the last carry
        int[] result = new int[largest.length + 1];
        int carry = 0;
        int temp = 0;
        int extraSpace = 0;

        for(int i = result.length - 1, j = smallest.length - 1; i >= 0; i--, j--) {

            //checks if the resulting array need the first space or not
            if(i == 0 && carry != 0) {
                extraSpace = 1;
            }

            result[i] = carry;
            carry = 0;

            if (j >= 0) {

                temp = result[i] + largest[i - 1] + smallest[j];
                if(temp > 9) {
                    carry = temp / 10;
                    temp = temp % 10;
                }

                result[i] = temp;
            } else if (i != 0){
                temp = result[i] + largest[i - 1];
                if(temp > 9) {
                    carry = temp / 10;
                    temp = temp % 10;
                }

                result[i] = temp;
            }


        }


        if(extraSpace == 0) {

            int[] newResult = new int[result.length - 1];
            for(int i = 0, n = newResult.length; i < n; i++) {
                newResult[i] = result[i + 1];
            }
            return newResult;
        } else {
            return result;
        }

    }

    public int[] clasicMultiplication (int[] largest, int[] smallest) {
        int[] permanentRow = new int[largest.length + 1 + (smallest.length - 1)];
        Arrays.fill(permanentRow,0);
        int[] tempRow;

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
            int[] result = new int[permanentRow.length - 1];

            for(int i = 1, n = permanentRow.length; i < n; i++) {
                result[i - 1] = permanentRow[i];
            }

            return result;

        } else {
            return permanentRow;
        }
    }

    //functions used by clasicmultiplication
    private int[] multiplyOneNumber (int[] numberArray, int oneNumber) {

        //result array is 1 size larger than the input to acount for the last carry
        int[] result = new int[numberArray.length + 1];
        int carry = 0;
        int temp = 0;
        int extraSpace = 0;

        for (int i = result.length - 1; i >= 0; i--) {

            //checks if the resulting array need the first space or not
            if(i == 0 && carry != 0) {
                extraSpace = 1;
            }

            result[i] = carry;
            carry = 0;

            if(i != 0) {
                temp = result[i] + numberArray[i - 1] * oneNumber;

                if(temp > 9) {
                    carry = temp / 10;
                    temp = temp % 10;
                }

                result[i] = temp;
            }
        }

        if(extraSpace == 0) {
            int[] newResult = new int[result.length - 1];
            for(int i = 0, n = newResult.length; i < n; i++) {
                newResult[i] = result[i + 1];
            }
            return newResult;
        } else {
            return result;
        }
    }

    public int[] moveBy (int[] array, int moveIndex) {
        int[] result = new int[array.length + moveIndex];

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
    public int[] firstDigits(int[] array, int digits) {
        int n = array.length;
        int[] newNumber = new int[n - digits];

        for(int i = 0; i < n - digits; i++) {
            newNumber[i] = array[i];
        }

        return newNumber;
    }

    public int[] lastDigits(int[] array, int digits) {
        int n = array.length;
        int[] newNumber = new int[digits];

        for(int i = n - digits, j = 0; i < n; i++, j++) {
            newNumber[j] = array[i];
        }

        return newNumber;
    }
}
