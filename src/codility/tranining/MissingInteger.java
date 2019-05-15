package codility.tranining;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    private int solution(int[] A) {
        Arrays.sort(A); // O(n log n)
        int ans = 1;
        for (int value : A) { // O(n)
            if (ans == value + 1 || ans == value) {
                ans = value + 1;
            } else if (ans < value + 2) {
                return ans;
            }
        }
        return ans;
    }

    private int solution2(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int value: A) {
            if(value > 0) set.add(value);
        } // O(n)

        for(int i=1;i<=100000;i++) { // O(n)
            if(i == 100000 && set.contains(100000)) return 100001;
            if(!set.contains(i)) return i;
        }

        return 1;
    }


    public static void main(String[] args) {

        MissingInteger missingInteger = new MissingInteger();

        int[] array1 = {1, 3, 6, 4, 1, 2};
        int ans1 = missingInteger.solution2(array1);
        System.out.println(ans1); // expected: 5

        int[] array2 = {1,2,3};
        int ans2 = missingInteger.solution2(array2);
        System.out.println(ans2); // expected: 4

        int[] array3 = {-1, -3};
        int ans3 = missingInteger.solution2(array3);
        System.out.println(ans3); // expected: 1

        int[] array4 = {1, 1, 1};
        int ans4 = missingInteger.solution2(array4);
        System.out.println(ans4); // expected: 2

        int[] array5 = {3, 2, 1};
        int ans5 = missingInteger.solution2(array5);
        System.out.println(ans5); // expected: 4
    }
}
