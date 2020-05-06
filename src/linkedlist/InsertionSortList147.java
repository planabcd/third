package linkedlist;

/**
 * @author think
 * @version v 1.0 2019/12/14 15:54
 */
@SuppressWarnings("all")
public class InsertionSortList147 {
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
        ListNode listNode5 = new InsertionSortList147().insertionSortList(listNode);
        while (listNode5 != null) {
            System.out.print(listNode5.val + "\t");
            listNode5 = listNode5.next;
        }

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;
                continue;
            }
            ListNode insert = fake;
            while (insert.next.val < cur.next.val) {
                insert = insert.next;
            }
            //insert->cur.next->insert.next
            //ListNode temp = cur.next;
            //cur.next = temp.next;
            //temp.next = insert.next;
            //insert.next = temp;
            //1  2  4  5  6(cur)  3(cur.next)  7(cur.next.next)
            //  2(insert)  4(insert.next)
            ListNode temp = cur.next;//3
            cur.next = temp.next;//6-->7
            temp.next = insert.next; //3-->4
            insert.next = temp; //2-->3
        }
        return fake.next;
    }


    //时间复杂度较高
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sorted = head;
        ListNode unSorted = head.next;
        head.next = null;
        while (unSorted != null) {
            if (unSorted.val < sorted.val) {
                ListNode temp = unSorted.next;
                unSorted.next = sorted;
                sorted = unSorted;
                unSorted = temp;
            } else {
                ListNode preSortedPointer = sorted;
                ListNode sortedPointer = sorted.next;
                while (sortedPointer != null) {
                    if (sortedPointer.val > unSorted.val) {
                        ListNode temp = unSorted.next;
                        preSortedPointer.next = unSorted;
                        unSorted.next = sortedPointer;
                        unSorted = temp;
                        break;
                    } else {
                        preSortedPointer = sortedPointer;
                        sortedPointer = sortedPointer.next;
                    }
                    //sorted 1--->5--->7   unsorted 3
                }
                if (sortedPointer == null) {
                    ListNode temp = unSorted.next;
                    preSortedPointer.next = unSorted;
                    unSorted.next = null;
                    unSorted = temp;

                }
            }
        }
        return sorted;
    }

}
