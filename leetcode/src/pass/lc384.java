package pass;

import java.util.Arrays;
import java.util.Random;


public class lc384 {
    int[] nums;
    Random rand = new Random();
    
    public lc384(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++){
            int r = i + rand.nextInt(n - i);
            swap(copy, i, r);
        }
        return copy;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
