package sorting;

import java.awt.Rectangle;

/**
 *
 * @author Moises
 */
public class SortingUtilities {

    public static void swap(Rectangle[] arr, int x, int y) {
        int tempHeight = arr[x].height;
        int tempY = arr[x].y;
        arr[x].height = arr[y].height;
        arr[x].y = arr[y].y;
        arr[y].height = tempHeight;
        arr[y].y = tempY;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        };
    }
    
    
    public static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void print(int[] arr, String string) {
        System.out.println(string);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    
    public static void print(Rectangle[] arr) {
        for (Rectangle e : arr) {
            System.out.print(e.height + " ");
        }
        System.out.println();
    }
}
