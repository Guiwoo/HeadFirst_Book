// bigO notation o(n^2) why ? double for loop 

public class SelectionSortTest {
    public static void main(String[] args) {

    }
}

class SelectionSort {
    public void swapElement(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public int indexLowest(int[] arr, int start) {
        int lowIndex = start;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[lowIndex])
                lowIndex = i;
        }
        return lowIndex;
    }

    public void selectionSrot(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = indexLowest(arr, i);
            swapElement(arr, i, j);
        }
    }
}