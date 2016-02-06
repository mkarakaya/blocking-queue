package com.blockingQueue;

import com.blockingQueue.BlockingQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bell on 12.12.2015.
 */
public class QueueThreadPop implements Runnable{

    private List<Object> values;
    BlockingQueue blockingQueue;
    private int times;
    public QueueThreadPop(BlockingQueue blockingQueue,int times){
        this.blockingQueue=blockingQueue;
        this.times=times;
        values=new ArrayList<Object>();
    }
    public void run(){
        try {
            for(int i=0;i<times;i++){
               values.add(blockingQueue.pop());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Object> getValues() {
        return values;
    }
}
