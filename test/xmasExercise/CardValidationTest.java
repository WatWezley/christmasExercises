package xmasExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardValidationTest {

    private CardValidation cardValidator;


    @BeforeEach
    public void setUp() {
        cardValidator = new CardValidation();
    }

    @Test
    public void testThatCardValidatorExists() {
        assertNotNull(cardValidator);
    }

    @Test
    public void testThatCardNumberIsCorrect() {
        String cardNumber = "4239816349234";
        String number;
        if ((cardNumber.length() == 16) || ((cardNumber.length() == 13))) {
            number = "complete";
        } else {
            number = "incomplete";
        }
        assertEquals("complete", number);
    }

    @Test
    public void testThatCardNumberIsIncorrect() {
        String cardNumber = "42398163492346";
        String number;
            if ((cardNumber.length() == 16) || (cardNumber.length() == 13)) {
                number = "complete";
            } else {
                number = "incomplete";
            }
            assertEquals("incomplete", number);
        }



    @Test
    public void testThatDetermineMasterCardType() {
        String cardNumber = "5764892309863672";
        String cardType;
        System.out.println(cardNumber.charAt(0));
        System.out.println(cardNumber.charAt(1));
        String singleNumber = String.valueOf(cardNumber.charAt(0));
        int input = Integer.parseInt(singleNumber);
        if(input == 5){
            cardType = "Master Card";}
            else{
                cardType = "Invalid Card";}
           assertEquals("Master Card", cardType);
        }

    @Test
    public void testThatDetermineVisaCardType() {
        String cardNumber = "4764892309863672";
        String cardType;
        String singleNumber = String.valueOf(cardNumber.charAt(0));
        int input = Integer.parseInt(singleNumber);
        if(input == 4){
            cardType = "Visa Card";}
        else{
            cardType = "Invalid Card";}
        assertEquals("Visa Card", cardType);
    }

    @Test
    public void testThatDetermineDiscoveryCardType() {
        String cardNumber = "6764892309863672";
        String cardType;
        String singleNumber = String.valueOf(cardNumber.charAt(0));
        int input = Integer.parseInt(singleNumber);
        if(input == 6){
            cardType = "Discovery Card";}
        else{
            cardType = "Invalid Card";}
        assertEquals("Discovery Card", cardType);
    }

    @Test
    public void testAddingTheCard(){
        int sum = cardValidator.addingCardNumbers("1234567898765");
        assertEquals(29,sum);
    }

    @Test
    public  void testAddingReverseNumber(){
        int sumReverse = cardValidator.addingReverseOddIndex("1234567898765");
        assertEquals(37,sumReverse);
    }

    @Test
    public void testInvalidCard(){
        int sumEvenPosition = cardValidator.addingCardNumbers("5234567898765");
        int sumOddPosition = cardValidator.addingReverseOddIndex("5234567898765");
        int sum =sumOddPosition+sumEvenPosition;
        String validity;
        if(sum%10==0){
            validity = "VALID";}
        else{validity = "INVALID";}
        assertEquals("INVALID",validity);
        }

    @Test
    public void testValidCard(){
        int sumEvenPosition = cardValidator.addingCardNumbers("5399839232225143");
        int sumOddPosition = cardValidator.addingReverseOddIndex("5399839232225143");
        int sum =sumOddPosition+sumEvenPosition;
        String validity;
        if(sum%10==0){
            validity = "VALID";}
        else{validity = "INVALID";}
        assertEquals("VALID",validity);
    }
    }










