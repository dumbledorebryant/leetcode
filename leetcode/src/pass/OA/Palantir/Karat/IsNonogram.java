package pass.OA.Palantir.Karat;

import javax.naming.InitialContext;

public class IsNonogram {
    public boolean isRowValid(int[][] matrix, int[][] rows){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            int index = 0;
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    if (rows[index].length == 0) return false;
                }
                for (int k = 0; k < rows[i][index]; k++){
                    if (j + k >= m || matrix[i][j + k] != 0){
                        return false;
                    }
                }
                j += rows[i][index];
                index++;
            }
            if (index != rows[i].length) return false;
        }
        return true;
    }
}
