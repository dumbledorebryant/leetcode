package pass;

public class lc383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];

        for (char ch : magazine.toCharArray()){
            dict[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()){
            dict[ch - 'a']--;
            if (dict[ch - 'a'] < 0) return false;
        }
        return true;
    }
}
