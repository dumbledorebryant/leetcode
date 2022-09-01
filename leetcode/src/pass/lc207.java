package pass;
import java.util.LinkedList;
import java.util.List;

public class lc207 {
    
    boolean[] visited;
    boolean[] onpath;
    boolean flag = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for (int[] prereq : prerequisites){
            int from = prereq[1];
            int to = prereq[0];
            graph[from].add(to);
        }

        visited = new boolean[numCourses];
        onpath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            tranverse(graph, i);
        }
        return !flag;
    }

    void tranverse(List<Integer>[] graph, int node){
        if (onpath[node]){
            flag = true;
        }
        if (visited[node] || flag) return;
        
        visited[node] = true;
        onpath[node] = true;
        List<Integer> prereq = graph[node];
        for (int t : prereq){
            tranverse(graph, t);
        }
        onpath[node] = false;
    }
}
