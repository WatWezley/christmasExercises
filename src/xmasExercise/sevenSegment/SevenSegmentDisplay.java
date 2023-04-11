package xmasExercise.sevenSegment;

import java.util.Arrays;

public class SevenSegmentDisplay {

    String[][] viewOne = new String[7][5];
    String[][] viewTwo = new String[7][5];
    String[][] viewThree = new String[7][5];
    String[][] viewFour = new String[7][5];
    String[][] viewFive = new String[7][5];
    String[][] viewSix = new String[7][5];
    String[][] viewSeven = new String[7][5];
    String[][] viewEight = new String[7][5];

    public void viewOne() {
        viewOne[0][4] = "*";
        viewOne[1][4] = "*";
        viewOne[2][4] = "*";
        viewOne[3][4] = "*";
        viewOne[4][4] = "*";
        viewOne[5][4] = "*";
        viewOne[6][4] = "*";
        for (String[] one : viewOne) {
            System.out.println(Arrays.toString(one)
                    .replace("[", "     ")
                    .replace(",", "     ")
                    .replace("]", "     ")
                    .replace("null", " "));
        }
    }

    public void viewTwo() {
        for (String[] two : viewTwo) {
            Arrays.fill(two, "*");
        }
    }
}
