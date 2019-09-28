package com.zkg.trafficount.v3;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/*
 * created by kgzhang 2019/3/21
 */
public class TrailingBucketCounter {

    ConveyorQueue buckets;
    int secsPerBucket;
    LocalDateTime lastUpdateTime;

    public TrailingBucketCounter(int bucketNum, int bucketSecPer) {
        buckets = new ConveyorQueue(bucketNum);
        this.secsPerBucket = bucketSecPer;
        lastUpdateTime =  LocalDateTime.of(1970,1,1,0,0,0);
    }

    public void add(int count, LocalDateTime now) {
        update(now);
        buckets.addToBack(count);

    }

    public int TrailingCount(LocalDateTime now) {
        update(now);
        return buckets.totalSum();
    }

    private void update(LocalDateTime now) {
        int currentBucket = (int) now.toInstant(ZoneOffset.of("+8")).getEpochSecond() / secsPerBucket;
        int lastUpdateBucket = (int) lastUpdateTime.toInstant(ZoneOffset.of("+8")).getEpochSecond() / secsPerBucket;
        buckets.shift(currentBucket - lastUpdateBucket);
        lastUpdateTime = now;
    }


}
