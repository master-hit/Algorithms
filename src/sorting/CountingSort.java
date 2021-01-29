package sortingAlgorithms;

/**
              0 1 2 3 4 5 6
 * array  -> [4,2,2,8,3,3,1]
 

 * 
 *            0 1 2 3 4 5 6 7 8
 * count  -> [0,1,3,5,6,6,6,6,7]
 
              0 1 2 3 4 5 6
 * output -> [1,2,2,3,3,4,8]
 * 
 * @author Moises
 */

public class CountingSort {
    
    public static void sort(int[] arr) {
        int max=0;        //greatest number in the arr
        
        //find max
        if (arr.length > 0) {
            max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i])
                    max = arr[i];
            }
        }
        else 
            return;

        //create count arr to keep track of how many time numbers are repeated 
        int size = max+1;
        int count[] = new int[size];

        //fill count with zeros
        for (int element = 0; element < arr.length; element++) {
            count[element] = 0;
        }

        // increase index whenever a number repeats
        for (int element = 0, index=0; element < arr.length; element++) {
            index = arr[element];
            count[index]++;
        }

        // add every element the preview number 
        for (int curr=0,next=curr+1; next<count.length; curr++,next++) {
            count[next] = count[next] + count[curr] ;
        }

        //create output array
        int[] output = new int[arr.length];
        // order the array
        int index_c; //index for the counting arr
        int index_o; //index for the output arr
        for(int i = 0; i<arr.length; i++){
            index_c = arr[i];
            index_o = --count[index_c];
            output[index_o] = arr[i];
        }
        
        // copy the output array into arr 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print( (i<arr.length-1)? arr[i]+",":arr[i]);
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int arr[] = {10,7,8,2,1,9,8,2,2,2};
        print(arr);
        sort(arr);
        print(arr);
    }
}
