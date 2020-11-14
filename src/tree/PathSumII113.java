package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/9/26 14:50
 */
public class PathSumII113 {
    //113. 路径总和 II
    //给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例:
    //给定如下二叉树，以及目标和 sum = 22，
    //
    //        5
    //        / \
    //        4   8
    //        /   / \
    //        11  13  4
    //        /  \    / \
    //        7    2  5   1
    //返回:
    //
    //        [
    //        [5,4,11,2],
    //        [5,8,4,5]
    //        ]
    //https://leetcode-cn.com/problems/path-sum-ii/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>  res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, temp, res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if(root==null){
            return;
        }
        sum -= root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==0){
                res.add(new ArrayList(temp));
            }
        }else{
            helper(root.left, sum, temp, res);
            helper(root.right, sum, temp, res);
        }
        temp.remove(temp.size()-1);
    }
}
