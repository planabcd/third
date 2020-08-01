package tree;

/**
 * @author think
 * @version v 1.0 2020/8/1 12:39
 */
public class PingHengErChaShuIcof {
    //剑指 Offer 55 - II. 平衡二叉树
    //输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
    //
    //
    //
    //示例 1:
    //
    //给定二叉树 [3,9,20,null,null,15,7]
    //
    //        3
    //        / \
    //        9  20
    //        /  \
    //        15   7
    //返回 true 。
    //
    //示例 2:
    //
    //给定二叉树 [1,2,2,3,3,null,null,4,4]
    //
    //        1
    //        / \
    //        2   2
    //        / \
    //        3   3
    //        / \
    //        4   4
    //返回 false 。
    //https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }

    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = helper(root.left);
        if(left==-1){
            return -1;
        }
        int right = helper(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(right-left)<=1 ? 1+Math.max(right,left): -1;
    }
}
