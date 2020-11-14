package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author think
 * @version v 1.0 2020/9/13 11:35
 */public class AverageOfLevelsInBinaryTree637 {
    //给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
    //
    //         
    //
    //示例 1：
    //
    //输入：
    //        3
    //        / \
    //        9  20
    //        /  \
    //        15   7
    //输出：[3, 14.5, 11]
    //解释：
    //第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
    //         
    //
    //提示：
    //
    //节点值的范围在32位有符号整数范围内。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum+=poll.val;
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            res.add(sum/size);
        }
        return res;
    }
}
