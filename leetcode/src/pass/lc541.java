package pass;

public class lc541 {
    public String reverseStr(String s, int k) {
        char[] chrs = s.toCharArray();
        int n = s.length();
        int l = 0;
        int r = 0;
        while (r < n){
            if (r + k <= n){
                for (int i = r; i < r + k/2; i++){
                    System.out.println(i);
                    System.out.println(r + k - i - 1);
                    swap(chrs, i, r + r + k - i - 1);
                }
                
                System.out.println(new String(chrs));
            }
            else {
                for (int i = r; i < r + (n - r)/2; i++){
                    swap(chrs, i, n - 1 - (i - r));
                }
            }
            r += (2 * k);
        }
        return new String(chrs);
    }

    public void swap(char[] chrs, int i, int j){
        char ch = chrs[i];
        chrs[i] = chrs[j];
        chrs[j] = ch;
    }
}
