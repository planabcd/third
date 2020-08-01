package tree;

/**
 * @author think
 * @version v 1.0 2019/12/5 22:51
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode.left =treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        new FlattenBinaryTreeToLinkedList().flatten(treeNode);
        System.out.println("run");

    }


    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        //root的左子树的最右节点作为root的右子树的父节点
        while(root!=null){
            if(root.left!=null){
                TreeNode temp = root.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                //temp就是root的左子树的最右节点
                //temp的右子树成为root的右子树的父节点
                temp.right = root.right;
                //root的左子树成为root的右子树
                root.right = root.left;
                //root的左子树为空
                root.left = null;
            }
            //root顺着右子树往下移
            root = root.right;
        }
    }

        public void flatten2(TreeNode root) {
        if(root==null){
            return;
        }
        while(root!=null){
            if(root.left==null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right!=null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
