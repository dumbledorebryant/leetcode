package pass;
import java.util.*;

public class lc126 {
    List<List<String>> ans;
    int len;
    int size = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        if (!wordList.contains(endWord)) return ans;
        len = beginWord.length();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        backtrace(beginWord, endWord, list, wordList);
        return ans;
    }

    public void backtrace(String cur, String end, List<String> list, List<String> wordList){
        if (cur.equals(end)){
            if (list.size() < size){
                ans.clear();
                size = list.size();
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        if (list.size() > size){
            return;
        }
        char[] cs = cur.toCharArray();
        for (int i = 0; i < len; i++){
            char ch = cs[i];
            for (char c = 'a'; c <= 'z'; c++){
                cs[i] = c;
                String tmp = new String(cs);
                if (!list.contains(tmp) && wordList.contains(tmp)){
                    list.add(tmp);
                    backtrace(tmp, end, list, wordList);
                    list.remove(list.size() - 1);
                }
            }
            cs[i] = ch;
        }
    }
}
