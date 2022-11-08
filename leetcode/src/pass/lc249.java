package pass;
import java.util.*;
public class lc249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strings) {
            String normalizedString = normalize(str);
            groups.putIfAbsent(normalizedString, new ArrayList<>());
            groups.get(normalizedString).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        int shift = s.charAt(0) - 'a';
        for (int i = 0; i < s.length(); i++) {
            sb.append(shiftLetter(s.charAt(i), shift));
        }

        return sb.toString();
    }

    private char shiftLetter(char letter, int shift) {
        return (char) ('a' + (letter - shift + 26) % 26);
    }
}
