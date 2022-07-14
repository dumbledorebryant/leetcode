package pass;

public class lc137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int bit_cnt = 0;
            for (int num : nums){
                bit_cnt += ((num >> i) & 1);
            }
            int bit = bit_cnt % 3;
            ans |= (bit << i);
        }
        return ans;
    }
}
