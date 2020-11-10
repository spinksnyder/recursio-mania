package ds.stacks;

import java.util.LinkedList;

public class LinkedListStack<E> implements IStack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();
    @Override
    public void push(E e) {
        linkedList.push(e);
    }

    @Override
    public E pop() {
        return linkedList.pop();
    }

    @Override
    public E peek() {
        return linkedList.peek();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }
}
