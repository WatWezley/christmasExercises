package xmasExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xmasExercise.cardValidation.CardValidation;

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
    public void testThatTypeOfCardCanBeDetermined(){
        cardValidator.setCardNumber("5990493845728937");
        String result = cardValidator.getTypeOfCard();
        assertEquals("Master Card", result);
    }



    @Test
    public void testThatCardLengthIsValid(){
        cardValidator.setCardNumber("5990493845728937");
        boolean result = cardValidator.isCardLengthValid();
        assertEquals(true, result);
    }

    @Test
    public void testThatCardLengthIsNotValid(){
        cardValidator.setCardNumber("59904728937");
        boolean result = cardValidator.isCardLengthValid();
        assertEquals(false, result);
    }


         @Test
         public void testAddingTheCard(){
        cardValidator.setCardNumber("1234567898765");
        int sum = cardValidator.addingCardNumbers();
        assertEquals(29,sum);
        }

        @Test
        public  void testAddingReverseNumber(){
        cardValidator.setCardNumber("1234567898765") ;
        int sumReverse = cardValidator.addingReverseOddIndex();
        assertEquals(37,sumReverse);
    }


    @Test
    public void testValidCard(){
        cardValidator.setCardNumber("5399831619690403");
        boolean isCardNumberValid = cardValidator.isCardValid();
        assertEquals(true, isCardNumberValid);

    }
    }










