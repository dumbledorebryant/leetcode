package pass;
import java.util.*;
class Trie
{
    public Trie child [];
    public boolean is_word;

    Trie()
    {
        child = new Trie [26];
        is_word = false;
    }

    public void insert(String word)
    {
        Trie rt = this;
        for (int i = 0; i < word.length(); i ++)
        {
            int ID = (int)(word.charAt(i) - 'a');
            if (rt.child[ID] == null)
                rt.child[ID] = new Trie();
            rt = rt.child[ID];
        }
        rt.is_word = true;
    }

    //-------------------------查询，回溯写法
    public List<String> res = new ArrayList<>();
    public StringBuilder sb = new StringBuilder();

    public void backtrace(Trie rt)
    {
        if (rt == null)
            return ;
        if (rt.is_word == true)
        {
            res.add(new String(sb));
            if (res.size() == 3)
                return ;
        }
        for (int ID = 0; ID < 26; ID ++)
        {
            if (rt.child[ID] != null)
            {
                sb.append((char)('a' + ID));
                if (res.size() == 3)
                    break;
                backtrace(rt.child[ID]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> starts_with(String prefix)
    {
        res.clear();
        sb.delete(0, sb.length());

        Trie rt = this;
        for (int i = 0; i < prefix.length(); i ++)
        {
            int ID = prefix.charAt(i) - 'a';
            if (rt.child[ID] == null)
                return res;
            else
            {
                sb.append(prefix.charAt(i));
                rt = rt.child[ID];
            }
        }

        backtrace(rt);
        return res;
    }
}

class lc1268 
{
    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        Trie T = new Trie();
        for (String word : products)
            T.insert(word);

        List<List<String>> res = new ArrayList<>();
        String prefix = "";
        for (int i = 0; i < searchWord.length(); i ++)
        {
            prefix += searchWord.charAt(i);
            res.add(new ArrayList<>(T.starts_with(prefix)));    //必须new，不然还是引用。统一显示为最后一次查询的结果！！！！！！！！！！！！！
        }
        return res;
    }
}