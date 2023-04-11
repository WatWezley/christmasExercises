package xmasExercise.MBTI;

import xmasExercise.MBTI.MyersBriggsPersonality;

import java.util.Scanner;

public class MylersBriggsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyersBriggsPersonality personality = new MyersBriggsPersonality();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        personality.setName(name);
        personality.compilingAnswer();
        personality.displayResult();

    }

}
