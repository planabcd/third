package tree;

/**
 * @author think
 * @version v 1.0 2019/11/19 23:51
 */
public class ValidateBinarySearchTree98 {
    TreeNode pre;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        final TreeNode left = new TreeNode(1);
        root.left = left;
        new ValidateBinarySearchTree98().isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(pre!=null && pre.val>root.val){
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
