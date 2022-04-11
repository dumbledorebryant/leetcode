package pass;
import java.util.*;
public class lc378 {
    public int kthSmallest(int[][] matrix, int k) {        
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int[][] matrix, int mid, int k, int n){
        int i = n - 1;
        int j = 0;
        int cnt = 0;
        while (i >= 0 && j < n){
            int num = matrix[i][j];
            if (num <= mid){
                cnt += (i + 1); 
                j++;
            } 
            else {
                i--;
            }
        }
        return cnt >= k;
    }
}
