package pass;
import java.util.*;
public class lc30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> temp = new HashMap<>();
            // 滑动窗口的大小固定是 m * w，每次将下一个单词添加进 temp，上一个单词移出 temp
            for (int j = i; j + w <= n; j += w) {   
                String cur = s.substring(j, j + w);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (temp.get(prev) == 1) temp.remove(prev);
                    else temp.put(prev, temp.get(prev) - 1);
                    if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0))) continue;
                }
                if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0))) continue;
                // 上面两个 continue 可以减少 map 之间的 equals 操作
                if (temp.equals(map)) ans.add(j - (m - 1) * w);
            }
        }
        return ans;
    }

    public List<Integer> findSubstr(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 所有单词的个数
        int num = words.length;
        // 每个单词的长度（是相同的）
        int wordLen = words[0].length();
        // 字符串长度
        int stringLen = s.length();

        for (int i = 0; i < wordLen; i++) {
            // 遍历的长度超过了整个字符串的长度，退出循环
            if (i + num * wordLen > stringLen) {
                break;
            }
            // differ表示窗口中的单词频次和words中的单词频次之差
            Map<String, Integer> differ = new HashMap<>();
            // 初始化窗口，窗口长度为num * wordLen,依次计算窗口里每个切分的单词的频次
            for (int j = 0; j < num; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            // 遍历words中的word，对窗口里每个单词计算差值
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                // 差值为0时，移除掉这个word
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            // 开始滑动窗口
            for (int start = i; start < stringLen - num * wordLen + 1; start += wordLen) {
                if (start != i) {
                    // 右边的单词滑进来
                    String word = s.substring(start + (num - 1) * wordLen, start + num * wordLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    // 左边的单词滑出去
                    word = s.substring(start - wordLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - wordLen, start);
                }
                // 窗口匹配的单词数等于words中对应的单词数
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}
