package pass;

public class lc29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        boolean sign = (dividend > 0 ^ divisor > 0) ? true : false;
        int ans = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend - divisor >= 0){
            int temp = divisor;
            int bit = 0;
            while (dividend - temp >= 0){
                temp = temp << 1;
                bit++;
            }
            temp = divisor;
            dividend = dividend - (temp << (bit - 1));
            ans += (1 << (bit - 1));
        }

        if (sign) return -ans;
        else return ans;
    }
}
