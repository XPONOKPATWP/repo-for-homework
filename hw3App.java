package gr.aueb.cf.ch9;

import java.util.Arrays;

public class hw3App {

    public static int[][] shallowCopy(int[][] arr) {
        if (arr == null) return null;
        return Arrays.copyOf(arr, arr.length);
    }

    public static int[][] deepCopy(int[][] arr) {
        if (arr == null) return null;
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public static void main(String[] args) {
        int[][] original = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Shallow copy
        int[][] shallowCopy = shallowCopy(original);

        // Deep copy
        int[][] deepCopy = deepCopy(original);

        shallowCopy[0][0] = 10;
        System.out.println("Πρωτότυπο μετά από τροποποίηση shallow copy:");
        printArray(original);
        System.out.println("Shallow Copy:");
        printArray(shallowCopy);

        deepCopy[1][1] = 20;
        System.out.println("Πρωτότυπο μετά από τροποποίηση deep copy:");
        printArray(original);
        System.out.println("Deep Copy:");
        printArray(deepCopy);
    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
