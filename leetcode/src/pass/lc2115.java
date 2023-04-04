package pass;
import java.util.*;
public class lc2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int length = recipes.length;
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (int i = 0; i < length; i++){
            String rec = recipes[i];
            List<String> ingre = ingredients.get(i);
            for (String str : ingre){
                map.getOrDefault(str, new ArrayList<>()).add(rec);
                indegree.put(rec, indegree.getOrDefault(rec, 0) + 1);
            }
        }
        Queue<String> queue = new LinkedList<>();
        for (String sup : supplies){
            queue.offer(sup);
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            String str = queue.poll();
            for (String s : map.getOrDefault(str, new ArrayList<>())){
                indegree.put(s, indegree.get(s) - 1);
                if (indegree.get(s) == 0){
                    queue.offer(s);
                    ans.add(s);
                }
            }
        }
        return ans;
    }
}
