package pass.weekly_contest.wc2022_12_10;

import java.util.*;

public class lc6259 {
    Map<Integer, List<Integer>> mem = new HashMap<>();
    boolean[] used;
    int cap;
    int ptr;
    int cur;
    public lc6259(int n) {
        used = new boolean[n];
        cap = n;
        ptr = 0;
        cur = 0;
    }
    
    public int allocate(int size, int mID) {
        if (ptr >= cap) return -1;
        if (cap - cur < size) return -1;
        cur += size;
        for (int i = ptr; i < cap; i++){
            
        }
    }
    
    public int free(int mID) {
        if (!mem.containsKey(mID)) return 0;
        ptr = Math.min(ptr, mem.get(mID).get(0));
        List<Integer> list = mem.get(mID);
        int res = list.size();
        for (int i = 0; i < res; i++){
            used[list.get(i)] = false;
        }
        mem.remove(mID);
        return res;
    }
}
