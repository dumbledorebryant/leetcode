package pass;

public class lc48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n - 1 - i; j++){
                int l = i;
                int r = j;
                temp = matrix[l][r];
                for (int m = 0; m < 3; m++){
                    matrix[l][r] = matrix[l][n - 1 - r];
                    int templ = l;
                    l = n - 1 - r;
                    r = templ;
                }
                matrix[l][r] = temp;
            }
        }        
    }
}
