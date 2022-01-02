package pass;
import pass.TreeNode;
import java.util.*;


public class lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) return null;
        
        int head = preorder[0];
        int ihead = search(inorder, head);
        TreeNode headNode = new TreeNode(head);
        if (length == 1) return headNode;

        int[] inleft = Arrays.copyOfRange(inorder, 0, ihead);
        int[] inright = Arrays.copyOfRange(inorder, ihead + 1, length);
        
        int rindex = -1;
        for (int i = 1; i < length; i++){
            if (search(inleft, preorder[i]) == -1){
                rindex = i;
                break;
            }
        }

        
        if (rindex == -1){
            int[] preleft = Arrays.copyOfRange(preorder, 1, length);
            headNode.left = buildTree(preleft, inleft);
            headNode.right = null;
            return headNode;
        }
        else {
            int[] preleft = Arrays.copyOfRange(preorder, 1, rindex);
            headNode.left = buildTree(preleft, inleft);
            int[] preright = Arrays.copyOfRange(preorder, rindex, length);
            headNode.right = buildTree(preright, inright);
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

    public TreeNode test(){
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        return buildTree(pre, in);
    }
}