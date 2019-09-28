package com.zkg.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * created by kgzhang 2018/12/24
 */
public class ThredPoolDemo implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            executorService.execute(new ThredPoolDemo());

        }
        executorService.shutdown();
    }
}
