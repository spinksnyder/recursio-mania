package ds.stacks;

import java.util.EmptyStackException;

public class ArrayStackImpl<E> implements IStack<E> {

    private Object[] array;

    private int top;

    public ArrayStackImpl(int capacity) {
        this.array = new Object[capacity];
    }

    /**
     * Push elements to end of stack and resize of array is full
     *
     * @param e element to be added
     */
    @Override
    public void push(E e) {
        if (top > array.length - 1) {
            Object[] oldArray = this.array;
            this.array = new Object[2 * array.length];
            System.arraycopy(oldArray, 0, this.array, 0, oldArray.length);
        }
        array[top] = e;
        top++;
    }

    // return last element in stack
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = (E) this.array[top - 1];
        top--;
        return element;
    }

    // returns last element in stack
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) this.array[top - 1];
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
