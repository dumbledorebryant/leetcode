package pass;

public class lc772 {
    int idx;  // shared index to scan the input string (exactly once) between recursion calls
    public int calculate(String s) {
        idx = 0; // everytime this method is called, index should start from 0
        return calc2(s);
    }

    public int calc2(String s) { // exact calc2 code, except two lines of logic added to handle '(' and ')'          
        int res = 0, pre = 0, num = 0, n = s.length();
        char sign = '+';
        
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == '(') num = calc2(s); // recursively calculate everything between '(' and ')'
            else if (c >= '0' && c <= '9') num = num * 10 + c - '0'; // handle numbers more than one digits
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || idx == n) { // different stop point for calculation
                switch (sign) {
                    case '+': res += pre; pre =  num; break;
                    case '-': res += pre; pre = -num; break;
                    case '*': pre *= num; break;
                    case '/': pre /= num; break;
                }
                if (c == ')') return res + pre; // finish and exit current level (recursive) processing
                num = 0;
                sign = c;
            }
        }
        
        return res + pre;
    }
}
