package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author think
 * @version v 1.0 2019/11/24 9:29
 */
public class MyStack225 {
    public static void main(String[] args) {
        final MyStack225 myStack225 = new MyStack225();
        myStack225.push(1);
        myStack225.push(2);
        myStack225.push(3);
        myStack225.pop();
        myStack225.pop();
        myStack225.pop();
    }

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    /** Initialize your data structure here. */
    public MyStack225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        q2.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q2.isEmpty()){
            return q2.poll();
        }else{
            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }
            while(q2.size()!=1){
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(!q2.isEmpty()){
            return q2.peek();
        }
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        while(q2.size()!=1){
            q1.offer(q2.poll());
        }
        return q2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
