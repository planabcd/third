package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/14 12:10
 */
public class MergeTwoSortedList21 {


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode pre;
        if(l1.val>l2.val){
            head.next = l2;
            pre = l2;
            l2 = l2.next;
        }else{
            head.next = l1;
            pre = l1;
            l1 = l1.next;
        }
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            pre.next = l1;
        }else{
            pre.next = l2;
        }
        return head;
    }
}
