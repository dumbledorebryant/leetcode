package pass;

public class lc704 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int num = bisearch(nums, 0, length - 1, target);
        return num;
    }
    public int bisearch(int[] array, int start, int end, int target){
        if (start > end) return -1;
        if (start == end){
            if (array[start] == target) return start;
            else return -1;
        }
        
        int length = end - start;
        int mid = start + length / 2;
        int numm = array[mid];
        if (numm == target) return mid;
        else if (numm < target) {
            return bisearch(array, mid + 1, end, target);
        }

        else {
            return bisearch(array, start, mid - 1, target);
        }
    }
}