package pass.OA.Doordash;

import java.util.*;

public class StockTrend {
    static int[] stockTrendAnalysis(int[] price, int k) {
        List<int[]> nums = new ArrayList<>(price.length);
        for (int i = 0; i < price.length; i++) {
            nums.add(new int[]{price[i], i});
        }
        nums.sort((a, b) -> b[0] - a[0]);

        int[] ans = new int[price.length];
        Arrays.fill(ans, -1);

        TreeSet<Integer> index = new TreeSet<>();
        Stack<Integer> buffer = new Stack<>();
        for (int i = 0; i < nums.size(); i++) {
            int curNum = nums.get(i)[0];
            int curIdx = nums.get(i)[1];

            int cnt = 0;
            for (int idx : index.tailSet(curIdx)) {
                cnt++;
                if (cnt == k) {
                    ans[curIdx] = idx+1;
                    break;
                }
            }

            buffer.push(curIdx);
            if (i == nums.size() - 1 || nums.get(i+1)[0] != curNum) {
                while (!buffer.isEmpty()) {
                    index.add(buffer.pop());
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(stockTrendAnalysis(new int[]{1,4,2,5,3}, 2)));
        System.out.println(Arrays.toString(stockTrendAnalysis(new int[]{3,4,2,6,5}, 2)));
        System.out.println(Arrays.toString(stockTrendAnalysis(new int[]{3,1,2,4,5}, 2)));

        System.out.println(Arrays.toString(stockTrendAnalysis(new int[]{3,2,2,4,5}, 2)));
    }
}
