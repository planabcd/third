package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/11/9 13:24
 */
public class MergeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(1);
        ListNode head5 = new ListNode(3);
        ListNode head6 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head4.next = head5;
        head5.next = head6;
        new MergeLinkedList().mergeTwoLists(head,head4);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode pHead = new ListNode(-1);
        if(l1.val>l2.val){
            pHead.next = l2;
            l2 = l2.next;
        }else{
            pHead.next = l1;
            l1 = l1.next;
        }
        ListNode pre = pHead.next;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1!=null){
            pre.next = l2;
        }else{
            pre.next = l1;
        }
        return pHead.next;
    }


    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
