package programmers.level2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
// ref: @url https://programmers.co.kr/learn/courses/30/lessons/42841?language=java
public class NumberBaseball {

    private Set<Integer> generateCandidates() {
        Set<Integer> set = new HashSet<>();
        for(int i = 123; i <= 987; i++) {
            int a = i / 100;
            int b = ( i - (a * 100) ) / 10;
            int c = i % 10;

            if(b == 0 || c == 0)
                continue;

            if(a != b && b != c && c != a)
                set.add(i);
        }
        return set;
    }
    
    private boolean compare(int numberA, int numberB, int strike, int ball) {
        int aFormer = numberA / 100;
        int bFormer = ( numberA - (aFormer * 100) ) / 10;
        int cFormer = numberA % 10;

        int aLatter = numberB / 100;
        int bLatter = ( numberB - (aLatter * 100) ) / 10;
        int cLatter = numberB % 10;

        int strikeCount = 0;
        int ballCount = 0;

        if(aFormer == aLatter)
            strikeCount++;
        else if(aFormer == bLatter || aFormer == cLatter)
            ballCount++;

        if(bFormer == bLatter)
            strikeCount++;
        else if(bFormer == aLatter || bFormer == cLatter)
            ballCount++;

        if(cFormer == cLatter)
            strikeCount++;
        else if(cFormer == aLatter || cFormer == bLatter)
            ballCount++;

        return strike == strikeCount && ball == ballCount;
    }
    
    @Test
    public void testOrdering() {
        int[][] testCase1 = new int[][] {
                {123, 1, 1},
                {234, 1, 2},
                {345, 3, 0},
                {456, 2, 0},
                {567, 2, 1},
                {789, 1, 0},
                {891, 0, 0}
        };

        orderHintsByGoodness(testCase1);
        assertEquals(testCase1[0][1], 3);
        assertEquals(testCase1[0][2], 0);
    }

    @Test
    public void testCandidate() {
        Set<Integer> candidates = generateCandidates();
        for(int candidate:candidates) {
            System.out.print(candidate + " ");
        }
        assertEquals(candidates.size(), 9 * 8 * 7);
    }

    private void orderHintsByGoodness(int[][] rawData) {
        Arrays.sort(rawData, (o1, o2) -> {
            if(o1[1] > o2[1]) {
                return -1;
            } else if(o1[1] == o2[1] && o1[2] > o2[2]) {
                return -1;
            }
            return 1;
        });
    }

    public int solution(int[][] baseball) {

        Set<Integer> candidates = generateCandidates();

        orderHintsByGoodness(baseball);
        if(baseball[0][1] == 3) {
            return 1;
        }

        for(int[] game : baseball) {
            candidates = fileterCandidate(candidates, game[0], game[1], game[2]);
        }
        
        return candidates.size();
    }

    private Set<Integer> fileterCandidate(Set<Integer> candidates, int number, int strike, int ball) {
        Set<Integer> filtered = new HashSet<>();
        for (int c : candidates) {
            boolean stillCandidate = compare(c, number, strike, ball);
            if (stillCandidate) {
                filtered.add(c);
            }
        }
        return filtered;
    }


    @Test
    public void testSolution() {
        int ans = solution(new int[][] {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}});
        assertEquals(ans, 2);
    }

}
