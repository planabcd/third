package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/2/10 22:46
 */
public class BinaryTreeRightSideView199 {
    //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    //
    //示例:
    //
    //输入: [1,2,3,null,5,null,4]
    //输出: [1, 3, 4]
    //解释:
    //
    //        1            <---
    //        /   \
    //        2     3         <---
    //        \     \
    //        5     4       <---
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(i==size-1){
                    res.add(poll.val);
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }
}
