package pass;

public class lc439 {
    public String parseTernary(String expression) {
        int l = -1;
        int r = -1;
        int n = expression.length();
        for (int i = 0; i < n; i++){
            char ch = expression.charAt(i);
            if (ch == '?') {
                l = i;
                break;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            char ch = expression.charAt(i);
            if (ch == '?') cnt++;
            if (ch == ':') {
                cnt--;
                if (cnt == 0){
                    r = i;
                    break;
                }
            }
        }

        if (l == -1){
            return expression;
        }
        
        String exp = expression.substring(0, l);
        if (exp.equals("T")) return parseTernary(expression.substring(l + 1, r));
        else return parseTernary(expression.substring(r + 1)); 
    }
}
