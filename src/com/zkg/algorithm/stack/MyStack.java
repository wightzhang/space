package com.zkg.algorithm.stack;

import com.zkg.algorithm.list.ListNode;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/*
 * created by kgzhang 2019/3/3
 */
public class MyStack {

    public ListNode stackTop;
    public ListNode stackBottom;

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    public static void pushStack(MyStack myStack, int value) {
        ListNode node = new ListNode(value);
        node.next = myStack.stackTop;
        myStack.stackTop = node;
    }

    public static void traverse(MyStack myStack) {
        ListNode stackTop = myStack.stackTop;
        while (stackTop != myStack.stackBottom) {
            System.out.print(stackTop.value + " ");
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    public static boolean isEmpty(MyStack myStack) {
        if (myStack.stackTop == myStack.stackBottom) {
            return true;
        } else {
            return false;
        }
    }

    public static void popStack(MyStack myStack) {
        if (!isEmpty(myStack)) {
            ListNode stackTop = myStack.stackTop;
            myStack.stackTop = stackTop.next;
            System.out.println(stackTop.value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyStack myStack = new MyStack(new ListNode(0),new ListNode(0));
        myStack.stackBottom = myStack.stackTop;
        System.out.println(isEmpty(myStack));
        //pushStack(myStack,1);
        //pushStack(myStack,2);
        //pushStack(myStack,3);
        //traverse(myStack);
        System.out.println(isEmpty(myStack));
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                pushStack(myStack,1);
                pushStack(myStack,2);
                pushStack(myStack,3);
                countDownLatch.countDown();
            }).start();

        }
        countDownLatch.await();
        traverse(myStack);
        Stack stack = new Stack();
    }

}
