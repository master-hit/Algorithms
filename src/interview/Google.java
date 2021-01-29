package interview;

/**
 * Find the nth smallest number
 *
 * @author Moises
 */
public class Google {

    public static void main(String[] args) {
        int[] arr = {10, 11, 5, 9, 6, 1, 9, 2, 8, 15};
        Google ob = new Google();
        ob.print(arr, "array");
        int position = ob.findNthSmallest(arr, 4);
        ob.print(arr, "partition " + position);

    }

    public void print(int[] arr, String string) {
        System.out.println(string);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public int findNthSmallest(int arr[], int nth) {
        int n = nth - 1;
        
        int first = 0;
        int last = arr.length - 1;
        int position = partition(arr, first, last);
        
        while(position != n) {
            if (position < n) {
                first = position + 1;
                position = partition(arr,first,last);
            }
            if (position > n) {
                last = position - 1;
                position = partition(arr,first, last);
                        
            }
        }
        return arr[position];
    }

    private int partition(int[] arr, int first, int last) {
        int pivot = first;
        int next = first + 1;
        while (next < arr.length && next <= last) {
            if (arr[pivot] > arr[next]) {
                swap(arr, pivot, next);
                next++;
                pivot++;
            } else if (next < arr.length && arr[pivot] < arr[next]) {
                swap(arr, next, last);
                last--;
            }
        }
        return pivot;
    }

    public void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
