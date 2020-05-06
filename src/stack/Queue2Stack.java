package stack;

import java.util.LinkedList;

/**
 * @author think
 * @version v 1.0 2019/9/29 23:33
 */
public class Queue2Stack {
    public static void main(String[] args) {
        final MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    static class MyStack {

        LinkedList<Integer> q1;
        LinkedList<Integer> q2;
        int top;
        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<Integer>();
            q2 = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(q2.isEmpty()){
                q1.addLast(x);
            }else{
                while(!q2.isEmpty()){
                    q1.addLast(q2.removeFirst());
                }
                q1.addLast(x);
            }
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(q1.size()>1){
                q2.addLast(q1.removeFirst());
            }
            int pop = q1.removeFirst();
            while(!q2.isEmpty()){
                q1.addLast(q2.removeFirst());
            }
            if(!q1.isEmpty()){
                top = q1.getLast();
            }
            return pop;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
