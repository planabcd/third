package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/21 15:06
 */
public class RemoveNthNodeFromEndOfList19 {
    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    //
    //示例：
    //
    //给定一个链表: 1->2->3->4->5, 和 n = 2.
    //
    //当删除了倒数第二个节点后，链表变为 1->2->3->5.
    //说明：
    //
    //给定的 n 保证是有效的。
    //
    //进阶：
    //
    //你能尝试使用一趟扫描实现吗？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
    //public ListNode removeNthFromEnd(ListNode head, int n) {
    //    if(head==null){
    //        return head;
    //    }
    //    ListNode pre = new ListNode(-1);
    //    pre.next = head;
    //    ListNode cur = pre;
    //    while(n>0){
    //        cur = cur.next;
    //        n--;
    //    }
    //    if(cur.next==null){
    //        return head.next;
    //    }
    //    while(cur.next!=null){
    //        pre = pre.next;
    //        cur = cur.next;
    //    }
    //    pre.next = pre.next.next;
    //    return head;
    //}

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //给定一个链表: 1->2->3->4->5, 和 n = 2.
        //当删除了倒数第二个节点后，链表变为 1->2->3->5
        if(head==null || n<=0){
            return head;
        }
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode cur = pHead;
        while(n>0){
            cur = cur.next;
            n--;
        }
        ListNode temp = pHead;
        while(cur.next!=null){
            cur = cur.next;
            temp = temp.next;
        }
        if(temp==pHead){
            return pHead.next.next;
        }
        temp.next = temp.next.next;
        return pHead.next;
    }
}
