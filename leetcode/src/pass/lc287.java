package pass;

public class lc287 {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int bit = 0;
            int ori = 0;
            for (int j = 0; j < length; j++){
                int num = nums[j];
                bit += ((num >> i) & 1);
                if (j >= 1) ori += (((j + 1) >> i) & 1);
            }
            if (bit > ori){
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
