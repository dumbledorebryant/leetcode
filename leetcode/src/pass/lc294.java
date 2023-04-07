package pass;

public class lc294 {
    public boolean canWin(String s) {
        char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '+' && chars[i+1] == '+') {
                    chars[i] = '-';
                    chars[i+1] = '-';
                    String next = new String(chars);
                    if (!canWin(next))
                        return true;
                    chars[i] = '+';
                    chars[i+1] = '+';
                }
            }
            return false;
    }
}
