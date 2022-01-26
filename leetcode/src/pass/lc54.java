package pass;

import java.util.ArrayList;
import java.util.List;

public class lc54 {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int last = m * n;
        int count = 1;
        while (count <= last){
            for (int i = left; i <= right; i++){
                list.add(matrix[top][i]);
                count++;
            }
            top++;
            if (count > last) break;
            for (int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
                count++;
            }
            right--;

            for (int i = right; i >= left; i--){
                list.add(matrix[bottom][i]);
                count++;
                if (count > last) break;
            }
            bottom--;
            if (count > last) break;

            for (int i = bottom; i >= top; i--){
                list.add(matrix[i][left]);
                count++;
                if (count > last) break;
            }
            left++;
        }
        return list;
    }    
}