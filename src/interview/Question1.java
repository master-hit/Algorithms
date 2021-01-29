package interview;

/**
 * Given an array arr of unique nonnegative integers, implement a function
 * getDifferentNumber that finds the smallest nonnegative integer that is not in
 * the array
 *
 * @author Moises
 */
public class Question1 {

    private static double MAX_INT = Math.pow(2, 32) - 1;

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3};
        System.out.println("smallest: " + getDifferentNumber(arr));
    }

    public static int getDifferentNumber(int[] arr) {
        int min = 0;

        while (isInArray(arr, min)) {
            min++;
        }

        return min;
    }

    public static boolean isInArray(int[] arr, int n) {
        for (int e : arr) {
            if (e == n) {
                return true;
            }
        }
        return false;
    }
}
