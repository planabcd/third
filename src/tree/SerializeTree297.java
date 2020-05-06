package tree;

import java.util.LinkedList;

/**
 * @author think
 * @version v 1.0 2019/11/20 23:06
 */
public class SerializeTree297 {

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        final String serialize = new SerializeTree297().serialize(root);
        System.out.println(serialize);
        final TreeNode deserialize = new SerializeTree297().deserialize(serialize);

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#!";
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        String str = root.val+"!";
        while(!queue.isEmpty()){
            TreeNode head = queue.remove();
            if(head.left!=null){
                str+=head.left.val+"!";
                queue.offer(head.left);
            }else{
                str+="#!";
            }
            if(head.right!=null){
                str+=head.right.val+"!";
                queue.offer(head.right);
            }else{
                str+="#!";
            }
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0 || "#!".equals(data)){
            return null;
        }
        String[] array = data.split("!");
        int index = 0;
        TreeNode root = getTreeNode(array[index]);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode head= queue.poll();
            TreeNode left = getTreeNode(array[++index]);
            TreeNode right = getTreeNode(array[++index]);
            if(left!=null){
                head.left = left;
                queue.offer(left);
            }
            if(right!=null){
                head.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public TreeNode getTreeNode(String str){
        if("#".equals(str)){
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }
}
