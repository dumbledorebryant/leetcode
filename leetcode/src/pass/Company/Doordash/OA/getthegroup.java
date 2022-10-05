package pass.Company.Doordash.OA;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class getthegroup {

    public static void main(String[] args) {
        int[] li1 = new int[] { 1, 2, 1 };
        int[] li2 = new int[] { 2, 3, 4 };
        String[] types = new String[] { "Friend", "Friend", "Total" };

        System.out.println(getgroups(4, types, li1, li2));
    }

    public static int getgroups(int n, String[] types, int[] student1, int[] student2) {

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < student1.length; i++) {

            if (types[i].equals("Friend")) {

                int s1 = map.getOrDefault(student1[i], 1);
                int s2 = map.getOrDefault(student2[i], 1);

                int root1 = find(parent, student1[i]);
                int root2 = find(parent, student2[i]);

                if ((parent[root1] != -1) && (parent[root2] != -1) && (root1 == root2)) {
                    continue;
                } else {
                    union(parent, student1[i], student2[i]);

                    int root = find(parent, student1[i]);

                    map.put(root, s1 + s2);
                }

            } else {
                ans += map.getOrDefault(find(parent, student1[i]), 1);
                ans += map.getOrDefault(find(parent, student2[i]), 1);
                return ans;
            }

        }

        return -1;
    }

    static int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
}
