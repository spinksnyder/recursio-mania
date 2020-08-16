package ds.arrays;

public class EnhancedArray<E> {

    private final int size;
    private Object[] array;
    private int counter = 0;

    public EnhancedArray() {
        this.size = 1000000;
        this.array = new Object[size];
    }

    public EnhancedArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    public void add(E e) {
        try {
            array[counter] = e;
            counter++;
        } catch (ArrayIndexOutOfBoundsException exception){
            final Object[] newArray = new Object[size*2];
        }
    }

    public void add(int index, E e) {
        E presentElement = (E) array[index];
        if (presentElement != null) {
            System.out.println("Element already present at index: " + index);
        } else array[index] = e;
    }

    public void update(int index, E e) {
        array[index] = e;
    }

    public E get(int index) {
        @SuppressWarnings("Checked") final E e = (E) array[index];
        return e;
    }

    public Object[] getArray() {
        return array;
    }
}
