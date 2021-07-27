package ds.arrays.sort;

/**
 * This algorithm is enhancement to insertion sort.
 * Here, sorting is done in two phases,
 * 1. elements inside array are first sorted based on gap value.
 * 2. sorting done as per insertion sort.
 * <p>
 * Gap value:- gap value is calculated based on array length and with each successful
 * iteration of array , value is decreased until it is 1.
 * <p>
 * so when gap value is 1 then it is same as insertion sort algorithm.
 */
public class ShellSort {

    private final int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        int gapValue = array.length / 2;
        while (gapValue >= 1) {
            for (int i = gapValue; i < array.length; i++) {
                int newElement = array[i];
                int j;
                for (j = i; j > 0 && j - gapValue >= 0 && array[j - gapValue] > newElement; j = j - gapValue) {
                    array[j] = array[j - gapValue];
                }
                array[j] = newElement;
            }
            gapValue = gapValue / 2;
        }
        return array;
    }

}
