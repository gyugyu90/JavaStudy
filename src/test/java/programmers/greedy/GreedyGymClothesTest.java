package programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreedyGymClothesTest {

    private final GreedyGymClothes greedyGymClothes = new GreedyGymClothes();

    @Test
    void testSolution() {
//        assertEquals(5, greedyGymClothes.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//        assertEquals(4, greedyGymClothes.solution(5, new int[]{2, 4}, new int[]{3}));
//        assertEquals(2, greedyGymClothes.solution(3, new int[]{3}, new int[]{1}));
//        assertEquals(0, greedyGymClothes.solution(5, new int[]{1, 2, 3, 4, 5}, new int[]{}));
//        assertEquals(5, greedyGymClothes.solution(5, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
        assertEquals(4, greedyGymClothes.solution(5, new int[]{1, 2}, new int[]{3, 4, 5}));
    }
}