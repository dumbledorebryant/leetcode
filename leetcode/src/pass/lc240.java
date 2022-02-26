package pass;

public class lc240 {
    int t;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        t = target;
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, 0, n - 1, 0, m - 1);
    }
    public boolean search(int[][] matrix, int left, int right, int top, int bottom){
        if (left > right || top > bottom) return false;
        if (left == right){
            for (int i = top; i <= bottom; i++){
                if (matrix[i][left] == t) return true;
            }
            return false;
        }

        if (top == bottom){
            for (int i = left; i <= right; i++){
                if (matrix[top][i] == t) return true;
            }
            return false;
        }
        int cmid = left + ((right - left) >> 1);
        int row = top;
        while (row <= bottom && matrix[row][cmid] <= t){
            if (matrix[row][cmid] == t) return true;
            row++;
        }

        return search(matrix, left, cmid - 1, row, bottom)
            || search(matrix, cmid + 1, right, top, row - 1);
        
    }
    public boolean findtinmatrix(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0){
            int num = matrix[row][col];
            if (num == target) return true;
            else if (num < target) row++;
            else col--;
        }
        return false;
    }
}
