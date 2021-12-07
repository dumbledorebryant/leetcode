package pass;

public class lc190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int bit = ((n >> i) & 1);
            ans |= bit << (32- i);
        }
        return ans;
    }
    public void test(){
        System.out.println(reverseBits(964176192));
    }
}