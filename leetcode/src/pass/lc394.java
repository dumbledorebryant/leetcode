package pass;

import java.util.ArrayDeque;

public class lc394 {
    int i;
    public String decodeString(String s) {
        return decode(s, 0);
    }

    public String decode(String s, int idx){
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int num = 0;
        for (i = idx; i < n; i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                num = 10 * num + ch - '0';
            }
            else if (ch == '['){
                String str = decode(s, i + 1);
                for (int j = 0; j < num; j++){
                    ans.append(str);
                }
                num = 0;
            }
            else if (ch == ']'){
                return ans.toString();
            }
            else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        lc394 lc = new lc394();
        System.out.println(lc.decodeString(s));
    }
}
