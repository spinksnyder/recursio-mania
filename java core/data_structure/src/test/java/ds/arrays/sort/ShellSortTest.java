package ds.arrays.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShellSortTest {

    @Test
    void test_1_sort(){
        //GIVEN
        int[] intArray = new int[]{10, 70, 50, 33, 78, 64, 45, 66};
        //WHEN
        ShellSort shellSort = new ShellSort(intArray);
        int[] result = shellSort.sort();
        //THEN
        int[] expected = new int[]{10, 33, 45, 50, 64, 66, 70, 78};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void test_2_sort(){
        //GIVEN
        int[] intArray = new int[]{-20, -80, 100, 320, 45, 1, -4, -9, 10, 56, 1000, -100, 89, -99};
        //WHEN
        ShellSort shellSort = new ShellSort(intArray);
        int[] result = shellSort.sort();
        //THEN
        int[] expected = new int[]{-100, -99, -80, -20, -9, -4, 1, 10, 45, 56, 89, 100, 320, 1000};
        Assertions.assertArrayEquals(expected, result);
    }
}
