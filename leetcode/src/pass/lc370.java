package pass;

public class lc370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates){
            int l = update[0];
            int r = update[1];
            int num = update[2];
            diff[l] += num; 
            if (r + 1 < length){
                diff[r + 1] -= num;
            }
        }
        int[] ans = new int[length];
        ans[0] = diff[0];
        for (int i = 1; i < length; i++){
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
