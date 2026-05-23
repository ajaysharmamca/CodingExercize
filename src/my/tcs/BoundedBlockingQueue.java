package my.tcs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<T> {
    Queue<T> queue = new LinkedList<>();

    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void add(T eleemnt) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.offer(eleemnt);
            notEmpty.signal();

        } finally {
            lock.unlock();

        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try{
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            T item = queue.poll();
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public int size() throws InterruptedException {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();

        }
    }

}
