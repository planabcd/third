package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/21 18:10
 */
public class ReverseLinkedList206 {



    public ListNode reverseList3(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //2->3->4->5
        //cur->cur.next
        //1
        //pre
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;
        while(cur!=null){
            ListNode temp = cur.next;//3
            cur.next = pre;//2->1
            pre = cur;//2->1
            cur = temp;//3->4->5
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head) {
        if(head==null ||head.next==null){
            return head;
        }
        //1
        ListNode result = head;
        //2
        ListNode cur = head.next;
        head.next = null;
        while(cur!=null){
            //3
            ListNode temp = cur.next;
            //2->1
            cur.next = result;
            //2
            result = cur;
            //3
            cur = temp;
        }
        return result;
        //1->2->3->4->5
        //1,2->3->4->5
        //2->1,3->4->5
    }


    public ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //1->2->3->4->5
        //cur->cur.next
        //-1-->1
        ListNode pHead = new ListNode(-1);
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pHead.next;
            pHead.next = cur;
            cur = temp;
        }
        return pHead.next;
    }
}
