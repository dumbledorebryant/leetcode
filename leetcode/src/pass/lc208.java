package pass;

import java.util.HashSet;
import java.util.Set;

public class lc208 {
    Set<String> sset = new HashSet<>();
    Set<String> pset = new HashSet<>();
    public lc208() {
        
    }
    
    public void insert(String word) {
        sset.add(word);
        int length = word.length();
        for (int i = 1; i <= length; i++){
            pset.add(word.substring(0, i));
        }
    }
    
    public boolean search(String word) {
        return sset.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        return pset.contains(prefix);
    }
}
