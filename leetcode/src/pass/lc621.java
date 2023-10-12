package pass;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
                return tasks.length;
            }

            HashMap<Character,Integer> map = new HashMap<>();


            for(int i=0;i<tasks.length;i++){
                map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            }

            // by default pq is min_heap
            // thats why reversOrder
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            //.Add all the frequency values
            pq.addAll(map.values());

            // Find the maxFrequency since we are using Max Heap
            int maxFreq = pq.poll();

            int totalIdleTime = (maxFreq - 1) * n;

            // Now looping through all the frequencies
            while (!pq.isEmpty()){
                // Find the current Frequency
                int currentFreq = pq.poll();
                // If its equal to max frequency then we need add 1 since we need to consider the last task
                // Example A B idle A B idle A B (so this B needs to be considered)
                if(currentFreq == maxFreq){
                    totalIdleTime-=currentFreq;
                    totalIdleTime+=1;
                }else {
                    // else we just keep subtracting idle time
                    totalIdleTime -= currentFreq;
                }
            }

            // If its greater than zero the add it with tasks length
            if(totalIdleTime > 0){
                return totalIdleTime + tasks.length;
            }else {
                return tasks.length;
            }
    }
}
