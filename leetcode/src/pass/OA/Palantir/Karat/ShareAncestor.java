package pass.OA.Palantir.Karat;

import java.util.*;

public class ShareAncestor {
    public boolean hasCommon(int[][] edges, int x, int y){
        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            parents.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }

        Set<Integer> xp = new HashSet<>();
        Set<Integer> yp = new HashSet<>();
        for (int parent : xp){
            if (yp.contains(parent)) return true;
        }
        return false;
    }

    public Set<Integer> findAncestors(Map<Integer, List<Integer>> map, int x){
        Set<Integer> set = new HashSet<>();
        if (!map.containsKey(x)) return set;
        for (int parent : map.get(x)){
            set.addAll(findAncestors(map, parent));
        }
        return set;
    }
}
