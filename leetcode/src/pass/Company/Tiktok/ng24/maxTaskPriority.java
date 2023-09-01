package pass.Company.Tiktok.ng24;
import java.util.*;
public class maxTaskPriority {
    public int maximumPriority(int n, int[] priority, int x, int y){
        Arrays.sort(priority);
        int length = priority.length;
        int left = 0; int right = length - 1;
        while (left <= right){
            int temp = priority[left];
            priority[left] = priority[right];
            priority[right] = temp;
            left++;
            right--;
        }

        int sum = 0;
        int cd = 0;

        for (int i = 0; i < y; i++){
            if (cd == 0) {
                sum += priority[cd];
            }
            else if (cd == x + 1){
                cd = 0;
                sum += priority[cd];
            }
            else {
                if (cd <= n - 1){
                    sum += priority[cd];
                }
            }
            cd++;
        }
        return sum;
    }
}
