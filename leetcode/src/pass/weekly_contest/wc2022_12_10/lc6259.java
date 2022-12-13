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
        return 0;
    }
    
    public int free(int mID) {
        return 0;
    }
}
