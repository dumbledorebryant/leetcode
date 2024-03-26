package pass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int size = wordsDict.length;
        boolean same = word1.equals(word2);
        long dist = Integer.MAX_VALUE;
        long i1 = dist, i2 = -dist;
        for (int i = 0; i < size; i++){
            String word = wordsDict[i];
            if (word.equals(word1)){
                i1 = i;
            }
            if (word.equals(word2)){
                if (same){
                    i1 = i2;
                }
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int)dist;
    }
}
