package pass;
import java.util.*;
public class lc1166 {
    class Node{
        String name;
        int value;
        Map<String, Node> children;

        public Node(String file, int val){
            name = file;
            value = val;
            children = new HashMap<>();
        }
    }
    Node root;
    public lc1166() {
        root = new Node("", 0);
    }
    
    public boolean createPath(String path, int value) {
        Node ptr = root;
        String[] list = path.split("/");
        int len = list.length;
        for (int i = 0; i < len; i++){
            String node = list[i];
            if (i != len - 1){
                if (ptr.children.containsKey(node)){
                    ptr = ptr.children.get(node);
                }
                else return false;
            }
            else {
                Node temp = new Node(node, value);
                ptr.children.put(node, temp);
            }
        }
        return true;
    }
    
    public int get(String path) {
        String[] list = path.split("/");
        Node ptr = root;
        int len = list.length;
        for (int i = 1; i < len; i++){
            String node = list[i];
            if (ptr.children.containsKey(node)){
                ptr = ptr.children.get(node);
            }
            else {
                return -1;
            }
        }
        return ptr.value;
    }
}
