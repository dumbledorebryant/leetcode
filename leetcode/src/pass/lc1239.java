package pass;

import java.util.List;

public class lc1239 {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, new StringBuilder());
    }

    public int backtrack(List<String> arr, int idx, StringBuilder sb){
        int n = arr.size();
        if (idx == n){
            String s = sb.toString();
            if (isValid(s)) return s.length();
            else return 0; 
        }

        int sizea = backtrack(arr, idx + 1, sb);
        String str = arr.get(idx);
        int len = str.length();
        sb.append(str);
        int sizeb = backtrack(arr, idx + 1, sb);
        int length = sb.length();
        sb.delete(length - len, length);
        return Math.max(sizea, sizeb);
    }

    public boolean isValid(String s){
        int[] chrs = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++){
            int idx = s.charAt(i) - 'a';
            chrs[idx]++;
            if (chrs[idx] > 1) return false;
        }
        return true;
    }
}
