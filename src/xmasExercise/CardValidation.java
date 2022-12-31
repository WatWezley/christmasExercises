package xmasExercise;

import java.util.Scanner;

public class CardValidation {

    private String cardNumber;

    Scanner cardNumberCollector = new Scanner(System.in);
    int sumOfModifiedCardNumber = 0;

    int sumOfCardNumberReverseOddIndex = 0;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    public void checkingTypeOfCard(String cardNumber) {
        String singleNumber = String.valueOf(cardNumber.charAt(0));
        int input = Integer.parseInt(singleNumber);
        System.out.println(input);
        switch (input) {
            case 4:
                System.out.println("Credit Card Type: Visa Card ");
                System.out.println("Credit Card Number: " + cardNumber);
                System.out.println("Credit Card Digit Lenght: " + cardNumber.length());
                break;
            case 5:
                System.out.println("Credit Card Type: MasterCard ");
                System.out.println("Credit Card Number: " + cardNumber);
                System.out.println("Credit Card Digit Lenght: " + cardNumber.length());
                break;
            case 6:
                System.out.println("Credit Card Type: Discovery Card ");
                System.out.println("Credit Card Number: " + cardNumber);
                System.out.println("Credit Card Digit Lenght: " + cardNumber.length());
                break;
            case 3:
                int input2 = cardNumber.charAt(1);
                switch (input2) {
                    case 7:
                        String cardType = "American Express Cards";
                        System.out.println("Credit Card Type: American Express Cards ");
                        System.out.println("Credit Card Number: " + cardNumber);
                        System.out.println("Credit Card Digit Lenght: " + cardNumber.length());
                        break;
                    default:
                        System.out.println("Credit Card Type: Invalid Card");
                        System.out.println("Credit Card Number: " + cardNumber);
                        System.out.println("Credit Card Digit Lenght: " + cardNumber.length());
                        break;
                }
                break;
            default:
                System.out.println("Credit Card Type: Invalid Card");
                System.out.println("Credit Card Number: " + cardNumber);
                System.out.println("Credit Card Digit Lenght: " + cardNumber.length());
                break;
        }
    }


    public int addingCardNumbers(String cardNumber) {
        for (int counter = 0; counter < cardNumber.length(); counter+=2) {
            String singleNumber = String.valueOf(cardNumber.charAt(counter));
            int modifiedNumber = (Integer.parseInt(singleNumber)) * 2;
            int mod = modifiedNumber % 10;
            int divisor = modifiedNumber / 10;
            int finalModifiedNumber = mod + divisor;
            sumOfModifiedCardNumber = sumOfModifiedCardNumber + finalModifiedNumber;
        }
        System.out.println(sumOfModifiedCardNumber);
        return sumOfModifiedCardNumber;

    }

    public  int addingReverseOddIndex(String cardNumber) {
        for (int i = cardNumber.length()-1; i >= 0; i -= 2) {
            String singleNumbersOddIndex = String.valueOf(cardNumber.charAt(i));
            int numberOddIndex = Integer.parseInt(singleNumbersOddIndex);
            sumOfCardNumberReverseOddIndex = sumOfCardNumberReverseOddIndex + numberOddIndex;}
        System.out.println(sumOfCardNumberReverseOddIndex);
        return sumOfCardNumberReverseOddIndex;
    }

    public void validation(){
        int sumValidation = sumOfCardNumberReverseOddIndex + sumOfModifiedCardNumber;
        System.out.println(sumValidation);
        if(sumValidation % 10 == 0){
            System.out.println("Credit Card Validity Status: VALID");}
            else{
            System.out.println("Credit Card Validity Status:INVALID");
        }
    }
}
