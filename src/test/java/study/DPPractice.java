package study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DPPractice {

    int count;
    int[][] cache = new int[30][30];

    @Test
    void testCall() {
        assertEquals(1, binomialCoefficient(1, 1));
        assertEquals(1, binomialCoefficient(2, 2));
        assertEquals(2, binomialCoefficient(2, 1));
        assertEquals(3, binomialCoefficient(3, 2));
        assertEquals(10, binomialCoefficient(5, 3));
    }

    @Test
    void usingMemoization() {
        count = 0;
        assertEquals(5_200_300, binomialCoefficient(25, 12));
        System.out.println(count);
    }

    public int binomialCoefficient(int n, int r) {
        count++;
        if (n == r) {
            return 1;
        }

        if (r == 1) {
            return n;
        }

        if (cache[n][r] != 0) {
            return cache[n][r];
        }

        int result = binomialCoefficient(n - 1, r - 1) + binomialCoefficient(n - 1, r);
        cache[n][r] = result;
        return result;
    }

}
