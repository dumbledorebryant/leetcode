package pass.Company.Doordash.OA;

import java.util.*;

public class TaskCompletion {
    public int getMaxReward(int k, int[] reward1, int[] reward2){
        int ans = 0;
        int length = reward1.length;
        for (int i = 0; i < length; i++){
            ans += reward2[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < length; i++){
            pq.add(reward1[i] - reward2[i]);
        }
        for (int i = 0; i < k; i++){
            ans += pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] reward1 = {5,4,3,2,1};
        int[] reward2 = {1,2,3,4,5};
        int k = 3;
        TaskCompletion tc = new TaskCompletion();
        System.out.println(tc.getMaxReward(k, reward1, reward2));
    }
}
