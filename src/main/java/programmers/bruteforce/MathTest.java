package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// ref https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
public class MathTest {

    public int[] solution(int[] answers) {
        StudentA studentA = new StudentA();
        StudentB studentB = new StudentB();
        StudentC studentC = new StudentC();

        for (int i = 0; i < answers.length; i++) {
            studentA.guess(i + 1, answers[i]);
            studentB.guess(i + 1, answers[i]);
            studentC.guess(i + 1, answers[i]);
        }

        int highestScore = getHighestScore(studentA, studentB, studentC);
        List<Integer> list = new ArrayList<>();
        if (highestScore == studentA.getScore()) {
            list.add(1);
        }
        if (highestScore == studentB.getScore()) {
            list.add(2);
        }
        if (highestScore == studentC.getScore()) {
            list.add(3);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getHighestScore(StudentA studentA, StudentB studentB, StudentC studentC) {
        return Stream.of(studentA.getScore(), studentB.getScore(), studentC.getScore())
                     .mapToInt(x -> x)
                     .max()
                     .getAsInt();
    }

    static class StudentA {
        private int score;

        public void guess(int questionNumber, int answer) {
            if (questionNumber % 5 == answer % 5) {
                score++;
            }
        }

        public int getScore() {
            return score;
        }
    }

    static class StudentB {
        private int score;

        public void guess(int questionNumber, int answer) {
            if (questionNumber % 2 == 1 && answer == 2) {
                score++;
            } else if (questionNumber % 8 == 2 && answer == 1) {
                score++;
            } else if (questionNumber % 8 == 4 && answer == 3) {
                score++;
            } else if (questionNumber % 8 == 6 && answer == 4) {
                score++;
            } else if (questionNumber % 8 == 0 && answer == 5) {
                score++;
            }
        }

        public int getScore() {
            return score;
        }
    }

    static class StudentC {
        private int score;

        public void guess(int questionNumber, int answer) {
            if ((questionNumber % 10 == 1 || questionNumber % 10 == 2) && answer == 3) {
                score++;
            } else if ((questionNumber % 10 == 3 || questionNumber % 10 == 4) && answer == 1) {
                score++;
            } else if ((questionNumber % 10 == 5 || questionNumber % 10 == 6) && answer == 2) {
                score++;
            } else if ((questionNumber % 10 == 7 || questionNumber % 10 == 8) && answer == 4) {
                score++;
            } else if ((questionNumber % 10 == 9 || questionNumber % 10 == 0) && answer == 5) {
                score++;
            }
        }

        public int getScore() {
            return score;
        }
    }

}
