package sorting;

import java.awt.Rectangle;

public class QuickSortV2 {

    public void quickSort(Rectangle[] arr, int head, int tail) {
        int length = (tail - head) + 1;
        if (length >= 2) {
            int pivot = partition(arr, head, tail);
            quickSort(arr, head, pivot - 1);
            quickSort(arr, pivot + 1, tail);
        }
    }

    // partition choosing the first as the pivot
    private int partition(Rectangle[] arr, int head, int tail) {
        int pivot = head;
        int next = head + 1;
        while (next <= tail) {
            if (arr[next].height > arr[pivot].height) {
                SortingUtilities.swap(arr, next, tail);
                tail--;
            } else if (arr[next].height < arr[pivot].height) {
                SortingUtilities.swap(arr, next, pivot);
                next++;
                pivot++;
            }
        }
        return pivot;
    }

    // partition choosing the last as the pivot
    private int partition2(Rectangle[] arr, int head, int tail) {
        int pivot = tail;
        int lastSmallest = head;
        for (int i = 0; i <= tail; i++) {
            if (arr[i].height <= arr[pivot].height) {
                lastSmallest++;
                SortingUtilities.swap(arr, i, lastSmallest);
            }
        }
        return lastSmallest;
    }
}
