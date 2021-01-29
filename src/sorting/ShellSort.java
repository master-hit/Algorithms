package sortingAlgorithms;

/**
 *
 * @author Moises
 */
// Java implementation of ShellSort 
class ShellSort {
    
    
    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int current = i;
                int temp = arr[i];
                while ((current - gap) >= 0 && (arr[current-gap] > temp)) {
                    arr[current] = arr[current-gap];
                    current = current - gap;
                }
                if (current != i) 
                    arr[current] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {8,7,1,10,12,2,5};
        Tool.toPrintArr(arr);
        sort(arr);
        Tool.toPrintArr(arr);
    }
} 

