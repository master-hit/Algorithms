/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgorithms;

/**
 *
 * @author Moises
 */
public class BubbleSort {
    
    //unsd = pointer to the last value of the unsorted array
    public static void sort(int[] arr) {
        for(int unst=arr.length-1; 0<=unst; unst--) {
            for(int crnt=0,next=crnt+1; next<=unst; crnt++,next++) {
                if (arr[crnt] > arr[next])
                    swap(arr,crnt,next);
            }
        }
    }
    
    public static void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i==arr.length-1)? arr[i]+"" : arr[i]+", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};
        printArr(arr);
        sort(arr);
        printArr(arr);
    }
}
