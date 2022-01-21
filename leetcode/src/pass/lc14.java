package pass;

public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        StringBuilder sb = new StringBuilder();
        String start = strs[0];
        for (int j = 0; j < start.length(); j++){
            char ch = start.charAt(j);
            for (int i = 1; i < length; i++){
                String str = strs[i];
                if (j > str.length() - 1) return sb.toString();
                char cur = str.charAt(j);
                if (cur == ch) continue;
                else return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
