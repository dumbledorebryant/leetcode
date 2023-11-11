package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2900 {
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        for (int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        map.get(0).add(words[0]);
        for (int i = 1; i < n; i++){
            String str = words[i];
            for (int j = 0; j < i; j++){
                if (groups[i] != groups[j]) {
                    int ori = map.get(i).size();
                    int cur = map.get(j).size();
                    if (cur > ori){
                        List<String> temp = new ArrayList<>(map.get(j));
                        temp.add(str);
                        map.put(i, temp);
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++){
            int size = map.get(i).size();
            if (size > max){
                max = size;
                ans = new ArrayList<>(map.get(i));
            }
        }
        return ans;
    }
}
