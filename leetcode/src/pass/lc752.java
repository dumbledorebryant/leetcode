package pass;

import java.util.*;

public class lc752 {
    Map<
    public int openLock(String[] deadends, String target) {
        
    }
    public void backtrace(String[] deadends, String target, String str){
        if (str == target) return;
        if (deadends)
    }

    public int BFS(Node start, Node target){
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);
        
        int step = 0;

        while (!q.isEmpty()){
            int sz = q.size();
            
            for (int i = 0; i < sz; i++){
                Node cur = q.poll();
                if (cur == target){
                    return step;
                }
                for (Node x : cur.adj()){
                    if (!visited.contains(x)){
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }

    }
}
