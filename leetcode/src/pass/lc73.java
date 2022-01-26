package pass;

import java.lang.reflect.Array;
import java.util.*;

public class lc73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    rows.put(i, 0);
                    cols.put(j, 0);
                }
            }
        }
        for (int row : rows.keySet()){
            Arrays.fill(matrix[row], 0);
        }
        for (int col : cols.keySet()){
            for (int i = 0; i < m; i++){
                matrix[i][col] = 0;
            }
        }
    }
}
