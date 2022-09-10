package pass;

import java.util.Arrays;

public class UF {
    private int count;
    private int[] parent;

    public UF(int n){
        this.count = n;
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

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ; 
    }

    public int count(){
        return count;
    }

    private int find(int node){
        if (parent[node] != node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
}
