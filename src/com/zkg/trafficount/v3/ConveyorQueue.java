package com.zkg.trafficount.v3;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * created by kgzhang 2019/3/21
 */
public class ConveyorQueue {

    private ArrayDeque<Integer> q = new ArrayDeque<>();
    private int maxItems;
    int totalSum;

    public ConveyorQueue(int maxItems) {
        this.maxItems = maxItems;
        this.totalSum = 0;
    }


    public int totalSum() {
        return totalSum;
    }

    void shift(int shiftedNum) {
        if (shiftedNum >= maxItems) {
            q = new ArrayDeque<>();
            totalSum = 0;
            return;
        }

        while (shiftedNum > 0) {
            q.add(0);
            shiftedNum--;
        }

        while (q.size() > maxItems) {
            totalSum -= q.poll();
        }
    }

    public void addToBack(int count) {
        if (q.isEmpty()) {
            shift(1);
        }
        Integer last = q.pollLast();
        last += count;
        q.offerLast(last);
        totalSum += count;
    }

}
