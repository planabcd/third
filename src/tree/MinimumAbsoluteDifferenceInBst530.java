package tree;

/**
 * @author think
 * @version v 1.0 2020/10/12 22:21
 */
public class MinimumAbsoluteDifferenceInBst530 {
    //530. 二叉搜索树的最小绝对差
    //给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
    //
    //
    //
    //示例：
    //
    //输入：
    //
    //        1
    //        \
    //        3
    //        /
    //        2
    //
    //输出：
    //        1
    //
    //解释：
    //最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
    int minDepth = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDepth;
    }

    private void helper(TreeNode root) {
        if(root==null){
            return;
        }
        helper(root.left);
        int val = root.val;
        if(pre==-1){
            pre = val;
        }else{
            if(val-pre<minDepth){
                minDepth = val-pre;
            }
            pre = val;
        }
        helper(root.right);
    }
}
