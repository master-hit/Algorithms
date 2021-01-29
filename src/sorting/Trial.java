package sorting;

import java.awt.Rectangle;


public class Trial  {
    Rectangle[] arr;
    
    public static void heapSort(Rectangle[] arr) {
        //make heap
        for (int i = arr.length/2-1; i>=0; i--) {
            makeHeap(arr, arr.length, i);
        }
        //remove head and make heap again
        for (int i = arr.length-1; i>=0; i--) {
            SortingUtilities.swap(arr,0,i);
            makeHeap(arr,i,0);
	}
    }


    private static void makeHeap(Rectangle[] arr, int length, int node) {
	//find last node with children
        int parent = node;
	int rightNode = 2 * node + 1;
	int leftNode = 2 * node + 2;
	
        //   int parent = node;
        if (rightNode < length && arr[rightNode].height > arr[parent].height) {
                parent = rightNode;
        }
        if (leftNode < length && arr[leftNode].height > arr[parent].height) {
                parent = leftNode;
        }
        if (parent != node) {
            SortingUtilities.swap(arr,node,parent);
            makeHeap(arr,length,parent);
        }
    }
    
    
    
    public void insertionSort(Rectangle[] arr) {
        for (int i = 0; i<arr.length; i++) {
            int j = i;
            while ( j-1 >= 0  && arr[j-1].height > arr[j].height ) {
                SortingUtilities.swap(arr, j, j-1);
                j--;
            }
        }
    }
    
    public void selectionSort(Rectangle[] arr) {
        for (int i = 0; i<arr.length; i++) {
            int min_index = i;
            for (int j =i; j < arr.length; j++) {
                if (arr[min_index].height > arr[j].height)
                    min_index = j;
            }
            SortingUtilities.swap(arr, i, min_index);
        }
    }
    
}
