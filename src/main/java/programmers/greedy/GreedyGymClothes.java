package programmers.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
public class GreedyGymClothes {


    class GymClothes {
        private int numberOfClothes;

        public GymClothes(int numberOfClothes) {
            this.numberOfClothes = numberOfClothes;
        }

        public boolean isAvailable() {
            return numberOfClothes >= 1;
        }

        public boolean isAbleToRent() {
            return numberOfClothes > 1;
        }

        public void rent() {
            this.numberOfClothes--;
        }

        public void saved() {
            this.numberOfClothes = 1;
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        List<GymClothes> gymClothes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int currentStudentNumber = i + 1;
            boolean studentHasExtraGymClothes = Arrays.stream(reserve).anyMatch(o -> o == currentStudentNumber);
            boolean studentLostGymClothes = Arrays.stream(lost).anyMatch(o -> o == currentStudentNumber);

            var numberOfGymClothes = 1;
            if (studentHasExtraGymClothes) numberOfGymClothes++;
            if (studentLostGymClothes) numberOfGymClothes--;

            gymClothes.add(new GymClothes(numberOfGymClothes));
        }

        var size = gymClothes.size();
        var count = 0;
        for (int i = 0; i < size; i++) {
            if (gymClothes.get(i).isAvailable()) {
                count++;
            }

            if (gymClothes.get(i).numberOfClothes == 0 && i > 0 && gymClothes.get(i - 1).isAbleToRent()) {
                gymClothes.get(i - 1).rent();
                gymClothes.get(i).saved();
                count++;
            }

            if (gymClothes.get(i).numberOfClothes == 0 && i + 1 < size && gymClothes.get(i + 1).isAbleToRent()) {
                gymClothes.get(i + 1).rent();
                gymClothes.get(i).saved();
                count++;
            }
        }

        return count;
    }

}
