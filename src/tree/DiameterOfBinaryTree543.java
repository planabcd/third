package tree;

/**
 * @author think
 * @version v 1.0 2019/12/23 0:51
 */
public class DiameterOfBinaryTree543 {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        res = Math.max(l+r,res);
        return Math.max(l,r)+1;
    }
}
