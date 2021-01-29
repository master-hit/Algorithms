package util;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Moises
 */
public class Queue<T> {

    java.util.Queue<T> storage;

    public Queue() {
        storage = new LinkedList<>();
    }

    /**
     * @return removes the head of the queue. null if the queue is empty
     */
    public T deQueue() {
        return storage.poll();
    }
    
    /**
     * insets an element at the tail of the queue if it can, or returns false
     */
    public void enQueue(T e) {
        storage.offer(e);
    }

    /**
     * @return return the head of the queue without removing it, return null if
     * the queue is empty
     */
    public T head() {
        return storage.peek();
    }

    /**
     * @return returns whether the queue is empty or not
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * @return returns the size of the queue
     */
    public int size() {
        return storage.size();
    }
    
    /**
     * @param t
     * @return whether this queue contains the given t
     */
    public boolean contains(T t) {
        return storage.contains(t);
    }
    
    /**
     * @return returns an array representation of this queue
     */
    public Object[] toArray() {
        return storage.toArray();
    }
    

    public String toString() {
        return storage.toString();
    }
}
