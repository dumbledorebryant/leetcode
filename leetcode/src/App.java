import java.util.*;

public class App  {
    
    // string a, b, longest common substring
    // abcdef cdeadf
    public static void main(String[] args) throws Exception 
    {
        String a = "abcd";
        String b = "abc";

        System.out.println(lcbString(a, b));
    }

    static String ans = "";

    public static String lcbString(String a, String b){
        StringBuilder sb = new StringBuilder();

        traceback(a, b, 0, 0, sb);
        return ans;
    } 
    public static void traceback(String a, String b, int i, int j, StringBuilder sb){
        int m = a.length();
        int n = b.length();

        String str = sb.toString();
        int len = str.length();
        if (len > ans.length()){
            ans = str;
        }

        if (i == m || j == n){
            return;
        }

        char ach = a.charAt(i);
        char bch = b.charAt(j);

        if (ach == bch){
            sb.append(ach);
            traceback(a, b, i + 1, j + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        else {
            traceback(a, b, i + 1, j, new StringBuilder());
            traceback(a, b, i, j + 1, new StringBuilder());
        }
    }
}




