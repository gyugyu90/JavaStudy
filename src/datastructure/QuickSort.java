package datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSort {

    private int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];

        while(left < right) {
            while((array[left] < pivot) && (left < right))
                left++;
            while((array[right] > pivot) && (left < right))
                right--;

            if(left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return left;
    }

    private void quickSort(int[] array, int left, int right){
        if(left < right) {
            int pivotNewIndex = partition(array, left, right);

            quickSort(array, left, pivotNewIndex - 1);
            quickSort(array, pivotNewIndex + 1, right);
        }
    }


    @Test
    public void testQuickSort() {
        int[] array = {69, 10, 30, 2, 16, 8, 31, 22};
        quickSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + "\t");
        }

        assertEquals(array[0], 2);

    }

}
