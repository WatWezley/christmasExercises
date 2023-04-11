package xmasExercise.InvoiceReceipt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Shop {
    public static final double VAT = 0.175;
    private final String shopName;
    private final String shopAddress;
    private final String shopBranch;

    private final String shopPhoneNumber;

    private String cashierName;

    private String customerName;

    private double totalCost;

    private double subTotal;

    private  double discountedAmount;

    private  double VATPrice;

    private double billAmount;

    private static double payment;

    Date famiba = new Date();

    int counter = 0;


    public ArrayList<String> items = new ArrayList<String>();
    public ArrayList<Integer> quantity = new ArrayList<>();
    public ArrayList<Double> price = new ArrayList<>();
    public ArrayList<Double> total = new ArrayList<>();

    Scanner purchaseCollector = new Scanner(System.in);

    String[][] purchaseSummary;

    String[] summaryHeading;

    public Shop(String shopName, String shopAddress, String shopBranch, String shopPhoneNumber) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopBranch = shopBranch;
        this.shopPhoneNumber=shopPhoneNumber;
    }

    public void setCashierName(String cashierName){
        this.cashierName = cashierName;}

    public void setCustomerName(String customerName){this.customerName = customerName;}

    public double getSubTotal(){return subTotal;}

    public double getDiscount(){
        return 0.08;
    }

    public double getDiscountedAmount(){return discountedAmount;}


    public double getVATPrice(){return VATPrice;}


    public double getBillAmount(){return billAmount;}

    public void setPayment(double payment){
        Shop.payment = payment;}

    public  double getPayment(){return payment;}


    public void collectPurchaseInformation() {
        int morePurchase = 0;
        String goods;
        do {

            System.out.println("What do you want to buy: ");
            goods = purchaseCollector.next();
            items.add(counter, goods);


            System.out.print("How many of it: ");
            int numberOfGoods = purchaseCollector.nextInt();
            quantity.add(counter, numberOfGoods);

            System.out.print("price:");
            double priceOfGoods = purchaseCollector.nextDouble();
            price.add(counter, priceOfGoods);

            calculateTotalCostOfGoods(priceOfGoods, numberOfGoods);
            total.add(counter, totalCost);

            counter++;
            System.out.print("Do you want more purchase, 1 for Yes, 0 for No: ");
            morePurchase = purchaseCollector.nextInt();

        }
        while (morePurchase != 0);

        movingContentOfArrayListToArray(items,quantity,price,total);
        calculatesSubTotal();
        calculateDiscountPrice(getDiscount(),getSubTotal() );
        calculateVATPrice(Shop.VAT,getSubTotal());
        calculateBillTotal(getSubTotal(),getDiscountedAmount(),getVATPrice());
        System.out.print("Customer Name: ");
        String customerName = purchaseCollector.next();
        setCustomerName(customerName);
        System.out.print("Cashier: ");
        String cashierName = purchaseCollector.next();
        setCashierName(cashierName);
        printPurchaseSummary();
        }

    public double calculateTotalCostOfGoods(Double priceOfGoods, int numberOfGoods) {
        totalCost = priceOfGoods * numberOfGoods;
        return totalCost;
        }

    public void movingContentOfArrayListToArray(ArrayList<String>items, ArrayList<Integer>quantity, ArrayList<Double>price, ArrayList<Double>total) {

        purchaseSummary = new String[counter][4];

        for (int i = 0; i < items.size(); i++) {
            purchaseSummary[i][0] = items.get(i);
        }
        for (int i = 0; i < quantity.size(); i++) {
            purchaseSummary[i][1] = String.valueOf(quantity.get(i));
        }
        for (int i = 0; i < price.size(); i++) {
            purchaseSummary[i][2] = String.valueOf(price.get(i));
        }
        for (int i = 0; i < total.size(); i++) {
            purchaseSummary[i][3] = String.valueOf(total.get(i));
        }

        for (String[] rows : purchaseSummary) {
            System.out.println(Arrays.toString(rows));
        }

    }

        public void calculatesSubTotal() {
            for (Double aDouble : total) {
                subTotal = subTotal + aDouble;
            }
        }


        public double calculateDiscountPrice(double discount,double subTotal){
        discountedAmount = discount * subTotal;
        return discountedAmount;}

        public double calculateVATPrice(double VAT, Double subTotal){
        VATPrice= VAT*subTotal;
        return VATPrice;
        }

        public double calculateBillTotal(double subTotal,double discountedAmount, double VATPrice){
             billAmount = (subTotal- discountedAmount+VATPrice);
            return billAmount;
        }

        public double calculateBalance(double billAmount){
            return payment - billAmount;
        }

        public void heading(){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(shopName);
            System.out.println(shopBranch);
            System.out.println("LOCATION: " + shopAddress);
            System.out.println("TEL: "+ shopPhoneNumber);
            System.out.println("DATE: "+ famiba);
            System.out.println("Cashier: "+ cashierName);
            System.out.println("Customer Name:"+ customerName);

        }

    public void printPurchaseSummary() {
        calculateBalance(getBillAmount());
        heading();
        summaryHeading = new String[]{"ITEMS", "QUANTITY", "PRICE", "TOTAL"};
            System.out.println("==============================================================================================");
            System.out.printf("%20s %20s  %20s %20s%n", summaryHeading[0],summaryHeading[1],summaryHeading[2],summaryHeading[3]);System.out.println();
            System.out.println("==============================================================================================");
        for (int s = 0; s < items.size(); s++) {
            System.out.printf("%20s %20s  %20s %20s%n", purchaseSummary[s][0], purchaseSummary[s][1], purchaseSummary[s][2], purchaseSummary[s][3]);
        }
            System.out.println("----------------------------------------------------------------------------------------------");

            System.out.printf("%50s: %.2f%n","SubTotal",subTotal);
            System.out.printf("%50s: %.2f%n","DISCOUNT",discountedAmount);
            System.out.printf("%50s: %.2f%n","VAT @ 17.50%",VATPrice);
            System.out.println("=============================================================================================");
            System.out.printf("%50s: %.2f%n","VAT @ BILLTOTAL",billAmount);
            System.out.println("=============================================================================================");
            System.out.printf("%60s: %.2f%n","THIS IS NOT A RECEIPT KINDLY PAY: ", billAmount);
            System.out.println("=============================================================================================");
    }

    public void printReceipt() {

        System.out.println();
        System.out.println();
        heading();
        System.out.println("============================================================================================");
        System.out.printf("%20s %20s  %20s %20s%n", summaryHeading[0],summaryHeading[1],summaryHeading[2],summaryHeading[3]);System.out.println();
        System.out.println("============================================================================================");
        for (int s = 0; s < items.size(); s++) {
            System.out.printf("%20s %20s  %20s %20s%n", purchaseSummary[s][0], purchaseSummary[s][1], purchaseSummary[s][2], purchaseSummary[s][3]);}
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%50s: %.2f%n","SubTotal",subTotal);
        System.out.printf("%50s: %.2f%n","DISCOUNT",discountedAmount);
        System.out.printf("%50s: %.2f%n","VAT @ 17.50%",VATPrice);
        System.out.println("============================================================================================");
        System.out.printf("%50s: %.2f%n","VAT @ BILLTOTAL",billAmount);
        System.out.printf("%50s: %.2f%n","AMOUNT PAID: ",getPayment());
        System.out.printf("%50s: %.2f%n","BALANCE: ",calculateBalance(billAmount));
        System.out.println("============================================================================================");
        System.out.printf("%60s%n","THANK YOU FOR YOUR PATRONAGE");
        System.out.println("============================================================================================");
    }

}












