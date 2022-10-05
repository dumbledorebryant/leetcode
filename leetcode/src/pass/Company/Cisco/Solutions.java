package pass.Company.Cisco;
import java.util.*;
public class Solutions {
    public static void input(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] list = new int[len];
        for (int i = 0; i < len; i++){
            list[i] = in.nextInt();
        }
        in.close();
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[] money = new int[length + 1];
        money[0] = 0;
        money[1] = nums[0];
        for (int i = 2; i <= length; i++){
            money[i] = Math.max(money[i - 2] + nums[i - 1], money[i - 1]);
        }
        return money[length];
    }

    public int cisco_xy(int x, int y) {
        int ans = 0;
        for (int i = 0; i < x; i++){
            int sum = 0;
            while (i > 0){
                sum += (i % 10);
                i = i/10;
            }
            if (sum == y) ans++;
        }
        return ans;
    }

    public void cisco_prime(int[] list) {
        int length = list.length;
        for (int i = 0; i < length; i++){
            int num = list[i];
            if (checkp(num)) System.out.print("Prime ");
            else System.out.print("Composite ");
        }
    }
    public boolean checkp(int num){
        int max = (int)Math.sqrt(num);
        for (int i = 2; i <= max; i++){
            if (num % i == 0) return false;
        }
        return true;
    }


    

    public String validIPAddress(String queryIP) {
        String[] nums = queryIP.split("\\.");
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) return "Neither";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
    }

    private static int maxGap(int[] nums) {   // O(n) time complexity
        int n = nums.length;
        if (n < 2)
            return 0;

        int left, right, maxDiff;
        left = nums[0];
        right = nums[1];
        maxDiff = Math.max(0, right - left);
        for (int i = 1; i < n; i++) {
            if (right < nums[i]) {
                right = nums[i];
                maxDiff = Math.max(maxDiff, right - left);
            }
            if (left > nums[i]) {
                right = nums[i];
                left = nums[i];
            }
        }
        return maxDiff;
    }

    public int[][] Xuanzhuanshuzu1(int arry1[][], int m, int n) {
		//m表示原数组的行，n表示原数组的列	
        int arry2[][] = new int[n][m];
        int dst;
        dst = m - 1;//因为要从最后一列向前赋值
        for (int x = 0; x < m; x++, dst--) {
            for (int y = 0; y < n; y++) {
                arry2[y][dst] = arry1[x][y];
//在内循环中保持列不变，实现一列一列的赋值，同时也是从最后一列向前赋值
            }
        }
        return arry2;
    }


    public int cisco_numDecodings(String s) {
        int length = s.length();
        s = " " + s;
        int[] dp = new int[length + 1];
        char[] chrs = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= length; i++){
            int a = chrs[i] - '0';
            int b = a + (chrs[i - 1] - '0') * 10;
            if (a >= 0 && a <= 9){
                dp[i] = dp[i - 1];
            }

            if (b <= 26 && b >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[length];
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++){
            int num = nums[i - 1];
            if (dp[i - 1] > 0)
                dp[i] = dp[i - 1] + num;
            else dp[i] = num;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    
}
