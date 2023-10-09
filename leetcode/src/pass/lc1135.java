package pass;

import java.util.Arrays;

public class lc1135 {
    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for (int[] edge : connections){
            int a = edge[0];
            int b = edge[1];
            if (uf.connected(a, b)) continue;
            else {
                uf.union(a, b);
                cost += edge[2];
            }
        }
        if (uf.count() == 2) return cost;
        return -1;
    }

    class UF{
        private int count;
        private int[] parent;

        public UF(int n){
            parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            else {
                parent[rootP] = rootQ;
                count--;
            }
        }

        public boolean connected(int p, int q){
            if (find(p) == find(q)) return true;
            else return false;
        }

        public int find(int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int count() {
            return count;
        }
    }
}
