package com.blockingQueue;

import com.blockingQueue.BlockingQueue;

import java.util.List;

/**
 * Created by p.bell on 12.12.2015.
 */
public class QueueThreadPush implements Runnable{

    private List<Object> values;
    BlockingQueue blockingQueue;
    public QueueThreadPush(BlockingQueue blockingQueue,List<Object> values) {
        this.blockingQueue=blockingQueue;
        this.values=values;
    }
    public void run(){
        try {
            for(Object value:values) {
                blockingQueue.push(value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
