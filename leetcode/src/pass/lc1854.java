package pass;

public class lc1854 {
    public int maximumPopulation(int[][] logs) {
        int[] prefix = new int[101];
        for (int[] life : logs){
            int s = life[0] - 1950;
            int e = life[1] - 1950;
            prefix[s]++;
            prefix[e]--;
        }
        int max = prefix[0];
        int pre = prefix[0];
        int ans = 1950;
        for (int i = 1; i < 101; i++){
            pre += prefix[i];
            if (max < pre){
                max = pre;
                ans = i + 1950;
            }
        }
        return ans;
    }
}
