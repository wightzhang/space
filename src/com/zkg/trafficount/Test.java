package com.zkg.trafficount;

import com.zkg.trafficount.v3.MinuteHourCounterV3;

import java.time.LocalDateTime;

/*
 * created by kgzhang 2019/3/21
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        MinuteHourCounter minuteHourCounter = new MinuteHourCounterV3();
        LocalDateTime now = LocalDateTime.now();
        minuteHourCounter.add(30, now);
        minuteHourCounter.add(20, now);
        Thread.sleep(3000);
        minuteHourCounter.add(80, now);
        minuteHourCounter.add(60, now);
        System.out.println(minuteHourCounter.minuteCount());
        System.out.println(minuteHourCounter.hourCount());
    }
}
