package pass;

public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int length = numbers.length;
        int start = 0;
        int end = length - 1;
        while (start < end){
            int left = numbers[start];
            int right = numbers[end];
            if (left + right == target) {
                ans[0] = start + 1;
                ans[1] = end + 1;
                break;
            }
            else if (left + right > target){
                end--;
            }
            else start++;
        }
        return ans;
    }
}
