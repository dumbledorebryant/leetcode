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
    public List<String> adj(String str, List<String> wordlList) {
        List<String> ans = new ArrayList<>();
        char[] chrs = str.toCharArray();
        for (int i = 0; i < length; i++){
            char ich = chrs[i];
            for (char ch = 'a'; ch <= 'z'; ch++){
                chrs[i] = ch;
                String rep = new String(chrs);
                if (wordlList.contains(rep)) ans.add(rep);
            }
            chrs[i] = ich;
        }
        return ans;
    }
}
