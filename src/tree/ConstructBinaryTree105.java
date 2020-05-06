package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2019/11/19 23:51
 */
public class ConstructBinaryTree105 {
    public String serialize(TreeNode root) {
        if(root==null){
            return "#!";
        }
        String str = root.val+"!";
        str+= serialize(root.left);
        str+=serialize(root.right);
        return str;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = new ConstructBinaryTree105().buildTree(preorder, inorder);
        final String serialize = new ConstructBinaryTree105().serialize(treeNode);
        System.out.println(serialize);
    }

    int preIndex = 0;
    Map<Integer,Integer> inNum2IndexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i !=inorder.length; i++) {
            inNum2IndexMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(start>end){
            return null;
        }
        final int rootVal = preorder[preIndex++];
        final TreeNode root = new TreeNode(rootVal);
        int index = inNum2IndexMap.get(rootVal);
        root.left = helper(preorder,inorder,start,index-1);
        root.right = helper(preorder,inorder,index+1,end);
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
