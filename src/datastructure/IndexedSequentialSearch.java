package datastructure;

import org.junit.Test;
import static org.junit.Assert.*;
// 색인 순차 검색
public class IndexedSequentialSearch {

    // O(m + n/m)
    private int indexedSequentialSearch(int[] arr, int n, int k)
    {

        int steps = 3;
        int arraySize = n / steps + 1;

        int[] elements = new int[arraySize];
        int[] indices = new int[arraySize];
        int i;
        int ind = 0, start=0, end=0;

        // O(n)
        for (i = 0; i < n; i += 3) { // 띄엄띄엄 인덱스를 저장함

            // Storing element
            elements[ind] = arr[i];

            // Storing the index
            indices[ind] = i;
            ind++;
        }

        // 찾으려고 하는 수가 없을 때
        if (k < elements[0]) {
            System.out.println("Not found");
            return -1;
        } else {
            for (i = 1; i < ind; i++) {
                if (k < elements[i]) {
                    start = indices[i - 1];
                    end = indices[i];
                    break;
                } else if(i == ind - 1) {
                    start = indices[i];
                    end = n - 1;
                }
            }
        }

        boolean found = false;
        for (i = start; i <= end; i++) {
            if (k == arr[i]) {
                found = true;
                break;
            }
        }
        if (found)
            System.out.println("Found at index "+ i);
        else
            System.out.println("Not found");

        return i;
    }

    @Test
    public void testIndexedSequentialSearch() {
        int[] testCase1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(9, indexedSequentialSearch(testCase1, testCase1.length, 10));
        assertEquals(0, indexedSequentialSearch(testCase1, testCase1.length, 1));
        assertEquals(4, indexedSequentialSearch(testCase1, testCase1.length, 5));
    }

}
