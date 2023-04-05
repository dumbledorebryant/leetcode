package pass;

import java.util.*;

public class lc255 {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new LinkedList<>();
        int length = preorder.length;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++){
            int num = preorder[i];
            if (num < min) return false;
            while (!stack.isEmpty() && stack.getLast() < num){
                min = stack.removeLast();
            }
            stack.addLast(num);
        }
        return true;
    }
}
