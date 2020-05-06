package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/19 0:35
 */
public class AddTowNumbers02 {

    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    //如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    //您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //
    //示例：
    //
    //输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/add-two-numbers

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode pHead = new ListNode(-1);
        ListNode cur = pHead;
        int j = 0;
        while(l1!=null || l2!=null){
            int a = 0;
            int b = 0;
            if(l1!=null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                b = l2.val;
                l2 = l2.next;
            }
            int res = a+b+j;
            if(res<10){
                ListNode node = new ListNode(res);
                cur.next = node;
                cur = node;
                j = 0;
            }else{
                ListNode node = new ListNode(res % 10);
                cur.next = node;
                cur = node;
                j = 1;
            }
        }
        if(j==1){
            cur.next = new ListNode(1);
        }
        return pHead.next;
    }
}
