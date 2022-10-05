package pass.Company.Optiver;
import java.util.*;
public class CheckTreeErrors {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String pairs = in.nextLine();
        treeErrors(pairs);
        in.close();
    }
    public static void treeErrors(String pairs) {
        // Invalid input format, dups and more than two children as we build the tree.
        String nodes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] input = pairs.split(" ", -1);
        Set<String> dup = new HashSet<>();
        char[] indegree = new char[26];
        Map<Character, List<Character>> tree = new HashMap<>();
        boolean duplicate = false, more_than_two_children = false;
        for (String i : input) {
            if (i.length() != 5 || i.charAt(0) != '(' || i.charAt(4) != ')' || 
                i.charAt(2) != ',' || nodes.indexOf(i.charAt(1)) == -1 || nodes.indexOf(i.charAt(3)) == -1) {
                System.out.println("E1");
                return;
            }
            if (!dup.add(i)) duplicate = true;
            
            char parent = i.charAt(1), child = i.charAt(3);
            List<Character> children = tree.getOrDefault(parent, new ArrayList<>());
            children.add(child);
            if (children.size() > 2) more_than_two_children = true;
            tree.put(parent, children);
            indegree[child - 'A']++;
        }
        if (duplicate) {
            System.out.println("E2");
            return;
        }
        if (more_than_two_children) {
            System.out.println("E3");
            return;
        }
        
        // Traverse the tree and check for multiple nodes and cycles.
        int visited = 0;
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 26; i++){
            char ch = (char)('A' + i);
            if (indegree[i] == 0 && tree.containsKey(ch))
                q.offer(ch);
        }
            
        
        if (q.size() > 1) {
            System.out.println("E4");
            return;
        }
        
        if (q.size() == 0) {
            System.out.println("E5");
            return;
        }
        
        char root = q.peek();
        
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                char node = q.poll();
                if (tree.containsKey(node)){
                    List<Character> children = tree.get(node);
                    for (char c : children) {
                        indegree[c - 'A']--;
                        if (indegree[c - 'A'] == 0) {
                            q.offer(c);
                            visited++;
                        }
                    }
                }
            }
        }
        // input contains all nodes except root. Same with visited, if no cycles.
        if (visited < input.length) System.out.println("E5");
        StringBuilder sb = new StringBuilder();
        traverse(tree, root, sb);
        System.out.println(sb.toString());
        return;
    }
    public static void traverse(Map<Character, List<Character>> tree, char root, StringBuilder sb) {
        sb.append('(');
        sb.append(root);
        if (tree.containsKey(root)){
            List<Character> children = tree.get(root);
            for (char child : children){
                traverse(tree, child, sb);
            }
        }
        sb.append(')');
    }
}
