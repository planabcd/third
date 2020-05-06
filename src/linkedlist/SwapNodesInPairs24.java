package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/21 12:13
 */
public class SwapNodesInPairs24 {
    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //
    //你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    //
    //         
    //
    //示例:
    //
    //给定 1->2->3->4, 你应该返回 2->1->4->3.
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode temp = cur.next.next; //3
            cur.next.next = cur; //2-->1
            pre.next = cur.next;//-1-->2
            cur.next = temp;//1-->3
            pre = pre.next.next;//2
            cur = cur.next;//3
        }
        return preHead.next;
    }



}
