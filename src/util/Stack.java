package util;

import java.util.LinkedList;

/**
 * This is my implementation of a Stack
 * @author Moises
 */
public class Stack<T> {

    private LinkedList<T> storage;
    
    Stack() {
        storage = new LinkedList<T>();
    }

    public T peek() {
        return storage.peek();
    }

    public T pop() {
        return storage.poll();
    }

    public void push(T e) {
        storage.push(e);
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}
