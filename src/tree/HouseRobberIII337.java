package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2020/8/5 0:16
 */
public class HouseRobberIII337 {
    //337. 打家劫舍 III
    //在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
    //
    //计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
    //
    //示例 1:
    //
    //输入: [3,2,3,null,3,null,1]
    //
    //        3
    //        / \
    //        2   3
    //        \   \
    //        3   1
    //
    //输出: 7
    //解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
    //示例 2:
    //
    //输入: [3,4,5,1,3,null,1]
    //
    //        3
    //        / \
    //        4   5
    //        / \   \
    //        1   3   1
    //
    //输出: 9
    //解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
    //https://leetcode-cn.com/problems/house-robber-iii/
    Map<TreeNode, Integer> selected = new HashMap<>();
    Map<TreeNode, Integer> notSelected = new HashMap<>();
    public int rob(TreeNode root) {
        helper(root);
        return Math.max(selected.getOrDefault(root,0),notSelected.getOrDefault(root,0));
    }

    private void helper(TreeNode root) {
        if(root==null){
            return;
        }
        helper(root.left);
        helper(root.right);
        //当前节点选中,则左右子节点不可被选中
        selected.put(root, root.val+notSelected.getOrDefault(root.left,0)+notSelected.getOrDefault(root.right,0));
        //当前节点不选,则左右子节点可选可不选
        notSelected.put(root,
                Math.max(selected.getOrDefault(root.left,0),notSelected.getOrDefault(root.left,0))
                        +
                        Math.max(selected.getOrDefault(root.right,0),notSelected.getOrDefault(root.right,0))
        );
    }
}
