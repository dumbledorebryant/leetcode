package pass.Company.Doordash.VO;
import java.util.*;
public class FileSystem {
    class Node{
        String name;
        int value;
        Map<String, Node> children;
    }
    Node root;
    public FileSystem() {
        root = new Node();
        root.value = Integer.MAX_VALUE;
    }
    
    public boolean createPath(String path, int value) {
        String[] list = path.split("/");
        Node ptr = root;
        int len = list.length;
        for (String node : list){
            if (root.children.containsKey(node)){
                ptr = ptr.children.get(node);
            }
            else 
        }
    }
    
    public int get(String path) {
        
    }
}
