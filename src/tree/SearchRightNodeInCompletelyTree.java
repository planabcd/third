package tree;

/**
 * @author think
 * @version v 1.0 2019/12/18 22:40
 */
public class SearchRightNodeInCompletelyTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        //TreeNode treeNode7 = new TreeNode(7);
        root.left = treeNode2;
        root.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        //treeNode3.left = treeNode6;
        //treeNode3.right = treeNode7;
        TreeNode treeNode = new SearchRightNodeInCompletelyTree().find(root);
        System.out.println(treeNode.val);
    }

    public TreeNode find(TreeNode root){
        if(root==null || root.left==null){
            return root;
        }
        int ld = 0;
        TreeNode temp = root.left;
        while(temp!=null){
            ld++;
            temp = temp.left;
        }
        temp = root.right;
        int rd = 0;
        while(temp!=null){
            rd++;
            temp = temp.left;
        }
        if(ld>rd){
            return find(root.left);
        }
        return find(root.right);




    }
}
