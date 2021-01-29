package sorting;

import java.awt.Rectangle;

/**
 * there are some mistakes
 * @author Moises
 */
public class PancakeSort {
    
    static int count = 0;

    public void pancakeSort(Rectangle[] arr) {
        int max_index = 0;
        for (int tail = arr.length - 1; tail > 0; tail--) {
            for (int i = 0; i <= tail; i++) {
                if (arr[i].height > arr[max_index].height) {
                    max_index = i;
                }
            }
            SortingUtilities.swap(arr, max_index, 0);
            flip(arr, tail + 1);
        }
    }

    private static void flip(Rectangle[] arr, int k) {
        for (int head = 0, tail = k - 1; head < k / 2; head++, tail--) {
            SortingUtilities.swap(arr, head, tail);
        }
    }
}
