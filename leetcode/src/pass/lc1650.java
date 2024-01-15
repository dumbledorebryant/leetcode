package pass;

public class lc1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b){
            a = a.parent;
            b = b.parent;
            if (a == null) a = q;
            if (b == null) b = p;
        }
        return a;
    }
}
