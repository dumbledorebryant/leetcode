package pass;

public class lc221 {
    public int maximalSquare(char[][] matrix) {
        
    }

    public int check(char[][] matrix, int i, int j){
        if (matrix[i][j] == '0') return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m - i + 1, n - j + 1);
        for (int k = 0; k < len; k++){
            
        }
    }
}
