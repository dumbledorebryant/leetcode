package pass.Company.Doordash.VO;

import java.util.*;

public class MenuTree {
    class Node{
        String key;
        int value;
        List<Node> children;
    }
    public int findChangedNodes(Node or, Node nr){
        int ans = 0;
        if (or == null) {
            ans += count(nr);
        }
        if (nr == null) {
            ans += count(or);
        }
        if (or != nr){
            ans += count(or);
            ans += count(nr);
        }
        return ans;
    }
    public int count(Node or){
        if (or == null) return 0;
        int ans = 1;
        List<Node> children = or.children;
        if (children.size() != 0){
            for (Node child : children){
                ans += count(child);
            }
        }
        return ans;
    }
}
