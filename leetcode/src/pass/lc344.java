package pass;

public class lc344 {
    public void reverseString(char[] s) {
        int length = s.length;
        int i = 0; 
        int j = length - 1;
        while (i < j){
            swap(s, i, j);
            i++;
            j--;
        }
    }
    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
