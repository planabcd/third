package tree;

import java.util.LinkedList;

/**
 * @author think
 * @version v 1.0 2019/11/20 23:06
 */
public class SerializeTree297_2 {

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        final String serialize = new SerializeTree297_2().serialize(root);
        System.out.println(serialize);
        final TreeNode deserialize = new SerializeTree297_2().deserialize(serialize);
        final String serialize1 = new SerializeTree297_2().serialize(deserialize);
        System.out.println(serialize1);

        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);

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
        String str = root.val+"!";
        str+= serialize(root.left);
        str+=serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("#!".equals(data)){
            return null;
        }
        final String[] array = data.split("!");
        final LinkedList<String> list = new LinkedList<String>();
        for (String s : array) {
            list.offer(s);
        }
        return helper(list);
    }

    public TreeNode helper(LinkedList<String> list){
        final String poll = list.poll();
        if("#".equals(poll)){
            return null;
        }
        final TreeNode root = getTreeNode(poll);
        root.left = helper(list);
        root.right = helper(list);
        return root;
    }


    public TreeNode getTreeNode(String str){
        if("#".equals(str)){
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }
}
