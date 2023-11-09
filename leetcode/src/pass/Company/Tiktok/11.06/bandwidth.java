package pass.Company.Tiktok.11.06;
import java.util.*;
public class bandwidth {
    public int getMax(List<Integer> bd, List<Integer> req, int W){
        int n = bd.size();
        int w = W;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= w; j++){
                if (j < bd.get(i - 1)){
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bd.get(i)] + req.get(i)); 
                }
            }
        }
        return dp[n][w];
    }
}
// }
// #include <iostream>
// #include <vector>
// #include <unordered_map>

// using namespace std;

// // Using a map of maps as the cache. The outer map's key is the remaining bandwidth,
// // and the inner map's key is the index, with the value being the cached result.
// unordered_map<int, unordered_map<int, int>> cache;

// int backtrack(int remainBandwidth, const vector<int>& bandwidths, const vector<int>& requests, int index)
// {
//     if (index == static_cast<int>(bandwidths.size()))
//         return 0;

//     // Check if the result is in the cache.
//     if (cache.find(remainBandwidth) != cache.end() && cache[remainBandwidth].find(index) != cache[remainBandwidth].end())
//         return cache[remainBandwidth][index];
    
//     // Skip the current index.
//     int maxRequest = backtrack(remainBandwidth, bandwidths, requests, index + 1);
//     if (bandwidths[index] <= remainBandwidth)
//     {
//         // Include the current index.
//         maxRequest = max(maxRequest, requests[index] + backtrack(remainBandwidth - bandwidths[index], bandwidths, requests, index + 1));
//     }

//     // Store the result in the cache before returning.
//     cache[remainBandwidth][index] = maxRequest;

//     return maxRequest;
// }

// int maxRequest(int totalBandwidth, vector<int> bandwidths, vector<int> requests)
// {
//     return backtrack(totalBandwidth, bandwidths, requests, 0);
// }

// int main()
// {
//     int totalBandwidth = 500;
//     vector<int> bandwidths{ 200, 100, 350, 50, 100 };
//     vector<int> requests{ 270, 142, 450, 124, 189 };
//     int ans = maxRequest(totalBandwidth, bandwidths, requests);

//     cout << ans << endl;
// }
