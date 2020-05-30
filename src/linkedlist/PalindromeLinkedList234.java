package linkedlist;

/**
 * @author think
 * @version v 1.0 2020/5/30 17:16
 */
public class PalindromeLinkedList234 {
    //234. 回文链表
    //请判断一个链表是否为回文链表。
    //
    //示例 1:
    //
    //输入: 1->2
    //输出: false
    //示例 2:
    //
    //输入: 1->2->2->1
    //输出: true
    //进阶：
    //你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
    //https://leetcode-cn.com/problems/palindrome-linked-list/
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        //ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;
        System.out.println(new PalindromeLinkedList234().isPalindrome(node1));
        ListNode temp = node1;
        while(temp!=null){
            System.out.print(temp.val+"\t");
            temp = temp.next;
        }

    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //1->2->3->3->2->1
        //        slow(第二个3)
        ListNode tail = reverseListNode(slow);
        ListNode beforeReverseHead = tail;
        //1->2->3  1->2->3
        //         tail
        ListNode pre = head;
        while(tail!=null && pre!=null){
            if(tail.val==pre.val){
                tail = tail.next;
                pre = pre.next;
            }else{
                //不是回文,恢复链表
                reverseListNode(beforeReverseHead);
                return false;
            }
        }
        //恢复链表
        reverseListNode(beforeReverseHead);
        return true;
    }

    private ListNode reverseListNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //1->2->3->4
        //pre = 1
        ListNode pre = head;
        //cur = 2
        ListNode cur = head.next;
        pre.next = null;
        while(cur!=null){
            //3
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
