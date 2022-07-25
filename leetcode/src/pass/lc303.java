package pass;

public class lc303 {
    int[] list;
    public lc303(int[] nums) {
        int length = nums.length;
        list = new int[length + 1];
        int sum = 0;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            sum += num;
            list[i + 1] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return list[right + 1] - list[left];
    }
}
