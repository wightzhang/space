package com.zkg.trafficount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * created by kgzhang 2019/3/21
 */
public class MinuteHourCounterV1 implements MinuteHourCounter {

    private List<Event> events = new ArrayList<>();

    @Override
    public void add(int count,LocalDateTime time) {
        events.add(new Event(count,time));
    }

    @Override
    public int minuteCount() {
        return countSince(LocalDateTime.now().plusMinutes(-1));
    }

    @Override
    public int hourCount() {
        return countSince(LocalDateTime.now().plusHours(-1));
    }

    private int countSince(LocalDateTime cutoff) {
        int count = 0;
        for (Event event : events) {
            if (event.getTime().isBefore(cutoff)) {
                break;
            }
            count += event.getCount();
        }
        return count;
    }
}
