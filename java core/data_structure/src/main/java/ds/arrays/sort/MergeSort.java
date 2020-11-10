package ds.arrays.sort;

public class MergeSort {

    private final int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        sort(array, 0, array.length);
        return array;
    }

    private void sort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        // logically partitioning left side of array
        sort(array, start, mid);
        // logically partitioning right side of array
        sort(array, mid, end);
        // sorting logically partitioned array
        sort(array, start, mid, end);
    }

    private void sort(int[] array, int start, int mid, int end) {
        if (array[mid - 1] <= array[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];
        while (i < mid && j < end) {
            if (array[i] <= array[j]) {
                tempArray[tempIndex] = array[i];
                i++;
            } else {
                tempArray[tempIndex] = array[j];
                j++;
            }
            tempIndex++;
        }
        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, array, start, tempIndex);
    }

    public static void main(String[] args) {
        int[] newArray = new int[]{-20, -80, 100, 320, 45, 1, -4, -9, 10, 56, 1000, -100, 89, -99};
        MergeSort mergeSort = new MergeSort(newArray);
        int[] sort = mergeSort.sort();
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
