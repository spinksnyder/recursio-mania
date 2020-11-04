package ds.lists;

public class SinglyLinkedList<E> implements IList<E> {

    private int size;

    private Node<E> head;

    public SinglyLinkedList(E data) {
        this.head = new Node<>(data);
        this.head.next = null;
        size++;
    }

    // add elements to the beginning of the list
    @Override
    public boolean add(E e) {
        Node<E> previousHead = this.head;
        this.head = new Node<>(e);
        this.head.next = previousHead;
        size++;
        return true;
    }

    // remove element from beginning of list
    @Override
    public boolean remove() {
        if (this.head == null) {
            return false;
        }
        Node<E> oldHead = this.head;
        this.head = this.head.next;
        oldHead.next = null;
        size--;
        return true;
    }

    @Override
    public E get() {
        return null;
    }

    @Override
    public E get(E e) {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    // check if list is empty or not
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    // get the size of list
    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse() {

    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }
    }
}
