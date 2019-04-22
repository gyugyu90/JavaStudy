import java.util.*;

// https://app.codility.com/programmers/custom_challenge/zirconium2019/
public class CodilityFDevelopers {

    public int solution(int[] A, int[] B, int F) {
        // write your code in Java SE 8
        // F 명의 front end 개발자를 뽑을 때 효율성 / 생산성 총량이 maximum인 알고리즘

        List<Developer> list = convertToList(A, B);
        list.sort((o1, o2) -> {
            if(o1.getGap() > o2.getGap()) {
                return -1;
            } else {
                return 0;
            }
        });

        readjustMembers(list, F);

        int sum = 0;
        for(Developer dev : list) {
            if(dev.getPosition() == 'F') {
                sum += dev.getFrontendSkill();
            } else {
                sum += dev.getBackendSkill();
            }
            System.out.println(dev.toString());
        }

        System.out.println(sum);
        return sum;
    }

    private List<Developer> convertToList(int[] A, int[] B){
        try{
            List<Developer> list = new ArrayList<>();
            int length = A.length;
            for(int i=0;i<length;i++) {
                char position = (A[i] > B[i]) ? 'F' : 'B';
                list.add(new Developer(position, A[i], B[i], Math.abs(A[i] - B[i])));
            }
            return list;
        }catch (IndexOutOfBoundsException e) {
            return Collections.emptyList();
        }
    }

    private void readjustMembers(List<Developer> list, int count){
        int frontEndDevelopersCnt = (int)list.stream().filter(developer -> developer.getPosition() == 'F').count();

        if(frontEndDevelopersCnt != count){

            int needToBeChangePosition = frontEndDevelopersCnt - count;

            int size = list.size();
            if(needToBeChangePosition > 0) {
                // frontend가 더 많을 때
                for(int i = size - 1; i >= 0; i--) {
                    if(needToBeChangePosition == 0)
                        break;

                    if(list.get(i).getPosition() == 'F') {
                        list.get(i).setPosition('B');
                        needToBeChangePosition--;
                    }
                }
            } else {
                // backend가 더 많을 때
                for(int i = size - 1; i >= 0; i--) {
                    if(needToBeChangePosition == 0)
                        break;

                    if(list.get(i).getPosition() == 'B') {
                        list.get(i).setPosition('F');
                        needToBeChangePosition++;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        CodilityFDevelopers c = new CodilityFDevelopers();
        // {1,5,3,4,2}, {5,2,3,1,3}, 3
        // {7, 1, 4, 4}, {5, 3, 4, 3}, 2)
        int[] A = new int[]{7, 7, 7, 7};
        int[] B = new int[]{3, 3, 3, 3};
        c.solution(A, B, 1);
    }

    class Developer {
        private char position;
        private int frontendSkill;
        private int backendSkill;
        private int gap;

        public Developer(char position, int frontendSkill, int backendSkill, int gap) {
            this.position = position;
            this.frontendSkill = frontendSkill;
            this.backendSkill = backendSkill;
            this.gap = gap;
        }

        public char getPosition() {
            return position;
        }

        public void setPosition(char position) {
            this.position = position;
        }

        public int getFrontendSkill() {
            return frontendSkill;
        }

        public int getBackendSkill() {
            return backendSkill;
        }

        public int getGap() {
            return gap;
        }

        @Override
        public String toString() {
            return gap + " " + position + " " + frontendSkill + " " + backendSkill;
        }
    }


}
