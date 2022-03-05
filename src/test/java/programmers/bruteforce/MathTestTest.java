package programmers.bruteforce;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathTestTest {

    private final MathTest mathTest = new MathTest();

    @Test
    void testSolution() {
        assertArrayEquals(new int[]{1}, mathTest.solution(new int[] {1,2,3,4,5}));
        assertArrayEquals(new int[]{1,2,3}, mathTest.solution(new int[] {1,3,2,4,2}));
    }

    @CsvSource(value = {
            "1|1", "2|2", "3|3", "4|4", "5|5"
    }, delimiter = '|')
    @ParameterizedTest
    void testStudentAGuess(int questionNumber, int answer) {
        MathTest.StudentA studentA = new MathTest.StudentA();
        studentA.guess(questionNumber, answer);
        assertEquals(1, studentA.getScore());
    }

    @CsvSource(value = {
            "1|2", "1|3", "1|4", "1|5",
            "2|1", "2|3", "2|4", "2|5",
            "3|1", "3|2", "3|4", "3|5",
            "4|1", "4|2", "4|3", "4|5",
    }, delimiter = '|')
    @ParameterizedTest
    void testStudentAGuessIncorrect(int questionNumber, int answer) {
        MathTest.StudentA studentA = new MathTest.StudentA();
        studentA.guess(questionNumber, answer);
        assertEquals(0, studentA.getScore());
    }

    @CsvSource(value = {
            "1|2", "2|1", "3|2", "4|3", "5|2", "6|4", "7|2", "8|5", "9|2"
    }, delimiter = '|')
    @ParameterizedTest
    void testStudentBGuess(int questionNumber, int answer) {
        MathTest.StudentB student = new MathTest.StudentB();
        student.guess(questionNumber, answer);
        assertEquals(1, student.getScore());
    }


}