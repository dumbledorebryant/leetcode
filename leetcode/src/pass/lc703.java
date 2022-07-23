package pass;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc703 {
    PriorityQueue<Integer> left;
    int size;
    public lc703(int k, int[] nums) {
        size = k;
        left = new PriorityQueue<>();
        for (int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if (left.size() < size){
            left.add(val);
        }
        else {
            if (left.peek() < val){
                left.poll();
                left.add(val);
            }
        }
        return left.peek();
    }
}
