package com.blockingQueue;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bell on 12.12.2015.
 */
public class BlockingQueueMixedBlockingTest extends TestCase {

    /**
     * size:2
     * scenario: pop,pop,push,push,push,push,pop,pop
     * @throws InterruptedException
     */
    public void test() throws InterruptedException {
        BlockingQueue blockingQueue= new BlockingQueueImpl(2);

        QueueThreadPop queueThreadPop=new QueueThreadPop(blockingQueue,2);
        Thread threadPop=new Thread(queueThreadPop);
        threadPop.start();

        Integer expected=new Integer(1);
        Integer expected2=new Integer(2);
        Integer expected3=new Integer(3);
        Integer expected4=new Integer(4);
        List<Object> expectedList=new ArrayList<Object>();
        expectedList.add(expected);
        expectedList.add(expected2);


        List<Object> values=new ArrayList<Object>();
        values.add(expected);
        values.add(expected2);
        values.add(expected3);
        values.add(expected4);

        QueueThreadPush queueThread=new QueueThreadPush(blockingQueue,values);
        Thread thread=new Thread(queueThread);
        thread.start();
        thread.join();

        List<Object> result=queueThreadPop.getValues();
        assertEquals(expectedList.size(), result.size());
        for (int i=0;i<result.size();i++) {
            assertEquals(expectedList.get(i), result.get(i));
        }
        assertEquals(expected3, blockingQueue.pop());
        assertEquals(expected4, blockingQueue.pop());

    }


}
