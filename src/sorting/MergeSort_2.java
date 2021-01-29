/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgorithms;

/**
 * implementation of merge sort with for-loop
 * @author Moises
 */
public class MergeSort_2 {
    public static void sort(int[] arr, int low, int high) {
        
        int mid = (arr.length-1)/2;
        int[] subLow = new int[mid-low+1];
        int[] subHigh = new int[high-mid];

        //copy
        int k=0;
        for(int i=0; i<subLow.length; i++) {
            subLow[i] = arr[k];
            k++;
        }
        for(int i=0; i<subHigh.length; i++){
            subHigh[i] = arr[k];
            k++;
        }
        //divide array into the mini subarrays
        if (arr.length>2) {
            sort(subLow,0,subLow.length-1);
            sort(subHigh,0,subHigh.length-1);
        }
        //merge subarrays
        int i=0, j=0;     // index for the subarrays
        for (int p = low; p <= high; p++) {
            if      (i>=subLow.length)      arr[p] = subHigh[j++];
            else if (j>=subHigh.length)     arr[p] = subLow[i++];
            else if (subLow[i]>subHigh[j])  arr[p] = subHigh[j++]; 
            else                            arr[p] = subLow[i++];
        }
    }
}
