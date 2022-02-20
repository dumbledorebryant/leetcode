package pass.weekly_contest.wc2022_02_19;

public class lc6012 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++){
            String str = String.valueOf(i);
            if (summ(str) % 2 == 0) ans++;
        }
        return ans;
    }
    public int summ(String str){
        int length = str.length();
        int ans = 0;
        for (int i = 0; i < length; i++){
            ans += Integer.parseInt(str.substring(i, i + 1));
        }
        return ans;
    }
}
