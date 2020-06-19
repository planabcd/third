package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/6/16 22:06
 */
public class SumRootToLeafNumbers129 {
    //129. 求根到叶子节点数字之和
    //给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
    //
    //例如，从根到叶子节点路径 1->2->3 代表数字 123。
    //
    //计算从根到叶子节点生成的所有数字之和。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例 1:
    //
    //输入: [1,2,3]
    //        1
    //        / \
    //        2   3
    //输出: 25
    //解释:
    //从根到叶子节点路径 1->2 代表数字 12.
    //从根到叶子节点路径 1->3 代表数字 13.
    //因此，数字总和 = 12 + 13 = 25.
    //示例 2:
    //
    //输入: [4,9,0,5,1]
    //        4
    //        / \
    //        9   0
    //        / \
    //        5   1
    //输出: 1026
    //解释:
    //从根到叶子节点路径 4->9->5 代表数字 495.
    //从根到叶子节点路径 4->9->1 代表数字 491.
    //从根到叶子节点路径 4->0 代表数字 40.
    //因此，数字总和 = 495 + 491 + 40 = 1026.
    //https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(new SumRootToLeafNumbers129().sumNumbers(treeNode));
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }


    private int helper(TreeNode root, int path) {
        if(root==null){
            return 0;
        }
        int sum = path*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        return helper(root.left, sum)+helper(root.right, sum);
    }

    public int sumNumbers2(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        helper2(root, path, res);
        int sum = 0;
        for (Integer re : res) {
            sum+=re;
        }
        return sum;

    }

    private void helper2(TreeNode root, List<TreeNode> path, List<Integer> res) {
        if(root.left==null && root.right==null){
            int num = 0;
            //4,9,5
            for (TreeNode treeNode : path) {
                num = num * 10 + treeNode.val;
            }
            res.add(num);
            //if(num!=0){
            //    res.add(num);
            //}
            return;
        }
        if(root.left!=null){
            path.add(root.left);
            helper2(root.left, path,res);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.right);
            helper2(root.right, path, res);
            path.remove(path.size()-1);
        }
    }
}
