package tree;

/**
 * @author think
 * @version v 1.0 2019/11/19 23:51
 */
public class MaxTreeDepth104 {
    TreeNode pre;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        final TreeNode left = new TreeNode(2);
        root.left = left;
        new MaxTreeDepth104().maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
