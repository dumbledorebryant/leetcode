package pass.weekly_contest.wc2022_01_29;
import java.util.*;
public class lc5995 {
    public int[] groupStrings(String[] words) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (String s : words) {
            int n = 0;
            for (char c : s.toCharArray()) {
                n |= 1 << c - 'a';
            }
            if (!freq.containsKey(n)) {
                freq.put(n, 0);
            }
            freq.put(n, freq.get(n) + 1);
        }
        HashSet<Integer> visited = new HashSet<>();
        int count = 0, max = 0;
        for (int i : freq.keySet()) {
            if (!visited.contains(i)) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited.add(i);
                int size = 0;
                while (!q.isEmpty()) {
                    int current = q.poll();
                    size += freq.get(current);
                    for (int j = 0; j < 26; j++) {
                        int n = current ^ 1 << j;
                        if (freq.containsKey(n) && !visited.contains(n)) {
                            visited.add(n);
                            q.offer(n);
                        }
                    }
                    for (int j = 0; j < 26; j++) {
                        for (int k = 0; k < 26; k++) {
                            if ((current & 1 << j) == 0 && (current & 1 << k) > 0) {
                                int n = current ^ 1 << j ^ 1 << k;
                                if (freq.containsKey(n) && !visited.contains(n)) {
                                    visited.add(n);
                                    q.offer(n);
                                }
                            }
                        }
                    }
                }
                count++;
                max = Math.max(max, size);
            }
        }
        return new int[]{count, max};
    }
}
