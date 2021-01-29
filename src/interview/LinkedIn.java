package interview;

//  Write a program that reverts the words
/*
['p','e','r','f','e','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e']

['p','r','a','c','t','i','c','e',' ','m','a','k','e','s',' ','p','e','r','f','e','c','t']
 */
/**
 * @author Moises
 */
public class LinkedIn {

    public static void main(String[] args) {
        LinkedIn ob = new LinkedIn();
        char[] arr = "Mi casa es azul".toCharArray();

        ob.print(arr, "ARRAY:");
        ob.revertSentence(arr);
        ob.print(arr, "ARRAY:");
    }

    public void print(char[] arr, String string) {
        System.out.println(string);
        for (char e : arr) {
            System.out.print(e);
        }
        System.out.println();
    }

    public void revertSentence(char[] arr) {
        int head = 0;
        int tail = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                tail = i - 1;
                revertString(arr, head, tail);
                head = i + 1;
            }
            if (i == arr.length - 1) {
                tail = arr.length - 1;
                revertString(arr, head, tail);
                head = 0;
                revertString(arr, head, tail);
            }
        }
    }

    //revert the characters, head and tail are included
    private void revertString(char[] arr, int head, int tail) {
        int length = (tail - head + 1) / 2;
        for (int i = 0; i < length; i++, tail--) {
            swap(arr, head + i, tail);
        }
    }

    private void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
