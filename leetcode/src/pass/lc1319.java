package pass;

public class lc1319 {
    class UF {
        int[] parent;
        int count;

        public UF(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
            count = n;
        }

        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
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
            return find(p) == find(q);
        }

        public int count(){
            return this.count;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        UF uf = new UF(n);

        int left = 0;
        for (int[] edge : connections){
            int a = edge[0];
            int b = edge[1];
            if (uf.connected(a, b)) left++;
            else {
                uf.union(a, b);
            }
        }
        int need = uf.count() - 1;
        if (left >= need) return need;
        else return -1;
    }
}
