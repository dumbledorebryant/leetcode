package pass.Company.Navan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataCenterConnection {
    static class UF{
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
            int rp = find(p);
            int rq = find(q);
            if (rp == rq){
                return;
            }
            parent[rp] = rq;
            count--;
        }
        
        public boolean connected(int p, int q){
            return find(p) == find(q);
        }
        
        private int find(int node){
            if (parent[node] != node){
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
    }
    
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;
        
        public Edge(int f, int t, int w){
            from = f;
            to = t;
            weight = w;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static int getMinMaxLatency(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int k) {
        int n = gWeight.size();
        if (n == 0) return 0;
        UF uf = new UF(gNodes);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int from = gFrom.get(i) - 1;
            int to = gTo.get(i) - 1;
            int weight = gWeight.get(i);
            Edge edge = new Edge(from, to, weight);
            edges.add(edge);
        }
        
        Collections.sort(edges);
        List<Integer> list = new ArrayList<>();
        for (Edge edge : edges){
            int from = edge.from;
            int to = edge.to;
            if (!uf.connected(from, to)){
                uf.union(from, to);
                list.add(edge.weight);
            }
        }
        
        if (list.size() < gNodes - 1){
            return -1;
        }
        Collections.sort(list);
        System.out.println(list);
        
        return list.get(list.size() - k); 
    }  
}
/*
class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, x):
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x != root_y:
            if self.rank[root_x] > self.rank[root_y]:
                self.parent[root_y] = root_x
            else:
                self.parent[root_x] = root_y
                if self.rank[root_x] == self.rank[root_y]:
                    self.rank[root_y] += 1


def kruskal_mst(edges, num_nodes):
    mst = []
    edges.sort(key=lambda x: x[2])  # Sort edges based on weight

    uf = UnionFind(num_nodes)

    for edge in edges:
        u, v, weight = edge
        if uf.find(u) != uf.find(v):
            mst.append(edge)
            uf.union(u, v)

    return mst


def min_max_latency(g_nodes, g_from, g_to, g_weight, k):
    # Create a list of edges (from, to, weight) representing the graph
    edges = list(zip(g_from, g_to, g_weight))

    # Find the Minimum Spanning Tree using Kruskal's algorithm
    mst = kruskal_mst(edges, g_nodes)

    # If the MST has less than k-1 edges, it's not possible to divide into k regions
    if len(mst) < g_nodes - 1:
        return -1

    # Sort the edges of the MST in non-decreasing order based on weight
    mst.sort(key=lambda x: x[2])

    # The maximum max-latency value will be the weight of the (k-1)-th edge in the MST
    return mst[k - 2][2]


# Example usage
g_nodes = 3
g_from = [1, 2, 3]
g_to = [2, 3, 1]
g_weight = [4, 5, 3]
k = 2

print(min_max_latency(g_nodes, g_from, g_to, g_weight, k))  # Output: 3
*/