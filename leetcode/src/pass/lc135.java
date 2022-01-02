package pass;

public class lc135 {
    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length <= 1) return length;
        
        int[] counts = new int[length];
        for (int i = 0; i < length; i++){
            counts[i] = 1;
        }
        for (int i = 1; i < length; i++){
            if (ratings[i] > ratings[i - 1]){
                counts[i] = counts[i - 1] + 1;
            }
            else if (ratings[i] < ratings[i - 1]){
                int j = i;
                while (j >= 1 && ratings[j] < ratings[j - 1]){
                    if (counts[j] >= counts[j - 1]) counts[j - 1] += 1;
                    j--;
                }
            }
        }


        int count = 0;
        for (int i = 0; i < length; i++){
            count += counts[i];
        }
        return count;
    }

    public void test(){
        int[] input = {1,3,2,2,1};
        System.out.println(candy(input));
    }
}
