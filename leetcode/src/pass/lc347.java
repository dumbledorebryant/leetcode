package pass;
import java.util.*;

public class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] array = new int[k];
        int length = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        Set<Integer> kset = map.keySet();

        for (int key : kset){
           queue.offer(key);
           if (queue.size() > k) queue.poll();
        }
        for (int i = 0; i < k; i++){
            array[i] = queue.poll();
        }
        return array;
    }

    public void test(){
        int[] nums = {5,3,1,1,1,3,73,1};
        topKFrequent(nums, 2);
    }
}
