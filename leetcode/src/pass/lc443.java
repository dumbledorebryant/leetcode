package pass;

public class lc443 {
    public int compress(char[] chars) {
        int length = chars.length;
        int idx = 0;
        for (int i = 0; i < length; i++){
            char ch = chars[i];
            chars[idx] = ch;
            i++;
            int num = 1;
            while (i < length && chars[i] == ch){
                i++;
                num++;
            }
            i--;
            idx++;
            if (num > 1){
                String str = String.valueOf(num);
                int len = str.length();
                for (int j = 0; j < len; j++){
                    chars[idx + j] = str.charAt(j);
                }
                idx += len;
            }
        }

        return idx;
    }
}
