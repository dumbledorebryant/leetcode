package pass.Company.Palantir.Karat;
import java.util.*;
public class LCSubarray {
    public List<String> maxLenLCSubarray(String[] user1, String[] user2){
        int m = user1.length;
        int n = user2.length;
        int[][] dp = new int[m + 1][n + 1];

        List<String> ans = new ArrayList<>();
        int count = -1;
        for (int i = 1; i <= m; i++){
            String str1 = user1[i - 1];
            for (int j = 1; j <= n; j++){
                String str2 = user2[j - 1];
                if (str1.equals(str2)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > count){
                        count = dp[i][j];
                        List<String> tmp = new ArrayList<>();
                        for (int k = 0; k < count; k++){
                            tmp.add(user1[i - count + k]);
                        }
                        ans = new ArrayList<>(tmp);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        LCSubarray lcs = new LCSubarray();
        System.out.println(lcs.maxLenLCSubarray(user0, user1));
    }
}
