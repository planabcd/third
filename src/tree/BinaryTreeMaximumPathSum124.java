package tree;

/**
 * @author think
 * @version v 1.0 2020/6/22 3:18
 */
public class BinaryTreeMaximumPathSum124 {
    //124. 二叉树中的最大路径和
    //给定一个非空二叉树，返回其最大路径和。
    //
    //本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
    //
    //示例 1:
    //
    //输入: [1,2,3]
    //
    //        1
    //        / \
    //        2   3
    //
    //输出: 6
    //示例 2:
    //
    //输入: [-10,9,20,null,null,15,7]
    //
    //        -10
    //        / \
    //        9  20
    //        /  \
    //        15   7
    //
    //输出: 42
    //https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
    int result = 0;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftWeight = Math.max(helper(root.left),0);
        int rightWeight = Math.max(helper(root.right),0);
        result = Math.max(result,leftWeight+rightWeight+root.val);
        return Math.max(leftWeight,rightWeight)+root.val;
    }
}
