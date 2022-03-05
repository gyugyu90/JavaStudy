package sort;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSort {

    // 1 + 2 + 3 + 4 + 5 + ... + (n - 1) => n * (n - 1) / 2 => O(n^2)
    private void bubbleSort(int[] array) {
        int temp;
        for(int i = array.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void testBubbleSort() {

        int[] arr = new int[]{ 3, 1,4,5,2,6,7};
        bubbleSort(arr);

        for(int a : arr) {
            System.out.print(a + "\t");
        }
        assertEquals(1, arr[0]);

    }



}
