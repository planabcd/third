package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/12 20:49
 */
public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root==null){
            return;
        }
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
}
