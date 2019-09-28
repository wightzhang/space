package com.zkg.trafficount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * created by kgzhang 2019/3/21
 */
public class MinuteHourCounterV2 implements MinuteHourCounter {

    List<Event> minuteEvents = new ArrayList<>();
    List<Event> hourEvents = new ArrayList<>();

    int minuteCount = 0;
    int hourCount = 0;

    @Override
    public void add(int count,LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        shiftOldEvents(now);
        minuteEvents.add(new Event(count, time));
        minuteCount += count;
        hourCount += count;
    }


    @Override
    public int minuteCount() {
        shiftOldEvents(LocalDateTime.now());
        return minuteCount;
    }

    @Override
    public int hourCount() {
        shiftOldEvents(LocalDateTime.now());
        return hourCount;
    }


    private void shiftOldEvents(LocalDateTime now) {
        Iterator<Event> minIterator = minuteEvents.iterator();
        while (minIterator.hasNext()) {
            Event event = minIterator.next();
            if (event.getTime().isBefore(now.plusSeconds(-1))) {
                hourEvents.add(event);
                minuteCount -= event.getCount();
                minIterator.remove();
            }

        }

        Iterator<Event> hourIterator = hourEvents.iterator();
        while (hourIterator.hasNext()) {
            Event event = hourIterator.next();
            if (event.getTime().isBefore(now.plusSeconds(-3))) {
                hourCount -= event.getCount();
                hourIterator.remove();
            }
        }
    }
}
