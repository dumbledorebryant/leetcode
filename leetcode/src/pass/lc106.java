package pass;
import java.util.*;
import pass.TreeNode;

public class lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if (length == 0) return null;
        
        int head = postorder[length - 1];
        int ihead = search(inorder, head);
        TreeNode headNode = new TreeNode(head);
        if (length == 1) return headNode;

        int[] inleft = Arrays.copyOfRange(inorder, 0, ihead);
        int[] inright = Arrays.copyOfRange(inorder, ihead + 1, length);
        
        int rindex = -1;
        for (int i = 0; i < length - 1; i++){
            if (search(inleft, postorder[i]) == -1){
                rindex = i;
                break;
            }
        }

        if (rindex == -1){
            int[] postleft = Arrays.copyOfRange(postorder, 0, length - 1);
            headNode.left = buildTree(inleft, postleft);
            headNode.right = null;
            return headNode;
        }
        else {
            int[] postleft = Arrays.copyOfRange(postorder, 0, rindex);
            headNode.left = buildTree(inleft, postleft);
            int[] postright = Arrays.copyOfRange(postorder, rindex, length - 1);
            headNode.right = buildTree(inright,postright);
            return headNode;
        }
    }


    int search(int[] list, int target){
        int length = list.length;
        int index = -1;
        for (int i = 0; i < length; i++){
            if (list[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }
}
