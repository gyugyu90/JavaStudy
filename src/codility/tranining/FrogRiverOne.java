package codility.tranining;

import java.util.HashSet;
import java.util.Set;

// ref => @url https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
public class FrogRiverOne {

    public static void main(String[] args) {

        FrogRiverOne frogRiverOne = new FrogRiverOne();

        int[] array1 = {1,3,1,4,2,3,5,4};
        int ans1 = frogRiverOne.solution(5, array1); // expected 6
        System.out.println(ans1);

        int[] array2 = {1,1,1,1,1};
        int ans2 = frogRiverOne.solution(5,array2); // expected -1
        System.out.println(ans2);

        int[] array3 = {1,6,5,1,4,2,3,4};
        int ans3 = frogRiverOne.solution(6, array3); // expected 6
        System.out.println(ans3);

    }

    private int solution(int X, int[] A){

        Set<Integer> set = new HashSet<>();
        int length = A.length;
        int ans = 0;
        for(int i = 0; i < length; i++) {
            int value = A[i];
            if(set.size() == X) {
                break;
            }

            if(!set.contains(value)) {
                set.add(value);
                ans = i;
            }
        }

        if(set.size() != X) return -1;
        else return ans;
    }

}
