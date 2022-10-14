package pass;
import java.util.*;
public class lc792 {
    public int numMatchingSubseq(String s, String[] words) {
        List<List<String>> arr = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < 26; i++){
            arr.add(new ArrayList<String>());
        }
        for (int i = 0; i < length; i++){
            String str = words[i];
            arr.get(str.charAt(0) - 'a').add(str);
        }
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++){
            char ch = s.charAt(i);
            List<String> bucket = arr.get(ch - 'a');
            arr.set(ch - 'a', new ArrayList<>());
            int size = bucket.size();
            for (int j = 0; j < size; j++){
                String word = bucket.get(j);
                if (word.length() == 1) ans++;
                else {
                    word = word.substring(1);
                    arr.get(word.charAt(0) - 'a').add(word);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcde";
        String[] l = {"a","bb","acd","ace"};
        lc792 lc = new lc792();
        System.out.println(lc.numMatchingSubseq(s, l));
    }
}
