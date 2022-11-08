package pass;

public class lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m - 1;
        while (l < r){
            int mid = l + (r - l)/2;
            int num = matrix[l][n - 1];
            if (target > num){
                l = mid + 1;
            }
            else if (target == num) return true;
            else {
                r = mid;
            }
        }

        int a = 0; 
        int b = n - 1;
        while (a <= b){
            int mid = a + (b - a)/2;
            int num = matrix[l][mid];
            if (num < target){
                a = mid + 1;
            }
            else if (num == target) return true;
            else {
                b = mid - 1;
            }
        }
        return false;
    }
}
