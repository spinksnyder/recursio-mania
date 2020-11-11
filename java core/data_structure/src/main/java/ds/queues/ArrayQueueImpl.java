package ds.queues;

import java.util.NoSuchElementException;

public class ArrayQueueImpl<E> implements IQueue<E> {

    private Object[] array;
    private int top;

    public ArrayQueueImpl(int capacity) {
        this.array = new Object[capacity];
    }

    /**
     * Add element to end of queue and resize if queue is full
     * @param e element to be added
     */
    @Override
    public void add(E e) {
        if (top > array.length - 1) {
            Object[] oldArray = this.array;
            this.array = new Object[2 * array.length];
            System.arraycopy(oldArray, 0, this.array, 0, oldArray.length);
        }
        array[top] = e;
        top++;
    }

    /**
     * remove first element of the queue and shift the array by 1 position left
     * @return fist element from queue
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E e = (E) this.array[0];
        shift();
        top--;
        return e;
    }

    private void shift() {
        for (int i = 1; i <= top; i++) {
            this.array[i-1]=this.array[i];
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }
}
