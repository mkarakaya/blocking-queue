package com.blockingQueue;

/**
 * Created by p.bell on 12.12.2015.
 */
public interface BlockingQueue<E> extends Iterable<E>{

    /**
     * Pushes an element to the queue. If the queue is full,
     * then calling thread will be blocked.
     */
    void push(E e) throws InterruptedException;
    /**
     * Retrieves and removes the head of this queue, waiting if
     * necessary until an element becomes available.
     *
     * @return the value from the queue.
     */
    E pop() throws InterruptedException;
}


