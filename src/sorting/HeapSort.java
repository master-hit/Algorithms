package sorting;

import java.awt.Rectangle;

public class HeapSort {

    public void sort(Rectangle arr[]) {
        int length = arr.length;

        // Build heap (rearrange array) 
        for (int node = length / 2 - 1; node >= 0; node--) {
            heapify(arr, length, node);
        }

        // One by one extract an element from heap 
        for (int i = length - 1; i >= 0; i--) {
            // Move current root to end 
            SortingUtilities.swap(arr, i, 0);
            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(Rectangle arr[], int length, int node) {
        int largest = node;  // Initialize largest as root 
        int left = 2 * node + 1;  // left = 2*i + 1 
        int right = 2 * node + 2;  // right = 2*i + 2 

        // If left child is larger than root 
        if (left < length && arr[left].height > arr[largest].height) {
            largest = left;
        }

        // If right child is larger than largest so far 
        if (right < length && arr[right].height > arr[largest].height) {
            largest = right;
        }

        // If largest is not root 
        if (largest != node) {
            SortingUtilities.swap(arr, node, largest);
            // Recursively heapify the affected sub-tree 
            heapify(arr, length, largest);
        }
    }

    // heapify the array 
    // cut the head and heapify the affected sub-trees
    public void sort1(int[] arr) {
        for (int length = arr.length / 2 - 1; length >= 0; length--) {
            heapify1(arr, arr.length, length);
        }
        for (int length = arr.length - 1; length >= 0; length--) {
            int temp = arr[0];
            arr[0] = arr[length];
            heapify1(arr, length, 0);
        }
    }

    private void heapify1(int[] arr, int length, int node) {
        int largest = node;
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        if (left < length && arr[left] > arr[node]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[node]) {
            largest = left;
        }
        if (largest != node) {
            int temp = arr[node];
            arr[node] = arr[largest];
            arr[largest] = temp;
            heapify1(arr, length, largest);
        }
    }
}
