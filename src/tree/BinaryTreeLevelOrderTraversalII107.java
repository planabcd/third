package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/9/6 0:36
 */
public class BinaryTreeLevelOrderTraversalII107 {
    //107. 二叉树的层次遍历 II
    //给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    //
    //例如：
    //给定二叉树 [3,9,20,null,null,15,7],
    //
    //        3
    //        / \
    //        9  20
    //        /  \
    //        15   7
    //返回其自底向上的层次遍历为：
    //
    //        [
    //        [15,7],
    //        [9,20],
    //        [3]
    //        ]
    //https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> rs = new LinkedList<>();
        if(root==null){
            return rs;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int rowSize = queue.size();
            List<Integer> row = new ArrayList<>();
            rs.addFirst(row);
            for (int i = 0; i < rowSize; i++) {
                TreeNode poll = queue.poll();
                row.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return rs;
    }
}
