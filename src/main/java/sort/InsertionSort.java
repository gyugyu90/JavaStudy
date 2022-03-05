package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InsertionSort {

    // 1 + 2 + 3 + 4 + 5 + ... + (n - 1) => n * (n - 1) / 2 => O(n^2)
    private void insertionSort(int[] array) {
        int temp;
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j - 1] > array[j]){
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    @Test
    public void testInsertionSort() {
        int[] array = new int[]{2,4,9,5,6,8,7,3,1};

        insertionSort(array);

        for(int a : array) {
            System.out.print(a + "\t");
        }

        assertEquals(1, array[0]);
    }

}
