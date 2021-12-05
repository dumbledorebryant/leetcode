package pass;

public class lc1143undone {
    public int longestCommonSubsequence(String text1, String text2) {
        int count = 0;
        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();
        int m = chs1.length;
        int n = chs2.length;
        if (m == 0 || n == 0) return 0;
        int length = Math.min(m, n);
        int[] array = new int[length];
        int left = 0;
        int right = 0;
        for (int i = 1; i <= length; i++){
            
        }
        return count;
    }
}
