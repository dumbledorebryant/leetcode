package pass;

public class lc1774 {
    int[] used;
    int res = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int m = baseCosts.length;
        int n = toppingCosts.length;
        used = new int[n];

        for (int i = 0; i < m; i++){
            backtrack(toppingCosts, target, baseCosts[i], 0);
        }
        return res;
    }

    public void backtrack(int[] toppingCosts, int target, int cur, int idx){
        int n = toppingCosts.length;
        
        if (Math.abs(cur - target) <= Math.abs(res - target)){
            if (Math.abs(cur - target) == Math.abs(res - target)){
                if (cur < res){
                    res = cur;
                }
            }
            else res = cur;
        }

        for (int i = idx; i < n; i++){
            int num = toppingCosts[i];
            if (used[i] == 2) continue;

            used[i]++;
            cur += num;
            backtrack(toppingCosts, target, cur, i);
            cur -= num;
            used[i]--;
        }
    }
}
