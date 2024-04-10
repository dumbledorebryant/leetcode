package pass;

public class lc389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        for (char ch : s.toCharArray()){
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : tmap.keySet()){
            if (!smap.containsKey(ch)) return ch;
            if (smap.get(ch) != tmap.get(ch)) return ch;
        }
        return ' ';
    }
}
