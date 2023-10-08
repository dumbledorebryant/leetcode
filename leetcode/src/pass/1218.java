package pass;

public class 1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int num = arr[i];
            int left = num - difference;
            if (map.containsKey(left)){
                map.put(num, map.get(left) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        int ans = 0;
        for (int key : map.keySet()){
            ans = Math.max(ans, map.get(key));
        }

        return ans;
    }
}
