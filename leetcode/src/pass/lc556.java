package pass;

public class lc556 {
    public int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder(n);
        int length = sb.length();
        int i = length - 1;
        for (; i >= 1; i--){
            if (sb.charAt(i) < sb.charAt(i - 1)) break;
        }      
        if (i == 0) return -1;
        int j = length - 1;
        while (j >= 0 && sb.charAt(i) >= sb.charAt(j)){
            j--;
        }
        swap(sb, i, j);
        int left = i + 1;
        int right = length - 1;
        while (left < right){
            swap(sb, left, right);
            left++;
            right--;
        }
        String str = sb.toString();
        return str.compareTo(String.valueOf(Integer.MAX_VALUE)) < 0 ? Integer.valueOf(str) : -1;
    }
    public void swap(StringBuilder sb, int i, int j){
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }
}
