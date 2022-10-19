package pass;

public class lc2340 {
    public int minimumSwaps(int[] nums) {
        int imax = 0;
        int imin = 0;
        int max = 0;
        int min = 100001;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (num >= max){
                imax = i;
                max = num;
            }
            if (num < min){
                imin = i;
                min = num;
            }
        }
        if (imax <= imin){
            return imin + length - imax - 1;
        }
        else return imin + length - imax - 2;
    }
}
