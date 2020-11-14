package tree;

/**
 * @author think
 * @version v 1.0 2020/9/21 0:20
 */
public class ConvertBstToGreaterTree538 {
    //538. 把二叉搜索树转换为累加树
    //给定一个二叉搜索树（Binary Search sun.reflect.generics.tree.Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
    //
    //
    //
    //例如：
    //
    //输入: 原始二叉搜索树:
    //        5
    //        /   \
    //        2     13
    //
    //输出: 转换为累加树:
    //        18
    //        /   \
    //        20     13
    //https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(13);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode root = new ConvertBstToGreaterTree538().convertBST(treeNode);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        visitRightRootLeft(root);
        return root;
    }

    private void visitRightRootLeft(TreeNode root){
        if(root==null){
            return;
        }
        visitRightRootLeft(root.right);
        sum+= root.val;
        root.val = sum;
        visitRightRootLeft(root.left);
    }

}
