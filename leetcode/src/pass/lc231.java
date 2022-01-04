package pass;

public class lc231 {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++){
            int bit = (n >> i) & 1;
            if (bit == 1) count++;
        }
        if (((n >> 31) & 1) == 1 && count == 1) return false;
        if (count != 1) return false;
        return true;
    }
}
