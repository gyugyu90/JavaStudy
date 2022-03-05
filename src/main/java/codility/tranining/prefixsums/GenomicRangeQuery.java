package codility.tranining.prefixsums;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GenomicRangeQuery {


    public int[] solution(String S, int[] P, int[] Q) {
        int length = P.length;
        int[] ans = new int[length];

        int[] tempArr = new int[S.length()];
        for(int i = 0; i<S.length(); i++){
            switch (S.charAt(i)) {
                case 'A': tempArr[i] = 1; break;
                case 'C': tempArr[i] = 2; break;
                case 'G': tempArr[i] = 3; break;
                case 'T': tempArr[i] = 4; break;
            }
        }

        for(int i=0; i<length; i++) {
            int answer = 5;
            for(int j=P[i]; j <= Q[i]; j++) {
                if(answer > tempArr[j]) answer = tempArr[j];
            }
            ans[i] = answer;
        }
        return ans;
    }


    public int[] solution2(String S, int[] P, int[] Q) {
        int length = P.length;
        int[] ans = new int[length];
        for(int i = 0; i<length; i++) {
            String s = S.substring(P[i], Q[i] + 1);
            if(s.indexOf('A') >= 0) ans[i] = 1;
            else if(s.indexOf('C') >= 0) ans[i] = 2;
            else if(s.indexOf('G') >= 0) ans[i] = 3;
            else if(s.indexOf('T') >= 0) ans[i] = 4;
        }
        return ans;
    }

    public int[] solution3(String S, int[] P, int[] Q) {
        int length = P.length;
        int[] ans = new int[length];

        int[] tempArr = new int[S.length()];
        for(int i = 0; i<S.length(); i++){
            switch (S.charAt(i)) {
                case 'A': tempArr[i] = 1; break;
                case 'C': tempArr[i] = 2; break;
                case 'G': tempArr[i] = 3; break;
                case 'T': tempArr[i] = 4; break;
            }
        }

        return ans;
    }


    @Test
    public void testSolution() {

        assertArrayEquals(new int[]{2,4,1}, solution2("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        assertArrayEquals(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                solution("GGGGGGGGGG", new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{9,9,9,9,9,9,9,9,9,9}));
    }



}
