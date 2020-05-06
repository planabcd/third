package tree;

/**
 * @author think
 * @version v 1.0 2019/11/19 23:51
 */
public class MinTreeDepth111 {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(root.left==null || root.right==null){
            return Math.max(l,r)+1;
        }
        return Math.min(l,r)+1;
    }
}
