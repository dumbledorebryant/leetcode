package pass;

public class lc80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int pre = 10001;
        int count = 2;
        int cur = 0;
        for (int i = 0; i < n; i++){
            int num = nums[i];
            if (count > 0 && num == pre){
                swap(nums, i, cur);
                count--;
                cur++;
            }
            else if (num == pre && count == 0){
                continue;
            }
            else if (num != pre){
                count = 1;
                pre = num;
                swap(nums, i, cur);
                cur++;
            }
        }
        return cur;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
