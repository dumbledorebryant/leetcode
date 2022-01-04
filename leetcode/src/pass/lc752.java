package pass;

import java.util.*;

public class lc752 {
    public int openLock(String[] deadends, String target) {
        // 记录死亡数字
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        
        // 记录已经检查过的数字
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        // 从起点开始进行搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否为终点或者为死亡数字
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;

                // 将节点未遍历的相邻节点加入队列中
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 增加步数
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
