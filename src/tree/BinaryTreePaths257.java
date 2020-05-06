package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/19 0:17
 */
public class BinaryTreePaths257 {
    //给定一个二叉树，返回所有从根节点到叶子节点的路径。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例:
    //
    //输入:
    //
    //          1
    //        /   \
    //        2     3
    //        \
    //        5
    //
    //输出: ["1->2->5", "1->3"]
    //
    //解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/binary-tree-paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> temp, List<String> res) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(convert2String(temp));
        }
        helper(root.left, temp, res);
        helper(root.right, temp, res);
        temp.remove(temp.size() - 1);
    }

    private String convert2String(List<Integer> temp) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            str.append(temp.get(i)).append("->");
        }
        str.delete(str.length() - 2, str.length());
        return str.toString();
    }
}
