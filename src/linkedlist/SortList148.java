package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/14 18:03
 */
public class SortList148 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        //ListNode listNode = new ListNode(-1);
        //ListNode listNode1 = new ListNode(5);
        //ListNode listNode2 = new ListNode(3);
        //ListNode listNode3 = new ListNode(4);
        //ListNode listNode4 = new ListNode(0);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = new SortList148().sortList(listNode);
        while (listNode5 != null) {
            System.out.print(listNode5.val + "\t");
            listNode5 = listNode5.next;
        }
    }


    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        //切断左链表和右链表关联
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeSortList(left,right);
    }

    public ListNode mergeSortList(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        ListNode head;
        if(node1.val<node2.val){
            head = node1;
            node1 = node1.next;
        }else{
            head = node2;
            node2 = node2.next;
        }
        ListNode pre = head;
        while(node1!=null && node2!=null){
            if(node1.val<node2.val){
                pre.next = node1;
                node1 = node1.next;
            }else{
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        if(node1!=null){
            pre.next = node1;
        }else{
            pre.next = node2;
        }
        return head;
    }
}
