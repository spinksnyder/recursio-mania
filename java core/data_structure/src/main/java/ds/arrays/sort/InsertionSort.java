package ds.arrays.sort;

public class InsertionSort {

    private final int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        /*
        Initially we are considering first element of array in sorted partition and all other
        elements in unsorted partition. sorted partition is traversed from right to left while
        unsorted partition is traversed from left to right. At the end of each iteration sorted partition
        increases.
         */
        for (int unsortedPartitionIndex = 1; unsortedPartitionIndex < array.length; unsortedPartitionIndex++) {
            int newElement = array[unsortedPartitionIndex];
            int i;
            for (i = unsortedPartitionIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
        return array;
    }
}
