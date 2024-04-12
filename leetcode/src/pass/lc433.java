package pass;
import java.util.*;

public class lc433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank.length == 0) return -1;
        Deque<String> dq = new ArrayDeque<>();
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        if (!set.contains(endGene)) return -1;

        dq.addLast(startGene);
        int step = 0;
        while (!dq.isEmpty()){
            step++;
            int size = dq.size();
            for (int i = 0; i < size; i++){
                String s = dq.removeFirst();
                char[] chrs = s.toCharArray();
                for (int j = 0; j < 8; j++){
                    char ch = chrs[j];
                    for (int k = 0; k < 4; k++){
                        char nch = genes[k];
                        if (ch == nch) continue;
                        chrs[j] = nch;
                        String next = new String(chrs);
                        if (next.equals(endGene)) return step;
                        if (set.contains(next)){
                            set.remove(next);
                            dq.addLast(next);
                        }
                    }
                    chrs[j] = ch;
                }
            }
            
        }
        return -1;
    }
}
