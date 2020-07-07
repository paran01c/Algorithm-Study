public class Operation {

    public int[] KaratsubaMultiply(int[] x, int[] y, int digitsX, int digitsY) {
        //add the function
        return new int[1];
    }

    //x is the large number y is the small number
    public int[] Add (int[] largest, int[] smallest) {
        int[] result = new int[largest.length + 1];
        int carry = 0;
        int temp = 0;

        for(int i = result.length - 1, j = smallest.length - 1; i >= 0; i--, j--) {

            result[i] = carry;
            carry = 0;

            if(j >= 0) {

                temp = result[i] + largest[i - 1] + smallest[j];
                if(temp > 9) {
                    carry = temp / 10;
                    temp = temp % 10;
                }

                result[i] = temp;
            } else if(i != 0){
                temp = result[i] + largest[i - 1];
                if(temp > 9) {
                    carry = temp / 10;
                    temp = temp % 10;
                }

                result[i] = temp;
            }
        }


        if(result[0] == 0) {
            int[] newResult = new int[result.length - 1];
            for(int i = 0, n = newResult.length; i < n; i++) {
                newResult[i] = result[i + 1];
            }
            return newResult;
        } else {
            return result;
        }

    }

    public int[] Multiply (int[] x, int[] y) {
        //add the function
        return new int[1];
    }
}
