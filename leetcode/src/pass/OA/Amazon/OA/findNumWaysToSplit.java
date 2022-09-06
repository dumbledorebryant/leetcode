package pass.OA.Amazon.OA;

public class findNumWaysToSplit {
    public int findNumWays(String s, int k){
        int[] prefix = new int[26];
        int[] surfix = new int[26];
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        for (int i = 0; i < length; i++){
            surfix[chrs[i] - 'a']++;
        }
        int count = 0;
        int ans = 0;
        for (int i = 0; i < length - 1; i++){
            char ch = chrs[i];
            int index = ch - 'a';
            prefix[index]++;
            surfix[index]--;
            if (prefix[index] == 1 && surfix[index] > 0){
                count++;
            }
            else if (surfix[index] == 0){
                count--;
            }
            if (count > k){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception 
    {
        String s = "abbcac"; // k = 1, ans = 2;
        String s1 = "adbccdbada"; // k = 2, ans = 1
        String s2 = "abbddcacd"; // k = 1, ans = 4
        findNumWaysToSplit ff = new findNumWaysToSplit();
        System.out.println(ff.findNumWays(s2, 2));
    }
}
