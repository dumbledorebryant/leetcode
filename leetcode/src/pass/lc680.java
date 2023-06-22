package pass;

public class lc680 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0; 
        int j = n - 1;
        while (i <= j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return valid(s, i, j - 1) || valid(s, i + 1, j);
        }
        return true;
    }
    public boolean valid(String s, int left, int right){
        while (left <= right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}
