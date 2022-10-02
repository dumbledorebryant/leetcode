package pass.OA.Doordash;

public class GetRoute {
    
}
//#include <iostream>
//#include <vector>
//#include <queue>
//#include <unordered_map>

//using namespace std;

// Optimized approach: using priority queue.


/*

vector<int> dijkstra(int source, int n, unordered_map<int, vector<pair<int, int>>> & adj) {
    // O(ElogV), there'll be at most E vertices in the heap, 
    // Each insert or extract operation is O(logE) = O(logV^2) = O(logV)
    vector<int> dist(n, INT_MAX);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; // min heap.

    pq.push({0, source});
    dist[source] = 0;

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        for (auto it : adj[u]) {
            int v = it.first;
            int weight = it.second;

            if (dist[v] > dist[u] + weight) {
                dist[v] = dist[u] + weight;
                pq.push({dist[v], v});
            }
        }
    }

    return dist;
}

// // find the shortest path from a -> c -> b.
int getShortestDistance(int n, int a, int b, int c, vector<int> & roads_from, vector<int> & roads_to, vector<int> & roads_weight) {
    int m = roads_from.size(); // number of edges
    unordered_map<int, vector<pair<int, int>>> adj; // adjacency list, weighted graph.
    for (int i = 0; i < m; i++)
    {
        adj[roads_from[i]].push_back({roads_to[i], roads_weight[i]});
        adj[roads_to[i]].push_back({roads_from[i], roads_weight[i]});
    }

    vector<int> dist_a = dijkstra(a, n, adj);
    vector<int> dist_b = dijkstra(b, n, adj);
    vector<int> dist_c = dijkstra(c, n, adj);

    int min_dist = INT_MAX;
    for (int i = 0; i < n; i++)
    {
        if (dist_a[i] != INT_MAX && dist_b[i] != INT_MAX && dist_c[i] != INT_MAX) {
            min_dist = min(min_dist, dist_a[i] + dist_b[i] + dist_c[i]);
        }
    }

    return min_dist == INT_MAX ? -1 : min_dist;
}




int main() {
    int n = 4, a = 1, b = 3, c = 2;
    vector<int> roads_from = {0, 0, 0};
    vector<int> roads_to = {2, 1, 3};
    vector<int> roads_weight = {1, 2, 3};
    cout << getShortestDistance(n, a, b, c, roads_from, roads_to, roads_weight) << endl;
}

 * 
 */