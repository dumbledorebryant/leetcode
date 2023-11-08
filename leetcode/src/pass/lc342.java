package pass;

public class lc342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return ((n & (n - 1)) == 0) && ((n & 0x55555555) != 0);
    }
}
