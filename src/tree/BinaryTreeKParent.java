package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/1/19 0:17
 */
public class BinaryTreeKParent {
    //二叉树的K级祖先如果为偶数,则将当前节点值累加

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        sum(root);
        System.out.println(res);
    }
    
    
    static int res = 0;
    static List<Boolean> parentList = new ArrayList<>();
    static int k = 2;


    private static void sum(TreeNode root){
        if(root==null){
            return;
        }
        parentList.add(root.val%2==0);
        int size = parentList.size();
        int kParentIndex = size-(k+1);
        if(kParentIndex>=0){
            if(parentList.get(kParentIndex)){
                res+=root.val;
            }
        }
        sum(root.left);
        sum(root.right);
        parentList.remove(parentList.size()-1);
    }
}
