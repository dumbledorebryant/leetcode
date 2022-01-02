package pass.jzoffer;

import java.util.Arrays;

public class jzoffer40 {
    int pos;
    public int[] getLeastNumbers(int[] arr, int k) {
        pos = k;
        int length = arr.length;
        int start = 0;
        int end = length - 1;
        quicksort(arr, start, end);
        return Arrays.copyOf(arr, k);
    }
    

    public void quicksort(int[] nums, int start, int end){
        if (start >= end) return;
        int index = start;
        int num = nums[index];
        int left = start;
        int right = end;
        while(left < right){
            while(nums[right] >= num && left < right) right--;
            while(nums[left] <= num && left < right) left++;
            swap(nums, left, right);
        }
        swap(nums, index, left);
        if (left == pos - 1) return;
        else if (left > pos){
            quicksort(nums, start, left - 1);
        }
        
        else quicksort(nums, left + 1, end);
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
