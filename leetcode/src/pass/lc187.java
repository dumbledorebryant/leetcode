package pass;
import java.util.*;
public class lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++){
            char ch = s.charAt(i);
            switch(ch){
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> set = new HashSet<>();

        int L = 10;
        int R = 4;
        int rl = (int)Math.pow(R, L - 1);
        int hash = 0;
        int left = 0; 
        int right = 0;
        while (right < length){
            hash = hash * R + nums[right];
            right++;
            if (right - left == L){
                if (seen.contains(hash)){
                    set.add(s.substring(left, right));
                }
                else {
                    seen.add(hash);
                }
                hash = hash - nums[left] * rl;
                left++;
            }
        }
        return new ArrayList<>(set);
    }
}
