package pass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc1980 {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        for (String str : nums){
            set.add(str);
            queue.addLast(str);
        }

        while (!queue.isEmpty()){
            String str = queue.removeFirst();
            for (String s : getAdj(str)){
                if (!set.contains(s)) return s;
            }
        }
        return null;
    }

    public List<String> getAdj(String s){
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == '0') {
                list.add(s.substring(0, i) + '1' + s.substring(i + 1, n));
            }
            else {
                list.add(s.substring(0, i) + '0' + s.substring(i + 1, n));
            }
        }
        return list;
    }
}
