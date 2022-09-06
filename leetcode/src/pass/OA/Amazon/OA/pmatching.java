package pass.OA.Amazon.OA;

import java.util.Arrays;

public class pmatching {
    public int pmatching(String s1, String s2, int p){
        char[] chrs = s1.toCharArray();
        int length = s1.length();
        int len = s2.length();
        int[] tmp = new int[26];
        for (char ch : s2.toCharArray()){
            tmp[ch - 'a']++;
        }
    
        int score = 0;
        for (int i = 0; i < p; i++){
            int left = i;
            int right = i;
            int[] cur = new int[26];
            while (right < length){
                char ch = chrs[right];
                cur[ch - 'a']++;
                
                while ((right - left + p)/p == len){
                    if (Arrays.equals(cur, tmp)){
                        score++;
                    }
                    cur[chrs[left] - 'a']--;
                    left += p;
                }
                right += p;
            }
        }
        return score;
    }

    public static void main(String[] args) throws Exception 
    {
        String s1 = "acbbca";
        String s2 = "acb";
        pmatching pm = new pmatching();
        System.out.println(pm.pmatching(s1, s2, 2));
        System.out.println(pm.pmatching("a", "c", 1));
        System.out.println(pm.pmatching("a", "c", 2));
        System.out.println(pm.pmatching("acaccaa", "aac", 3));
        System.out.println(pm.pmatching("acaccaa", "aac", 2));
    }
}
