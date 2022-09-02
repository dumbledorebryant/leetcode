package pass;
import java.util.*;;
public class lc828 {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); i++) {
                long cur = A.get(i);
                long prev = i > 0 ? A.get(i - 1) : -1;
                long next = i < A.size() - 1 ? A.get(i + 1) : s.length();
                ans += (cur - prev) * (next - cur);
            }
        }

        return (int) ans % 1_000_000_007;
    }
}
