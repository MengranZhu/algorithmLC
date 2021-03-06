package src.microsoft;
/*
 * leetcode: 232. Implement Queue using Stacks
 *solution: use two stack
 *
 *
 *
 *
 * */

import src.tag.Stacks;

import java.util.Stack;

@Stacks
public class ImplementQueueUsingStacks {
    class MyQueue {

        private Stack<Integer> stk1 = new Stack<>();
        private Stack<Integer> stk2 = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!stk2.isEmpty()) {
                stk1.push(stk2.pop());
            }
            stk1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
            return stk2.pop();

        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
            return stk2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stk1.isEmpty() && stk2.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}
