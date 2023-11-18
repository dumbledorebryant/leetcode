package pass;
import java.util.*;
class lc2282 {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++){
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = n - 1; j >= 0; j--){
                int num = heights[i][j];

                while (!dq.isEmpty() && num > dq.getLast()){
                    res[i][j]++;
                    dq.removeLast();
                }
                if (!dq.isEmpty()) res[i][j]++;
                if (dq.isEmpty() || num != dq.getLast())  dq.addLast(num);
            }
        }

        for (int j = 0; j < n; j++){
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = m - 1; i >= 0; i--){
               int num = heights[i][j];

               while (!dq.isEmpty() && num > dq.getLast()){
                   
                   res[i][j]++;
                   dq.removeLast();
               }
               if (!dq.isEmpty()) res[i][j]++;
               if (dq.isEmpty() || num != dq.getLast()) dq.addLast(num);
            }
        }

        return res;
    }   
}