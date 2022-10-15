package pass;

import java.util.*;

public class lc735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int ast : asteroids){
            if (deque.isEmpty()) {
                deque.add(ast);
                continue;
            }
            while (!deque.isEmpty() && deque.getLast() > 0 && ast < 0){
                int l = Math.abs(deque.getLast());
                int r = Math.abs(ast);
                if (l == r){
                    deque.removeLast();
                    ast = 0;
                    break;
                } 
                if (l > r){
                    ast = 0;
                    break;
                }
                if (l < r){
                    deque.removeLast();
                }
            }
            if (ast != 0) deque.add(ast);
        }
        int size = deque.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++){
            ans[i] = deque.removeFirst();
        }
        return ans;
    }
}
