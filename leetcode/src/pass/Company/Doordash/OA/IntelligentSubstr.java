package pass.Company.Doordash.OA;

import java.util.*;

import pass.Company.Cisco.maxDiff;

public class IntelligentSubstr {
    public int getSpecialSubstring(String str, int k, String charValue){
        Map<Integer, Character> map = new HashMap<>();
        char[] chrs = charValue.toCharArray();
        for (int i = 0; i < 26; i++){
            map.put(i, chrs[i]);
        }

        int length = str.length();
        int count = 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < length) {
            char ch = str.charAt(right);
            int idx = ch - 'a';
            if (map.get(idx) == '0') count++;
            
            if (count > k){
                while (left < right && map.get(str.charAt(left) - 'a') != '0') left++;
                left++;
                count--;
            }
            if (count == k){
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "giraffe";
        int k = 2;
        String charValue = "10101111111111111111111111";
        String charValue2 = "01111001111111111011111111";
        IntelligentSubstr is = new IntelligentSubstr();
        System.out.println(is.getSpecialSubstring(str2, k, charValue2));
    }
}
