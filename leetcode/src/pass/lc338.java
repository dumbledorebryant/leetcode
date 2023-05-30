package pass;

class lc388{
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++){
            if (offset * 2 == i){
                offset *= 2;
            }
            ans[i] = ans[i - offset] + 1;
        }
        return ans;
    }
}