package pass;

import java.util.Deque;
import java.util.LinkedList;

public class lc769 {
    public int maxChunksToSorted(int[] arr) {
        
        int length = arr.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < length; i++){
            int num = arr[i];
            max = Math.max(max, num);
            if (max == i) count++;
        }
        return count;
    }
}
