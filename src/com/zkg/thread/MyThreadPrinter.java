package com.zkg.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * created by kgzhang 2019/7/9
 */
public class MyThreadPrinter extends Thread {
    String name;
    Lock lock;
    Condition currentCondition;
    Condition nextCondition;
    static int count = 0;

    public MyThreadPrinter(String name, Lock lock, Condition currentCondition, Condition nextCondition) {
        this.name = name;
        this.lock = lock;
        this.currentCondition = currentCondition;
        this.nextCondition = nextCondition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            while (count % 3 != 0) {
                currentCondition.await();
            }
            System.out.println(name);
            count++;
            nextCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }



    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        new MyThreadPrinter("A", lock, a, b).start();
        new MyThreadPrinter("B", lock, b, c).start();
        new MyThreadPrinter("C", lock, c, a).start();
    }
}
