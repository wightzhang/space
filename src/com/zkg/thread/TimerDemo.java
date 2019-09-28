package com.zkg.thread;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/*
 * created by kgzhang 2019/1/26
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        timer.schedule(new MyTask(), date.getTime(), 1000);

    }
}

class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("任务开始");
    }
}
