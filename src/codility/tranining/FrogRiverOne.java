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
        for(int i = 0; i < A.length; i++) {
            set.add(A[i]); // add()는 contains check를 항상 하기 때문에 따로 체크 하지 않아도 됨
            if(set.size() == X) return i;
        }
        return -1;
    }

}
