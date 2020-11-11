package ds.queues;

public interface IQueue<E> {

    void add(E e);

    E remove();

    E peek();

    boolean isEmpty();

    int size();
}
