package pass;

import java.util.*;

public class lc299 {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : s){
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        int length = g.length;
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < length; i++){
            char ch = g[i];
            if (ch == secret.charAt(i)) {
                bull++;
                count.put(ch, count.get(ch) - 1);
            }
            else {
                if (count.containsKey(ch)){
                    count.put(ch, count.get(ch) - 1);
                    cow++;
                }
            }
        }
        for (char key : count.keySet()){
            int num = count.get(key);
            if (num < 0) {
                cow += num;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append("A");
        sb.append(cow);
        sb.append("B");
        return sb.toString();
    }
}
