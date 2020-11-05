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

    // returns first element of the list
    @Override
    public E get() {
        if (this.head == null) {
            return null;
        }
        return this.head.data;
    }

    @Override
    public E get(E e) {
        if (this.head == null) {
            return null;
        }
        return get(this.head, e);
    }

    private E get(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        if (node.data.equals(e)) {
            return node.data;
        }
        return get(node.next, e);
    }

    @Override
    public boolean remove(E e) {
        if (this.head != null && this.head.data.equals(e)) {
            remove();
            size--;
            return true;
        } else if (this.head == null) {
            return false;
        } else {
            return remove(head, head.next, e);
        }
    }

    private boolean remove(Node<E> previousNode, Node<E> currentNode, E e) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.data.equals(e)) {
            previousNode.next = currentNode.next;
            size--;
            return true;
        } else return remove(currentNode, currentNode.next, e);
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
        if (this.head != null && this.head.next != null) {
            System.out.println(head.data.toString());
            iterate(this.head.next);
        }
    }

    private void iterate(Node<E> node) {
        if (node != null) {
            System.out.println(node.data.toString());
            iterate(node.next);
        }
    }

    // check if list contains object
    @Override
    public boolean contains(E e) {
        if (this.head != null) {
            return contains(this.head, e);
        }
        return false;
    }

    /**
     * @param objectToBeAdded new object to be added in list
     * @param existingObject  existing object in list before which new object is being inserted
     * @return true if object is added to list
     */
    public boolean addBefore(E objectToBeAdded, E existingObject) {
        if (this.head != null && this.head.data.equals(existingObject)) {
            return add(objectToBeAdded);
        } else {
            if (this.head.next != null) {
                return addBefore(objectToBeAdded, existingObject, this.head, this.head.next);
            } else {
                throw new NoSuchElementException("End of List reached");
            }
        }
    }

    private boolean addBefore(E objectToBeAdded, E existingObject, Node<E> previousNode, Node<E> currentNode) {
        if (currentNode != null && currentNode.data.equals(existingObject)) {
            Node<E> nodeToBeAdded = new Node<>(objectToBeAdded);
            previousNode.next = nodeToBeAdded;
            nodeToBeAdded.next = currentNode;
            size++;
            return true;
        } else {
            if (currentNode.next != null) {
                return addBefore(objectToBeAdded, existingObject, currentNode, currentNode.next);
            } else {
                throw new NoSuchElementException("End of List reached");
            }
        }
    }

    private boolean contains(Node<E> node, E e) {
        if (node.data.equals(e)) {
            return true;
        }
        if (node.next == null) {
            return false;
        }
        return contains(node.next, e);
    }

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }
    }
}
