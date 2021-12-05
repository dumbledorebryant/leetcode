package pass;

public class lc215 {
    int pos = 0;
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) return nums[0];
        pos = length - k;
        
        return findKth(nums, 0, length - 1);
    }
    public int findKth(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while(left < right){
            while (nums[right] >= pivot && right > start) right--;
            while (nums[left] <= pivot && left < end) left++;
            
            if (left < right) swap(nums, left, right);
        }
        swap(nums, start, right);
        if (right == pos) return pivot;
        else if (right > pos) return findKth(nums, start, right - 1);
        else return findKth(nums, right + 1, end);
    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void test(){
        int[] nums = {2,1};
        int res = findKthLargest(nums, 1);
        System.out.println(res);
    }
}
