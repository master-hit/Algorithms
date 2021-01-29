package sorting;

import java.awt.Rectangle;

public class InsertionSort {

    public void sort1(Rectangle[] arr) {
        for (int x = 0; x < arr.length; x++) {
            int i = x;
            int j = (i + 1 == arr.length) ? i : i + 1;
            while (arr[i].height > arr[j].height) {
                SortingUtilities.swap(arr, i, j);
                if (i > 0) {
                    --i;
                    --j;
                } else {
                    break;
                }
            }
        }
    }

    public void sort2(Rectangle arr[]) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i].height;
            int j = i - 1;
            while (j >= 0 && arr[j].height > key) {
                SortingUtilities.swap(arr, j + 1, j);
                j = j - 1;
            }
            arr[j + 1].height = key;
        }
    }

    public void sort3(Rectangle arr[]) {
        for (int x = 1; x < arr.length; x++) {
            int pntr = x - 1;
            while (pntr >= 0 && arr[pntr].height > arr[pntr + 1].height) {
                SortingUtilities.swap(arr, pntr, pntr + 1);
                pntr--;
            }
        }
    }
}
