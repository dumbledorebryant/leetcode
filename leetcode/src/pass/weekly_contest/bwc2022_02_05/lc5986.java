package pass.weekly_contest.bwc2022_02_05;

import java.util.*;

public class lc5986 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minute = targetSeconds / 60;
        int second = targetSeconds % 60;
        int ret = Integer.MAX_VALUE;

        while (minute > 99) {
            minute--;
            second += 60;
        }

        while (second <= 99) {
            String s = String.format("%02d", minute) + String.format("%02d", second);
            ret = Math.min(ret, cal(s, startAt, moveCost, pushCost));

            if (minute > 0) {
                minute--;
                second += 60;
            } else {
                break;
            }
        }
        return ret;
    }
    public int minTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int a = targetSeconds/60;
        int b = targetSeconds%60;
        List<String> res = new ArrayList<>();
        if (a == 0){
            res.add(String.valueOf(targetSeconds));
        }
        if (b < 40){
            String pa = a == 1 ? "" : String.valueOf(a - 1);
            pa += String.valueOf(b + 60);
            res.add(pa);
            String pb = "";
            if (b >= 10)
                pb = String.valueOf(a) + String.valueOf(b);
            else pb = String.valueOf(a) + "0" + String.valueOf(b);
            res.add(pb);
        }
        if (b >= 40){
            String pa = String.valueOf(a) + String.valueOf(b);
            res.add(pa);
        }
        int length = res.size();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            int cost = cal(res.get(i), startAt, moveCost, pushCost);
            System.out.println(cost);
            ans = Math.min(ans, cost);
        }
        return ans;
    }
    public int calc(String str, int startAt, int moveCost, int pushCost){
        int length = str.length();
        int mcount = 0;
        for (int i = 1; i < length; i++){
            if (str.charAt(i) != str.charAt(i - 1)) mcount++;
        }
        String stt = str.substring(0, 1);
        String stat = String.valueOf(startAt);
        if (!stt.equals(stat)) {
            mcount++;
        }
        int ans = mcount * moveCost + length * pushCost;
        return ans;
    }
    private int cal(String s, int startAt, int moveCost, int pushCost) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        int ret = 0;
        char now = (char) (startAt + '0');
        while (i < s.length()) {
            if (s.charAt(i) != now) {
                ret += moveCost;
                now = s.charAt(i);
            }
            ret += pushCost;
            i++;
        }
        return ret;
    }
}
