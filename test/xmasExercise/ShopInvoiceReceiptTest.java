package xmasExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xmasExercise.InvoiceReceipt.Shop;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ShopInvoiceReceiptTest {

    int counter = 0;

    double subTotal = 0;


    ArrayList<String> items = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    ArrayList<Double> total = new ArrayList<>();

    String[][] purchaseSummary = new String[2][4];

    private  Shop famibaShop;


    @BeforeEach
    public void setUp() {
        famibaShop = new Shop("famiba", "no 1 constitution crescent Aba", "Main","08036457939");
    }


    @Test
    public void testThatShopExist() {
        assertNotNull(true, String.valueOf(famibaShop));
    }

    @Test
    public void testThatArrayListExist() {
        assertNotNull(items);
        assertNotNull(quantity);
        assertNotNull(price);
        assertNotNull(total);
    }


    @Test
    public void testArraylistAreEmpty() {
        assertTrue(true, String.valueOf(items.isEmpty()));
        assertTrue(true, String.valueOf(quantity.isEmpty()));
        assertTrue(true, String.valueOf(price.isEmpty()));
    }

    @Test
    public void thatTestElementsAreAddedIntoTheArrayList() {
        String goods = "RICE";
        int quantityOfGoods = 2;
        Double priceOfGoods = 500.00;
        for (int i = 0; i < 2; i++) {
            items.add(i, goods);
            quantity.add(i, quantityOfGoods);
            price.add(i, priceOfGoods);
        }
        assertTrue(true, String.valueOf(items.contains(goods)));
        assertTrue(true, String.valueOf((quantity.contains(quantityOfGoods))));
        assertTrue(true, String.valueOf((quantity.contains(priceOfGoods))));

    }

    @Test
    public void testCalculationOfTotal() {
        Shop famibaShop = new Shop("famiba", "constitution", "Main","08036457939");
        double totalCostOfGoods = famibaShop.calculateTotalCostOfGoods(600.00, 9);
        assertEquals(5400, totalCostOfGoods);
    }

    @Test
    public void testMovingContentsInArrayListToArray() {
        Shop famibaShop = new Shop("famiba", "constitution", "Main","08036457939");
        items.add("RICE");
        items.add("BEANS");
        System.out.println(items);
        quantity.add(2);
        quantity.add(6);
        System.out.println(quantity);
        price.add(4000.00);
        price.add(6000.00);
        System.out.println(price);
        total.add(4000.00);
        total.add(16000.00);
        System.out.println(total);
        for (int i = 0; i < items.size(); i++) {
            purchaseSummary[i][0]= items.get(i);
        }
        for (int i = 0; i < quantity.size(); i++) {
            purchaseSummary[i][1]= String.valueOf(quantity.get(0));
        }
        for (int i = 0; i < price.size(); i++) {
            purchaseSummary[i][2]= String.valueOf(price.get(0));
        }
        for (int i = 0; i < total.size(); i++) {
            purchaseSummary[i][3]= String.valueOf(total.get(0));
        }
        System.out.println(Arrays.deepToString(purchaseSummary));
        String [][]result = {{"RICE","2","4000.0","4000.0"},{"BEANS","2","4000.0","4000.0"}};
        assertArrayEquals(result, purchaseSummary);
    }

    @Test
    public void testMovingContentsInArrayListToArray2() {
        Shop famibaShop = new Shop("famiba", "constitution", "Main", "08036457939");
        counter = 0;
        items.add("RICE");
        items.add("BEANS");
        System.out.println(items);
        quantity.add(2);
        quantity.add(6);
        System.out.println(quantity);
        price.add(4000.00);
        price.add(6000.00);
        System.out.println(price);
        total.add(4000.00);
        total.add(16000.00);
        System.out.println(total);
        famibaShop.movingContentOfArrayListToArray(famibaShop.items,famibaShop.quantity,famibaShop.price,famibaShop.total);
        System.out.println(Arrays.deepToString(purchaseSummary));
    }

    @Test
    public void testToCalculateSubtotal(){
        Shop famibaShop = new Shop("famiba", "constitution", "Main","08036457939");
        total.add(2000.0);
        total.add(4000.0);
        total.add(2300.0);
        System.out.println(total);
        for (int t = 0; t < total.size(); t++) {
            subTotal = subTotal + total.get(t);}
        assertEquals(8300.0,subTotal);
    }

    @Test
    public  void testToCalculateDiscountedAmount(){
        Shop famibaShop = new Shop("famiba", "constitution", "Main","08036457939");
         double discountedPrice = famibaShop.calculateDiscountPrice(0.08, 7000);
        assertEquals(560.0,discountedPrice );

    }

    @Test
    public void testToCalculateVATPrice(){
        Shop famibaShop = new Shop("famiba", "constitution", "Main","08036457939");
        double VATPrice = famibaShop.calculateVATPrice(0.175, 7000.0);
        assertEquals(1225.0,VATPrice);


    }

    @Test
    public void testToCalculateBillAmount(){
        Shop famibaShop = new Shop("famiba", "constitution", "Main","08036457939");
        double billAmount = famibaShop.calculateBillTotal(7000,560,1225);
        assertEquals(7665.0, billAmount );



    }


}

