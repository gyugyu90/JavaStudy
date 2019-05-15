package codility.tranining;

import java.util.Arrays;

public class SmallestInteger {

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

    public static void main(String[] args) {

        SmallestInteger smallestInteger = new SmallestInteger();

        int[] array1 = {1, 3, 6, 4, 1, 2};
        int ans1 = smallestInteger.solution(array1);
        System.out.println(ans1); // expected: 5

        int[] array2 = {1,2,3};
        int ans2 = smallestInteger.solution(array2);
        System.out.println(ans2); // expected: 4

        int[] array3 = {-1, -3};
        int ans3 = smallestInteger.solution(array3);
        System.out.println(ans3); // expected: 1

        int[] array4 = {1, 1, 1};
        int ans4 = smallestInteger.solution(array4);
        System.out.println(ans4); // expected: 2

        int[] array5 = {3, 2, 1};
        int ans5 = smallestInteger.solution(array5);
        System.out.println(ans5); // expected: 4
    }
}
