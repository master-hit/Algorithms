package sorting;

import java.awt.Rectangle;

public class SelectionSort {

    public void sort(Rectangle[] arr) {
        for (int funsorted = 0; funsorted < arr.length; funsorted++) {
            int min = funsorted;
            for (int p = funsorted + 1; p < arr.length; p++) {
                if (arr[p].height < arr[min].height) {
                    min = p;
                }
            }
            if (min != funsorted) {
                SortingUtilities.swap(arr, funsorted, min);
            }
        }
    }
}
