package pass;
import java.util.*;
public class lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        int[][] matrix = new int[numRows][numRows];
        matrix[0][0] = 1;
        if (numRows == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            ans.add(list);
            return ans;
        }
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        for (int i = 2; i < numRows; i++){
            matrix[i][0] = 1;
            matrix[i][i] = 1;
        }

        for (int i = 2; i < numRows; i++){
            for (int j = 1; j < i - 1; j++){
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }

        for (int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                list.add(matrix[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
}
