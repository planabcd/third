package tree;

/**
 * @author think
 * @version v 1.0 2019/12/24 0:26
 */
public class CountCompleteTreeNodes222 {

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left==right){
            //左子树是满二叉树
            return (1<<left) + countNodes(root.right);
        }else{
            //右子树
            return (1<<right) + countNodes(root.left);
        }
    }

    public int countLevel(TreeNode root){
        int level = 0;
        while(root!=null){
            level++;
            root = root.left;
        }
        return level;
    }
}
