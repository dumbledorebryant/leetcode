package pass.Company.Palantir.Karat;
import java.util.*;
public class FindParent {
    public void findNodesWithZeroAndOneParent(int[][] pairs){
        List<Integer> ones = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        Set<Integer> nodes = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs){
            int parent = pair[0];
            int child = pair[1];
            nodes.add(child);
            nodes.add(parent);
            map.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }

        for (int key : nodes){
            if (!map.containsKey(key)) zeros.add(key);
            else if (map.get(key).size() == 1) ones.add(key);
        }
        System.out.println(ones);
        System.out.println(zeros);
    }
    public static void main(String[] args) {
        int[][] pairs = new int[][]{
            {5,6},{1,3},{2,3},{3,6},{15,12},
            {5,7},{4,5},{4,9},{9,12},{30,16}
        };
        FindParent fp = new FindParent();
        fp.findNodesWithZeroAndOneParent(pairs);
    }
}
