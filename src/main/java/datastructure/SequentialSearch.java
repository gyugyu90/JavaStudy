package datastructure;

// 순차 검색
public class SequentialSearch {

    private static final int FAIL = -1;


    // 정렬되지 않은 배열을 대상으로 순차 검색
    private int sequentialSearchNotSorted(int[] value, int size, int key) {
        int ret = FAIL;

        int i = 0;
        for(i = 0; i < size && value[i] != key; i++) { // 값 비교
            // do nothing
        }

        if(i < size) {
            ret = i;
        }

        return ret;
    }

    // 정렬된 배열을 대상으로 순차 검색
    private int sequentialSearchAscendingSorted(int[] value, int size, int key) {

        int ret = FAIL;

        int i = 0;
        for(i = 0; i < size && value[i] < key; i++) {
            // do nothing
        }

        if(i < size && value[i] == key) {
            ret = i;
        }

        return ret;
    }

}
