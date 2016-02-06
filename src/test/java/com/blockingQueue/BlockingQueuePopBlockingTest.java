package com.blockingQueue;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bell on 12.12.2015.
 */
public class BlockingQueuePopBlockingTest extends TestCase {

    /**
     * size:4
     * scenario: pop,pop,pop,pop,push,push,push,push
     * @throws InterruptedException
     */
    public void test() throws InterruptedException {
        BlockingQueue blockingQueue= new BlockingQueueImpl(4);
        Integer expected=new Integer(1);
        Integer expected2=new Integer(2);
        Integer expected3=new Integer(3);
        Integer expected4=new Integer(4);
        List<Integer> expectedList=new ArrayList<Integer>();
        expectedList.add(expected);
        expectedList.add(expected2);
        expectedList.add(expected3);
        expectedList.add(expected4);
        QueueThreadPop queueThread=new QueueThreadPop(blockingQueue,4);
        Thread thread=new Thread(queueThread);
        thread.start();

        blockingQueue.push(expected);
        blockingQueue.push(expected2);
        blockingQueue.push(expected3);
        blockingQueue.push(expected4);
        thread.join();
        List<Object> values=queueThread.getValues();
        assertEquals(expectedList.size(),values.size());
        for (int i=0;i<values.size();i++) {
            assertEquals(expectedList.get(i), values.get(i));
        }

    }
}
