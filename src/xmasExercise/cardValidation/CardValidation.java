package xmasExercise.cardValidation;

public class CardValidation {

    private String cardNumber;

    int sumOfModifiedCardNumber = 0;

    int sumOfCardNumberReverseOddIndex = 0;
  //  public CardValidation(String cardNumber){
    //    this.cardNumber = cardNumber;
   // }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean isCardLengthValid(){
        if (cardNumber.length() >= 13 && cardNumber.length() <=16) return true;
        return false;
    }


    public String getTypeOfCard() {
        String singleNumber = String.valueOf(cardNumber.charAt(0));
        int firstDigit = Integer.parseInt(singleNumber);
        switch (firstDigit) {
            case 4:
                return "Visa Card";
            case 5:
               return "Master Card";
            case 6:
                return "Discovery Card";
                case 3:
                int secondDigit = cardNumber.charAt(1);
                if (secondDigit == 7) {
                    return "American Express Card";}
                return "Invalid Card";
            default:
                return "Invalid Card";
        }
    }


    public int addingCardNumbers() {
        for (int counter = 0; counter < cardNumber.length(); counter+=2) {
            String singleNumber = String.valueOf(cardNumber.charAt(counter));
            int modifiedNumber = (Integer.parseInt(singleNumber)) * 2;
            int mod = modifiedNumber % 10;
            int divisor = modifiedNumber / 10;
            int finalModifiedNumber = mod + divisor;
            sumOfModifiedCardNumber = sumOfModifiedCardNumber + finalModifiedNumber;
        }
             return sumOfModifiedCardNumber;

    }

    public  int addingReverseOddIndex() {
        for (int i = cardNumber.length()-1; i >= 0; i -= 2) {
            String singleNumbersOddIndex = String.valueOf(cardNumber.charAt(i));
            int numberOddIndex = Integer.parseInt(singleNumbersOddIndex);
            sumOfCardNumberReverseOddIndex = sumOfCardNumberReverseOddIndex + numberOddIndex;}
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

    public String getCardValidityStatus(){
        String output = String.format("""
                Card Number:        %s
                Card Type:          %s
                Card Length:        %d
                Card is valid:      %s
                """,cardNumber, getTypeOfCard(), cardNumber.length(), isCardValid());



//        String output = "";
//        output +="Card Number: "+ cardNumber+"\n";
//        output +="Card Type: "+ getTypeOfCard()+"\n";
//        output+= "Card Length: " + cardNumber.length()+"\n";
//        output+= "Card Is Valid: " + isCardValid()+"\n";
        return output;
    }

    public boolean isCardValid() {
        if(!isCardLengthValid()) return false;
        return (addingReverseOddIndex() + addingCardNumbers()) % 10 == 0;
    }
}
