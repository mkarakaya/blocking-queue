package com.blockingQueue;

import com.blockingQueue.BlockingQueue;
import com.blockingQueue.BlockingQueueImpl;
import junit.framework.TestCase;

/**
 * Created by p.bell on 12.12.2015.
 */
public class BlockingQueueSimpleTest extends TestCase {

    public void test() throws InterruptedException {
        Integer expected=new Integer(2);
        BlockingQueue blockingQueue= new BlockingQueueImpl(2);
        blockingQueue.push(expected);
        Integer value = (Integer) blockingQueue.pop();
        assertEquals(expected,value);
    }
}
