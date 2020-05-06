package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2019/12/19 22:12
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        Map<Integer,Integer> inNum2IndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inNum2IndexMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,inorder.length-1,inNum2IndexMap);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end, Map<Integer,Integer> inNum2IndexMap) {
        if(start>end){
            return null;
        }
        int rootVal = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootVal);
        Integer inOrderIndex = inNum2IndexMap.get(rootVal);
        root.left = helper(preorder,inorder,start,inOrderIndex-1,inNum2IndexMap);
        root.right = helper(preorder,inorder,inOrderIndex+1,end,inNum2IndexMap);
        return root;
    }
}
