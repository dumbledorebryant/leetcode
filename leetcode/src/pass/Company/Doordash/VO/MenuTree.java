package pass.Company.Doordash.VO;

import java.util.*;

public class MenuTree {
    class Node{
        String key;
        int value;
        List<Node> children;
    }
    HashMap<String, Node> map;
    StringBuilder updates;
    public String changedNodes(Node root1, Node root2)
    {
        map = new HashMap<>();
        updates = new StringBuilder();
        dfsToStoreFirstTreeInMap(root1);
        compareTrees(root2);
        if(map.size()>0)
        {
            //missing nodes in new tree
            for(String key : map.keySet())
            {
                updates.append("\n");
                updates.append("Missing nodes from old tree: ");
                updates.append(key);
            }
        }
        return updates.toString();
    }

    private void dfsToStoreFirstTreeInMap(Node root)
    {
        map.put(root.key, root);
        if(root.children == null)
        {
            return; 
        }
        for(Node child : root.children)
        {
            dfsToStoreFirstTreeInMap(child);
        }
    }

    private void compareTrees(Node root)
    {
        if(map.containsKey(root.key))
        {
            Node original = map.get(root.key);
            //check if the value is same to the original node
            if(original.val != root.val)
            {
                updates.append("\n");
                updates.append("Value changed for node: ");
                updates.append(root.key);
            }
            map.remove(root.key);
        }
        else //extra nodes in new tree
        {
            updates.append("\n");
            updates.append("Extra nodes in the new tree: ");
            recursivelyAddAllChildrenToUpdates(root);
            return;
        }
        if(root.children == null)
        {
            return; 
        }
        for(Node child : root.children)
        {
            compareTrees(child);
        }
    }

    private void recursivelyAddAllChildrenToUpdates(Node root)
    {
        updates.append(root.key);
        if(root.children == null)
        {
            return; 
        }
        for(Node child : root.children)
        {
            recursivelyAddAllChildrenToUpdates(child);
        }
    }
}
