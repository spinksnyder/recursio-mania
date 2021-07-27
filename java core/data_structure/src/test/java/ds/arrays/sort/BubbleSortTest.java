package ds.arrays.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void test_1_sort() {
        //GIVEN
        int[] intArray = new int[]{110, 20, 4, 400, 50, 3, 4, -1};
        //WHEN
        BubbleSort bubbleSort = new BubbleSort(intArray);
        int[] result = bubbleSort.sort();
        //THEN
        int[] expected = new int[]{-1, 3, 4, 4, 20, 50, 110, 400};
        Assertions.assertArrayEquals(expected, result);
    }

}
