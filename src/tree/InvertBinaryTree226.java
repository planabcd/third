package tree;

/**
 * @author think
 * @version v 1.0 2020/1/12 23:54
 */
public class InvertBinaryTree226 {
    //翻转一棵二叉树。
    //
    //示例：
    //
    //输入：
    //
    //        4
    //        /   \
    //        2     7
    //        / \   / \
    //        1   3 6   9
    //输出：
    //
    //        4
    //        /   \
    //        7     2
    //        / \   / \
    //        9   6 3   1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/invert-binary-tree
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
