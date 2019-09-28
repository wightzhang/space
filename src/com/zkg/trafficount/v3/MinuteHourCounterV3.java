package com.zkg.trafficount.v3;

import com.zkg.trafficount.MinuteHourCounter;

import java.time.LocalDateTime;

/*
 * created by kgzhang 2019/3/21
 */
public class MinuteHourCounterV3 implements MinuteHourCounter {
    TrailingBucketCounter minuteCounts;
    TrailingBucketCounter hourCounts;

    public MinuteHourCounterV3() {
        this.minuteCounts = new TrailingBucketCounter(2, 1);
        this.hourCounts = new TrailingBucketCounter(2, 60);
    }


    @Override
    public void add(int count,LocalDateTime time) {
        //LocalDateTime now = LocalDateTime.now();
        minuteCounts.add(count, time);
        hourCounts.add(count, time);
    }

    @Override
    public int minuteCount() {
        LocalDateTime now = LocalDateTime.now();
        return minuteCounts.TrailingCount(now);
    }

    @Override
    public int hourCount() {
        LocalDateTime now = LocalDateTime.now();
        return hourCounts.TrailingCount(now);
    }
}
