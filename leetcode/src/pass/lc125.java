package pass;
import java.util.regex.*;
public class lc125 {
    public boolean isPalindrome(String s) {
        String reg= "[^0-9a-zA-Z]+";
        String rep = "";
        Pattern p = Pattern.compile(reg);
        // get a matcher object
        Matcher m = p.matcher(s); 
        s = m.replaceAll(rep);
        System.out.println(s);
        return check(s.toLowerCase());
    }
    public boolean check(String str){
        int length = str.length();
        int left = 0;
        int right = length - 1;
        while (left < right){
            if (str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}
