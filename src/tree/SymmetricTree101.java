package tree;

/**
 * @author think
 * @version v 1.0 2019/12/21 20:07
 */
public class SymmetricTree101 {
    //给定一个二叉树，检查它是否是镜像对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //
    //        1
    //        / \
    //        2   2
    //        / \ / \
    //        3  4 4  3
    //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //        1
    //        / \
    //        2   2
    //        \   \
    //        3    3
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/symmetric-tree
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return left.val==right.val && helper(left.right,right.left) && helper(left.left,right.right);
    }
}
