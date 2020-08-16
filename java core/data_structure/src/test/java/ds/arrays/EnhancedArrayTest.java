package ds.arrays;

import org.junit.jupiter.api.Test;

class EnhancedArrayTest {

    @Test
    void test(){
        EnhancedArray<Integer> enhancedArray = new EnhancedArray<>(100);
        enhancedArray.add(10);
        enhancedArray.add(100);
        enhancedArray.add(110);
        enhancedArray.add(120);
        enhancedArray.add(130);
        enhancedArray.add(140);
        enhancedArray.add(150);
        enhancedArray.add(5, 1000);
        Object[] array = enhancedArray.getArray();
        for (Object element : array) {
            if (element == null) {
                System.out.println("NULL value");
            } else {
                System.out.println((Integer) element);
            }
        }
        enhancedArray.add(160);
        enhancedArray.add(101);
        enhancedArray.add(1002);
        enhancedArray.add(1103);
        enhancedArray.add(1204);
        enhancedArray.add(1305);
        enhancedArray.add(1406);
        enhancedArray.add(1505);
        System.out.println("Again added some elements");
        for (Object element : array) {
            if (element == null) {
                System.out.println("NULL value");
            } else {
                System.out.println((Integer) element);
            }
        }

        System.out.println("Updating element");
        enhancedArray.update(1,100000);
        System.out.println("Getting after updating value: "+enhancedArray.get(1));

    }
}
