package com.zkg.algorithm.queue;

import java.util.Stack;

/*
 * created by kgzhang 2019/3/3
 */
public class TowStackOneQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TowStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value) {
        stackPush.push(value);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){

        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TowStackOneQueue queue =
                new TowStackOneQueue(new Stack<Integer>(),new Stack<Integer>());

        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.gc();
    }
}
