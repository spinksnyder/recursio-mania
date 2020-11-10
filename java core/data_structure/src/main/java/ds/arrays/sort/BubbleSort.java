package ds.arrays.sort;

/**
 * This is bubble sort algorithm in which first element is compared with second
 * element in array and if it is grater then elements are swapped.
 * After swapping 0th and 1st element, 1st and 2nd are compared and swapped if grater
 * and so on. All in all, at the end of first loop last element inside array will be largest among
 * all the element, in this way we are creating two logical partition in same array,
 * left side will be unsorted and right side will be sorted.
 */
public class BubbleSort {

    private final int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    // o(n^2)
    public int[] sort() {
        // sorted partition size from end of array
        int partitionSize = 0;
        while (partitionSize < array.length - 1) {
            int endOfUnSortedPartitionIndex = array.length - 1 - partitionSize;
            int startIndex = 0;
            /*
            At the end of each for loop, size of sorted partition will increase as
            it will contain all elements that are sorted and grater then other elements
            from left side of unsorted partition.
             */
            for (int i = startIndex; i < endOfUnSortedPartitionIndex; i++) {
                int currentElement = array[i];
                int nextElement = array[i + 1];
                if (currentElement > nextElement) {
                    array[i] = nextElement;
                    array[i + 1] = currentElement;
                }
                startIndex++;
            }
            partitionSize++;
        }
        return this.array;
    }
}
