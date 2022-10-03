package pass.OA.Doordash;

public class DiffValue {
    public int findDiffValue(String first, String second){
        int ans = 0;
        int min = 0;
        int max = 0;
        int ptr = 0;
        int p = 0;
        int n = first.length();
        int m = second.length();
        while (ptr < n && p < m){
            char f = first.charAt(ptr);
            char s = second.charAt(p);
            if (f == s){
                p++;
                ptr++;
            }
            else {
                ptr++;
            }
        }
        if (ptr == n) min = p;
        else {}

        ptr = n - 1;
        p = m - 1;
        while (ptr >= 0 && p >= 0){
            char f = first.charAt(ptr);
            char s = second.charAt(p);
            if (f == s){
                p--;
                ptr--;
            }
            else {
                ptr--;
            }
        }
        if (ptr < 0) max = p;
        else {}

        if (min <= max){
            return max - min + 1;
        }
        if (min > max){

        }

        return ans;
    }
}
