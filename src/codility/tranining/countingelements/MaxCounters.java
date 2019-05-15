package codility.tranining.countingelements;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
// ref: @url https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
public class MaxCounters {

    // lesson: new int[N] / int[N].clone() => O(n)
    // ref: @url https://stackoverflow.com/questions/5640850/java-whats-the-big-o-time-of-declaring-an-array-of-size-n

    private int[] array;
    private int[] zeroArray;

    // 77%
    public int[] solution(int N, int[] A) {
        array = new int[N];
        zeroArray = new int[N];
        Arrays.fill(array, 0);
        Arrays.fill(zeroArray, 0);

        int max = 0;
        int maxDelta = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] < N + 1) {
                int key = A[i] - 1;
                array[key] += 1;
                if(maxDelta < array[key]) maxDelta = array[key];
            } else {
                max = max + maxDelta;
                array = get0Array(); // O(n)
                maxDelta = 0;
            }
        }
        final int maxFinal = max;

        return Arrays.stream(array).map(x -> x + maxFinal).toArray();
    }

    // 88%
    private int[] solution2(int N, int[] A) {
        int[] arr = new int[N];

        int max = 0;
        int maxDelta = 0;

        for (int value : A) {
            if (value < N + 1) {
                // maxcount가 아닐 때
                int key = value - 1;
                arr[key] += 1;
                if (maxDelta < arr[key]) maxDelta = arr[key];
            } else if (value == N + 1) {
                // maxcount일 때
                max = max + maxDelta;
                arr = new int[N]; // O(n)
                maxDelta = 0;
            }
        }

        if(max > 0) {
            for(int i=0; i<N; i++) {
                arr[i] += max;
            }
        }

        return arr;
    }

    // 100%
    private int[] solution3(int N, int[] A) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        int max = 0;
        int maxDelta = 0;

        for(int value: A) {
            if(value < N + 1) {
                if(!map.containsKey(value)) {
                    map.put(value, 1);
                } else {
                    map.replace(value, map.get(value) + 1);
                }

                int newVal = map.get(value);
                if (maxDelta < newVal) maxDelta = newVal;
            } else if (value == N + 1) {
                max = max + maxDelta;
                map.clear();
                maxDelta = 0;
            }
        }

        int[] ans = new int[N];
        for(int i = 0; i<N; i++) {
            ans[i] = max + map.getOrDefault(i + 1, 0);
        }
        return ans;
    }

    private int[] get0Array() {
        return zeroArray.clone(); // O(n)
    }

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();


        int[] ans1 = maxCounters.solution3(5, new int[] {3, 4, 4, 6, 1, 4, 4});
        maxCounters.printAns(ans1); // expected: 3 2 2 4 2

        int[] ans2 = maxCounters.solution3(6, new int[] {7, 7, 7, 7, 7});
        maxCounters.printAns(ans2); // expected: 0 0 0 0 0 0

        int[] ans3 = maxCounters.solution3(10, new int[] {1, 11, 1, 11, 1, 11, 1, 11});
        maxCounters.printAns(ans3); // expected: 4 4 4 4 4 4 4 4 4 4

    }

    private void printAns(int[] arr) {
        for(int value: arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
