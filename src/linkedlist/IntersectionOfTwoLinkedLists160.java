package linkedlist;

/**
 * @author liaoxin
 * @version v 1.0 2020/1/31 19:56
 */
public class IntersectionOfTwoLinkedLists160 {
    //编写一个程序，找到两个单链表相交的起始节点。
    //在节点 c1 开始相交。
    //https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            if(a==null){
                a = headB;
            }else{
                a = a.next;
            }
            if(b==null){
                b = headA;
            }else{
                b = b.next;
            }
        }
        return a;
    }
}
