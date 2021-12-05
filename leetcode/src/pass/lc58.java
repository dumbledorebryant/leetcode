package pass;

public class lc58 {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int end = length - 1;
        int start = -1;
        while (end >= 0){
            if (s.charAt(end) == ' '){
                end--;
            }
            else {
                start = end;
                break;
            }
        }

        while (start >= 0){
            if (s.charAt(start) != ' '){
                start--;
            }
            else break;
        }

        return end - start;
    }
}
