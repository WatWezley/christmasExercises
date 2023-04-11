package xmasExercise.cardValidation;

import xmasExercise.cardValidation.CardValidation;

import java.util.Scanner;

public class CardValidationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardValidation cardValidator = new CardValidation();
        System.out.println("Enter your useless card number");
        String cardNumber = scanner.nextLine();
        cardValidator.setCardNumber(cardNumber);
        System.out.println(cardValidator.getCardValidityStatus());    }
}
