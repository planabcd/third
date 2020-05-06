package tree;

/**
 * @author think
 * @version v 1.0 2019/12/21 18:28
 */
public class SubtreeOfAnotherTree572 {
    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    //
    //示例 1:
    //给定的树 s:
    //
    //        3
    //        / \
    //        4   5
    //        / \
    //        1   2
    //给定的树 t：
    //
    //        4
    //        / \
    //        1   2
    //返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
    //
    //示例 2:
    //给定的树 s：
    //
    //        3
    //        / \
    //        4   5
    //        / \
    //        1   2
    //        /
    //        0
    //给定的树 t：
    //
    //        4
    //        / \
    //        1   2
    //返回 false。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/subtree-of-another-tree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if(s!=null && t!=null){
            if(s.val==t.val){
                result = helper(s,t);
            }
            if(!result){
                result = isSubtree(s.left,t);
            }
            if(!result){
                result = isSubtree(s.right,t);
            }
        }
        return result;
    }


    private boolean helper(TreeNode s, TreeNode t) {
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        return helper(s.left,t.left) && helper(s.right,t.right);
    }
}
