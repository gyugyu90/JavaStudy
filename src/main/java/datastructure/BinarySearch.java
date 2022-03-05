package datastructure;

// 이진 검색
public class BinarySearch {

    private static final int FAIL = -1;

    // 순환에 의한 구현
    private int binarySearchRecursive(int[] value, int start, int end, int key) {
        int ret = FAIL;
        int middle;

        if(start <= end) {
            middle = (start + end ) / 2;
            if(key == value[middle]) {
                ret = middle; // 찾았을 때
            } else if (key < value[middle]) { // 찾으려는 key가 더 작을 때는
                ret = binarySearchRecursive(value, start, middle - 1, key);
            } else { // 찾으려는 key가 더 클 때
                ret = binarySearchRecursive(value, middle + 1, end, key);
            }
        }

        return ret;
    }

    // 반복에 의해 구현
    private int binarySearch(int[] value, int start, int end, int key) {
        int ret = FAIL;
        int tempStart, tempEnd, middle; // 0으로 초기화

        tempStart = start;
        tempEnd = end;

        while(tempStart <= tempEnd) {
            middle = (tempStart + tempEnd) / 2;
            if(key == value[middle]) {
                ret = middle;
                break;
            } else if (key < value[middle]) {
                tempEnd = middle - 1;
            } else {
                tempStart = middle + 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] ex1 = {10, 20, 50, 60, 70, 80};
        int answer = binarySearch.binarySearchRecursive(ex1, 0, ex1.length, 60);
        System.out.println("Answer: " + answer);

        int answerLoop = binarySearch.binarySearch(ex1, 0, ex1.length, 60);
        System.out.println("Answer: " + answerLoop);
    }

}
