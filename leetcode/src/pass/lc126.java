package pass;
import java.util.*;

public class lc126 {
    List<List<String>> ans;
    int len;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        len = beginWord.length();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;
        dict.remove(beginWord);

        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, Set<String>> from = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, steps, from);
        if (found){
            System.out.println("hello");
            Deque<String> list = new ArrayDeque<>();
            list.add(endWord);
            backtrace(from, beginWord, endWord, list);
        }
        
        return ans;
    }

    public boolean bfs(String begin, String end, Set<String> dict, Map<String, Integer> steps, Map<String, Set<String>> from){
        int step = 0;
        boolean found = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++){
                String cur = queue.poll();
                char[] cs = cur.toCharArray();
                for (int j = 0; j < len; j++){
                    char ch = cs[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        cs[j] = c;
                        String next = String.valueOf(cs);
                        if (steps.containsKey(next) && steps.get(next) == step){
                            from.get(next).add(cur);
                        }
                        if (!dict.contains(next)) continue;
                        dict.remove(next);
                        queue.offer(next);
                        from.putIfAbsent(next, new HashSet<>());
                        from.get(next).add(cur);
                        steps.put(next, step);
                        if (next.equals(end)){
                            found = true;
                        }
                    }
                    cs[j] = ch;
                }
            }
            if (found) break;
        }
        return found;
    }

    public void backtrace(Map<String, Set<String>> from, String begin, String cur, Deque<String> list){
        if (cur.equals(begin)){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (String pre : from.get(cur)){
            list.addFirst(pre);
            backtrace(from, begin, pre, list);
            list.removeFirst();
        }
    }
}
