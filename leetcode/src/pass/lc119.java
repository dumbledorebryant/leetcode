package pass;

import java.util.*;

public class lc119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0){
            return ans;
        }
        ans.add(1);
        if (rowIndex == 1){
            ans.add(1);
            return ans;
        }
        else {
            while (rowIndex >= 2){
                ans = nextRow(ans);
                rowIndex--;
            }
        }
        return ans;
    }
    public List<Integer> nextRow(List<Integer> cur){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int size = cur.size();
        for (int i = 0; i < size - 1; i++){
            ans.add(cur.get(i) + cur.get(i + 1));
        }
        ans.add(1);
        return ans;
    }
}
