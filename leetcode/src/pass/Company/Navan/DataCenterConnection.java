package pass.Company.Navan;

public class DataCenterConnection {
    
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