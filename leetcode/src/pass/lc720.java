package pass;

public class lc720 {
    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }   
    }
    Trie root = new Trie();
    public void add(String s){
        Trie temp = root;

        for (char ch : s.toCharArray()){
            if (temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new Trie();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
    }

    int max = 0;
    String res = "";
    public String longestWord(String[] words) {
        for (String s : words){
            add(s);
        }

        dfs(root, 0, new StringBuilder());
        System.out.println(max);
        return res;
    }

    public void dfs(Trie root, int cur, StringBuilder sb){
        Trie temp = root;
        cur++;
        for (int i = 0; i < 26; i++){
            if (temp.children[i] == null) continue;
            sb.append((char)('a' + i));
            if (temp.children[i].isEnd){
                if (cur > max){
                    max = cur;
                    res = sb.toString();
                }
                if (cur == max){
                    String curString = sb.toString();
                    if (curString.compareTo(res) < 0){
                        res = curString;
                    }
                }
            }
            else {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            
            dfs(temp.children[i], cur, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
