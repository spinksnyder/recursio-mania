package ds;

public class Utils {

    private Utils() {
    }

    public static void printArrayElements(int[] array) {
        System.out.print("{");
        int arrayLength = 0;
        for (int element : array) {
            if (arrayLength < array.length-1) {
                System.out.print(element + ",");
            } else {
                System.out.print(element);
            }
            arrayLength++;
        }
        System.out.print("}\n");
    }
}
