package pass;

public class lc1545 {
    public char findKthBit(int n, int k) {
        if (find(n, k) == 0) return '0';
        else return '1';
    }

    public int find(int n, int k){
        if (n == 1) return 0;
        int m = (int)Math.pow(2, n) - 1;
        int mid = m/2 + 1;
        if (k == mid) return 1;
        if (k < mid) return find(n - 1, k);
        else return 1 - find(n - 1, m + 1 - k);
    }
}
