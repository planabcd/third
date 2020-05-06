package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2019/12/27 21:36
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
    //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    //
    //例如：
    //给定二叉树 [3,9,20,null,null,15,7],
    //
    //        3
    //        / \
    //        9  20
    //        /  \
    //        15   7
    //返回锯齿形层次遍历如下：
    //
    //        [
    //        [3],
    //        [20,9],
    //        [15,7]
    //        ]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //奇数层弹出队首,从左往右添加数据到队尾
        //偶数层弹出队尾,从右往左添加数据到队首
        //1->2,3-> 4 5 6 7-> 8 9 10 12->
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            result.add(levelList);
            for (int i = 0; i < size; i++) {
                if(flag==1){
                    TreeNode treeNode = queue.removeFirst();
                    levelList.add(treeNode.val);
                    if(treeNode.left!=null){
                        queue.addLast(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        queue.addLast(treeNode.right);
                    }
                }else{
                    final TreeNode treeNode = queue.removeLast();
                    levelList.add(treeNode.val);
                    if(treeNode.right!=null){
                        queue.addFirst(treeNode.right);
                    }
                    if(treeNode.left!=null){
                        queue.addFirst(treeNode.left);
                    }
                }
            }
            flag = -flag;
        }
        return result;
    }
}
