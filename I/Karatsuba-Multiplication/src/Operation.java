import java.util.Arrays;

public class Operation {

    public int[] karatsubaMultiply(int[] x, int[] y) {
        //add the function

        int[] result = {0};
        return result;
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
        return permanentRow;
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

    private int[] moveBy (int[] array, int moveIndex) {
        int[] result = new int[array.length + moveIndex];

        for(int i = 0, n = array.length; i <= n; i++){

            if(i != n) {
                result[i] = array[i];
            } else  if(i == n){
                result[i] = 0;
            }
        }

        return result;
    }
}
