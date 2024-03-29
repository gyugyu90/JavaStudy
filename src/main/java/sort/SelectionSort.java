package sort;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 선택 정렬
public class SelectionSort {

    // 1 + 2 + 3 + ... + (n - 1) => n * (n - 1) / 2 => O(n^2)
    private void selectionSortMin(int[] array) {

        int minIndex;
        int temp;

        for(int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }


    private void selectionSortMax(int[] array) {
        int maxIndex;
        int temp;

        for(int i = array.length - 1; i > 0; i--) {
            maxIndex = i;
            for(int j = i - 1; j >= 0; j--) {
                if(array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            if(maxIndex != i) {
                temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    @Test
    public void testSelectionSort() {
        int[] arr = new int[]{1,3,2,5,6,4};
        selectionSortMin(arr);
        for(int a : arr) {
            System.out.print(a + "\t");
        }

        assertEquals(1, arr[0]);

        System.out.println();

        int[] arr2 = new int[]{4,5,2,7,1,3};
        selectionSortMax(arr2);
        for(int a : arr2) {
            System.out.print(a + "\t");
        }

        assertEquals(1, arr2[0]);
    }






}
