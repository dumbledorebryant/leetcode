package pass;

import java.util.*;

public class lc735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int ast : asteroids){
            if (deque.isEmpty()) deque.add(ast);
            else {
                while (!deque.isEmpty()){
                    int pre = deque.peek();
                    if ((pre ^ ast) < 0){
                        if (Math.abs(pre) < Math.abs(ast)) deque.pop();
                        if (Math.abs(pre) == Math.abs(ast)) {
                            deque.pop();
                            break;
                        }
                        else break;
                    }
                    deque.add(ast);
                }
            }
        }
        int size = deque.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++){
            ans[i] = deque.poll();
        }
        return ans;
    }
}
