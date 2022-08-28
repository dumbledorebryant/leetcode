package pass.OA.Cisco;

import java.io.IOException;
import java.util.Scanner;

public class Decode {
    public static void main(String[] args){
        try {
            decode();
        }catch(Exception e){
            System.out.print(e.toString());
        }

    }
    private static void decode() throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null || s.length() == 0) {
            System.out.print(0);
            return;
        };
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        // dp[0] 设为1是为了方便 dp[2]使用
        dp[1] = 1;
        for(int i =2; i <= s.length(); i++){
            int one = Integer.parseInt(s.substring(i-1, i));
            int two = Integer.parseInt(s.substring(i-2,i));
            if(one >= 0 && one <= 9){
                dp[i] += dp[i - 1];
            }
            if(two >= 10 && two <= 25){
                dp[i] += dp[i -2 ];
            }
        }
        System.out.print(dp[s.length()]);


    }
}

