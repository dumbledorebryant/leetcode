package pass;

public class lc169 {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int length = nums.length;
        int count = -1;
        for (int i = 0; i < length - 1; i += 2){
            int a = nums[i];
            int b = nums[i + 1];
            if (a == b) {
                if (count == -1) {
                    count = 1;
                    ans = a;
                }
                else if (a == ans){
                    count++;
                }
                else count--;
                if (count <= 0) ans = a;
            }
        }
        if (length % 2 == 1){
            if (count == 0 || count == -1) return nums[length - 1];
            else return ans;
        }
        return ans;
    }

    public void test(){
        int[] nums = {3,2,3};
        int res = majorityElement(nums);
        System.out.println(res);
    }
}
