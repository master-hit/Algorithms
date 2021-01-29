package sortingAlgorithms;

/**
 * Implementation of MergeSort with while-loop merge 
 * @author Moises
 */
public class MergeSort {
    public static void sort(int[] arr,int l, int r) {
        //divide into to array
        int m = (arr.length-1)/2;
        int[] subLeft = new int[m-l+1];
        int[] subRight = new int[r-m];
        //copy values
        int k = 0;
        for (int i = 0; i < subLeft.length; i++) {
            subLeft[i] = arr[k];
            k++;
        }
        for (int i = 0; i < subRight.length; i++) {
            subRight[i] = arr[k];
            k++;
        }
        //sort the sub arrays
        if (arr.length>2) {
            sort(subLeft,0,subLeft.length-1);
            sort(subRight,0,subRight.length-1);
        }
        //merge
        int i=0,j=0;k=0;
        while(i<subLeft.length && j<subRight.length) {
            if (subLeft[i] < subRight[j]) {
                arr[k] = subLeft[i];
                i++;
                k++;
            }
            else {
                arr[k] = subRight[j];
                j++;
                k++;
            }
        }
        //remaining values
        while (k<arr.length) {
            if (i<subLeft.length) {
                arr[k]=subLeft[i];
                k++;
                i++;
            }
            if (j<subRight.length) {
                arr[k] = subRight[j];
                k++;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {54,26,93,17,77,31,44,55,20};
        Tool.toPrintArr(arr);
        sort(arr,0,arr.length-1);
        Tool.toPrintArr(arr);
    }
}

