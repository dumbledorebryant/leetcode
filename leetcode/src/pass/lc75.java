package pass;

public class lc75 {
    public void sortColors(int[] nums) 
    {
        int counta = 0;
        int countb = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++){
            if (nums[i] == 0){counta++;}
            if (nums[i] == 1){countb++;}
        }
        for (int i = 0; i < counta; i++){nums[i] = 0;}
        int indexx = counta + countb;
        for (int i = counta; i < indexx; i++){
            nums[i] = 1;
        }

        for (int i = indexx; i < length; i++){
            nums[i] = 2;
        }
        return;
    }
}