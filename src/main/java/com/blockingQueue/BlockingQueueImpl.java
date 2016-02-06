package com.blockingQueue;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by p.bell on 12.12.2015.
 */
public class BlockingQueueImpl<E> implements BlockingQueue<E> {

    private Queue<E> queue;
    private int maxSize;
    // lock objects for push and pop methods.
    private final Object lockPush = new Object();
    private final Object lockPop = new Object();

    public BlockingQueueImpl(int maxSize){
        queue=new LinkedList<E>();
        this.maxSize=maxSize;
    }
    public void push(E e) throws InterruptedException {
        synchronized (lockPush){
            while (queue.size() >= maxSize) {
                Thread.sleep(1);
            }
            queue.add(e);
        }
    }

    public  E pop() throws InterruptedException {
        synchronized (lockPop){
            while (queue.size() < 1) {
                Thread.sleep(1);
            }
            return queue.poll();
        }
    }

    public Iterator<E> iterator() {
        throw new NotImplementedException();
    }
}
