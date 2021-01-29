package sorting;

import java.awt.Rectangle;

public class QuickSort {

    public void sort(Rectangle arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // return 1 
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(Rectangle arr[], int low, int high) {
        int pivot = arr[high].height;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].height <= pivot) {
                i++;
                SortingUtilities.swap(arr, i, j);
            }
        }
        SortingUtilities.swap(arr, i + 1, high);
        return i + 1;
    }
}
