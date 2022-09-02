package pass;
import java.util.*;;
public class lc828 {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        int ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); i++) {
                int cur = A.get(i);
                int prev = i > 0 ? A.get(i - 1) : -1;
                int next = i < A.size() - 1 ? A.get(i + 1) : s.length();
                ans += (cur - prev) * (next - cur);
            }
        }

        return ans;
    }
}
