package pass;

import java.util.*;

public class lc990 {
    class UF{
        public int count;
        int[] parent;

        public UF(int n){
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            parent[rootP] = rootQ;
            count--;
        }
        public boolean connected(int a, int b){
            int rootP = find(a);
            int rootQ = find(b);
            if (rootP != rootQ) return false;
            return true;
        }

        public int find(int node){
            if (parent[node] != node){
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
    }
    UF uf = new UF(26);
    public boolean equationsPossible(String[] equations) {
        List<String> neq = new ArrayList<>();
        for (String eq : equations){
            int a = eq.charAt(0) - 'a';
            int b = eq.charAt(3) - 'a';
            char ch = eq.charAt(1);
            if (ch == '='){
                uf.union(a, b);
            }
            else {
                neq.add(eq);
            }
        }
        for (String eq : neq){
            int a = eq.charAt(0) - 'a';
            int b = eq.charAt(3) - 'a';
            if (uf.connected(a, b)) return false;
        }
        return true;
    }
}
