package tree;

import linkedlist.ListNode;

/**
 * @author think
 * @version v 1.0 2020/8/20 0:05
 */
public class ConvertSortedListToBinarySearchTree109 {
    //109. 有序链表转换二叉搜索树
    //给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
    //
    //本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    //
    //示例:
    //
    //给定的有序链表： [-10, -3, 0, 5, 9],
    //
    //一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
    //
    //        0
    //        / \
    //        -3   9
    //        /   /
    //        -10  5

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head,null);
    }

    private TreeNode helper(ListNode left, ListNode right) {
        if(left==right){
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(left,mid);
        root.right = helper(mid.next,right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right){
        ListNode slow = left;
        ListNode fast = left;
        while(fast.next!=right && fast.next.next!=right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
