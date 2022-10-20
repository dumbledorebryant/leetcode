package pass;

import java.util.*;

public class lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> map = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        int level = 1;
        while (!que.isEmpty()) {
            int n = que.size();
            while (n-- > 0) {
                String temp = que.poll();
                
                if (temp.equals(endWord)) return level; 
                map.remove(temp);
                
                char[] ch = temp.toCharArray();
                for (int i = 0; i < ch.length; ++i) {
                    char c = ch[i];
                    for (char j = 'a'; j <= 'z'; ++j) {
                        ch[i] = j;
                        if (map.contains(String.valueOf(ch))) {
                            que.offer(String.valueOf(ch));
                        }
                    }
                    ch[i] = c;
                }
            }
            level++;
        }
        return 0;
    }

    public int ladderSize(String beginWord, String endWord, List<String> wordList){
        Deque<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);
        queue.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String cur = queue.removeFirst();
                if (cur.equals(endWord)){
                    return steps;
                }

                char[] chrs = cur.toCharArray();
                int len = chrs.length;
                for (int j = 0; j < len; j++){
                    char ori = chrs[j];
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        chrs[j] = ch;
                        String str = String.valueOf(chrs);
                        if (set.contains(str)){
                            queue.addLast(str);
                            set.remove(str);
                        }
                    }
                    chrs[j] = ori;
                }
                
            }
            steps++;
        }
        return 0;
    }
}
