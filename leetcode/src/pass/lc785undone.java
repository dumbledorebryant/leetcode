package pass;

import java.util.HashMap;
import java.util.Map;

public class lc785undone {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> mapa = new HashMap<>();
        Map<Integer, Integer> mapb = new HashMap<>();
        int m = graph.length;
        for (int i = 0; i < m; i++){
            int len = graph[i].length;
            boolean flag1 = !mapa.containsKey(i);
            boolean flag2 = !mapb.containsKey(i);
            if (flag1 && flag2){
                mapa.put(i, 0);
                for (int j = 0; j < len; j++){
                    int adj = graph[i][j];
                    if (!mapa.containsKey(adj)) mapb.put(adj, 0);
                }
            }
            else if (flag1 && !flag2){
                for (int j = 0; j < len; j++){
                    int adj = graph[i][j];
                    if (mapb.containsKey(adj)){
                        return false;
                    }
                    else mapa.put(adj, 0);
                }
            }
            else if (!flag1 && flag2){
                for (int j = 0; j < len; j++){
                    int adj = graph[i][j];
                    mapb.put(adj, 0);
                }
            }
            else return false;
        }
        return true;
    }
}
