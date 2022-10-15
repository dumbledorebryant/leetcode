package pass;

public class lc556 {
    public int nextGreaterElement(int n) {
        char[] chrs = String.valueOf(n).toCharArray();
        int length = chrs.length;
        
        int i = length - 2;
        while (i >= 0 && chrs[i] >= chrs[i + 1]){
            i--;
        }
        if (i == -1) return -1;

        int j = length - 1;
        while (j > i && chrs[j] <= chrs[i]){
            j--;
        }
        swap(chrs, i, j);
        reverse(chrs, i + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(chrs);
        String res = sb.toString();
        long ans = Long.parseLong(res);
        if (ans > Integer.MAX_VALUE) return -1;
        else return Integer.valueOf(res);
    }

    public void swap(char[] chrs, int i, int j){
        char temp = chrs[i];
        chrs[i] = chrs[j];
        chrs[j] = temp;
    }
    public void reverse(char[] chrs, int i){
        int length = chrs.length;
        int l = i;
        int r = length - 1;
        while (l < r){
            swap(chrs, l, r);
            l++;
            r--;
        }
    }
    public static void main(String[] args) {
        lc556 lc = new lc556();
        System.out.println(lc.nextGreaterElement(21));
    }
}
