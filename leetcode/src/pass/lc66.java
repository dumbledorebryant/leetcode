package pass;

public class lc66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int lcarry = 1;
        int index = len - 1;
        for (int i = 0; i < len; i++){
            int carry = digits[len - 1 - i] == 9 ? 1 : 0;
            lcarry = carry & lcarry;
            if (lcarry == 1) index = len - 1 - i - 1;
        }
        int length = len + lcarry;
        int[] res = new int[length];
        if (lcarry == 1){
            res[0] = 1;
            for (int i = 1; i < length; i++)
            {
                res[i] = 0;
            }
        }
        else {
            for (int i = 0; i < index; i++){
                res[i] = digits[i];
            }
            res[index] = digits[index] + 1;
            for (int i = index + 1; i < len; i++){
                res[i] = 0;
            }
        }

        return res;
    }
}