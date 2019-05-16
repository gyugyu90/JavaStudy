package codility.tranining.iterations;


import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryGap {

    @Test
    public void hello() {
        assertEquals(4, getHighest2multiple(5));
        assertEquals(8, getHighest2multiple(10));
        assertEquals("101", getBinaryString(5));
        assertEquals("1010", getBinaryString(10));
        assertEquals("100000", getBinaryString(32));
        assertEquals("100001", getBinaryString(33));

        assertEquals(1, solution(10));
        assertEquals(0, solution(32));
        assertEquals(4, solution(33));

    }


    public int solution(int N) {
        String binaryString = getBinaryString(N);
        String[] gaps = getBinaryString(N).split("1");
        int length = binaryString.substring(binaryString.length() - 1).equals("1") ? gaps.length : gaps.length - 1;
        int longestGap = 0;
        for(int i = 0; i < length; i++) {
            int newLength = gaps[i].length();
            if(newLength > longestGap) {
                longestGap = newLength;
            }
        }
        return longestGap;
    }




    private String getBinaryString(int number) {

        Math.pow(2, 3);
        int comparator = getHighest2multiple(number);
        String binary = "";
        while(comparator >= 1) {
            if(number >= comparator) {
                number -= comparator;
                binary += "1";
            } else {
                binary += "0";
            }
            comparator /= 2;
        }

        return binary;
    }

    private int getHighest2multiple(int number){
        int ans = 1;
        while(ans <= number) {
            ans *= 2;
        }
        return ans / 2;
    }

}
