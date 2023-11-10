package pass.Company.Tiktok.11.06;
import java.util.*;

public class operation {
    public int getMax(List<integer> list){
        int max = 0;
        int n = list.size();
        for (int i = 0; i < n/2; i++){
            int a = list.get(i);
            int b = list.get(n - 1 - i);
            if (a < b) continue;
        }
    }
}

// #include <iostream>
// #include <vector>
// #include <cmath>

// using namespace std;

// int mirrorReflection(int idx, int size) {
//     return size - idx - 1;
// }

// int bestScore(const vector<int>& memories) {
//     int n = static_cast<int>(memories.size());
//     long long score = 0;
//     for (int i=0; i< ceil((n/2)); ++i) {
//         int mirrorIdx = mirrorReflection(i, n);
//         if (memories[i] <= memories[mirrorIdx]) {
//             score += (i+1) * memories[i];
//             score += (mirrorIdx+1) * memories[mirrorIdx];
//         }
//         else {
//             score += (i+1) * memories[mirrorIdx];
//             score += (mirrorIdx+1) * memories[i];
//         }
//     }

//     return static_cast<int>(score % 1000000007);
// }

// int main()
// {
//     auto memories = vector<int>{ 2, 4, 1, 3 };
//     cout << bestScore(memories);
// }
