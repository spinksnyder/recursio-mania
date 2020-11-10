package ds.lists;

public interface IList<E> {

    boolean add(E e);

    boolean remove();

    E get();

    E get(E e);

    boolean contains(E e);

    boolean remove(E e);

    int size();

    boolean isEmpty();

    void traverse();

}
