package ds.arrays.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void test_1_sort(){
    //GIVEN
    int[] newArray = new int[]{-20, -80, 100, 320, 45, 1, -4, -9, 10, 56, 1000, -100, 89, -99};
    MergeSort mergeSort = new MergeSort(newArray);
    //WHEN
    int[] result = mergeSort.sort();
    //THEN
    int[] expected = new int[]{-100,-99,-80,-20,-9,-4,1,10,45,56,89,100,320,1000};
    Assertions.assertArrayEquals(expected,result);
  }
}
