package xmasExercise;

import java.util.Scanner;

public class CardValidationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardValidation cardValidator = new CardValidation();
        String cardNumber;
        do {
            System.out.println("Kindly Enter Card Details For Verification:");
            cardNumber = scanner.nextLine();
            break;
        }
        while (cardNumber.length() != 16 || cardNumber.length() != 13);
        cardValidator.setCardNumber(cardNumber);
        cardValidator.checkingTypeOfCard(cardNumber);
        cardValidator.addingCardNumbers(cardNumber);
        cardValidator.addingReverseOddIndex(cardNumber);
        cardValidator.validation();

    }
}
