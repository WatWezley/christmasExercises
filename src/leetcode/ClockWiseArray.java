package leetcode;

import java.util.Arrays;

public class ClockWiseArray {

    public static int[][] rotateArrayClockwise(int[][] numbers){
        int counter = numbers.length -1;
        int counta = 0;
        int [][]numbers2 = new int[counter+1][counter+1];
        for(int x=counter;x>=0;x-- ){
           int y= numbers[x].length;
            for(int r= 0; r<y;r++){
                numbers2[r][counta] = numbers[x][r];
            }
            counta++;

        }return numbers2;

    }

    public static void main(String[] args) {
        int [][] arr = new int [][]{{1,2,3,5}, {4,5,6,3}, {7,8,9,4}, {6,3,2,1}};
        for (var each : rotateArrayClockwise(arr)) {
            System.out.println(Arrays.toString(each));
        }
    }
}
