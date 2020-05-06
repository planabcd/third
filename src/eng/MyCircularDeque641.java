package eng;

/**
 * @author think
 * @version v 1.0 2019/11/17 11:08
 */
public class MyCircularDeque641 {
    public static void main(String[] args) {
        MyCircularDeque641 circularDeque = new MyCircularDeque641(3); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4
    }


    int size = 0;
    int cap = 0;
    Node first;
    Node last;


    class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque641(int k) {
        size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(cap==size){
            return false;
        }
        cap++;
        Node node = new Node(value);
        if(cap==1){
            first = node;
            last = node;
            return true;
        }
        Node temp = first;
        node.next = first;
        first = node;
        temp.prev = first;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(cap==size){
            return false;
        }
        cap++;
        Node node = new Node(value);
        if(cap==1){
            first = node;
            last = node;
            return true;
        }
        Node temp = last;
        last.next = node;
        last = node;
        last.prev = temp;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(cap==0){
            return false;
        }
        cap--;
        if(cap==0){
            first = null;
            last = null;
            return true;
        }
        Node temp = first;
        first = first.next;
        temp.next = null;
        first.prev = null;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(cap==0){
            return false;
        }
        cap--;
        if(cap==0){
            first = null;
            last = null;
            return true;
        }
        Node temp = last;
        last = last.prev;
        temp.prev = null;
        last.next = null;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return first.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return last.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cap==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cap==size;
    }
}
