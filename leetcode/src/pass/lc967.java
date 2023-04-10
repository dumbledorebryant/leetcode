package pass;

import java.util.*;

public class lc967 {
    Set<String> ans = new HashSet<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++)
            backtrack(1, k, i, n, new StringBuilder());
        int size = ans.size();
        int[] arr = new int[size];
        int i = 0;
        for (String str : ans){
            arr[i] = Integer.valueOf(str);
            i++;
        }
        return arr;
    }
    public void backtrack(int idx, int k, int num, int n, StringBuilder sb){
        if (num < 0 || num > 9){
            return;
        }
        if (idx == n) {
            sb.append(num);
            ans.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(num);
        backtrack(idx + 1, k, num + k, n, sb);
        backtrack(idx + 1, k, num - k, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
