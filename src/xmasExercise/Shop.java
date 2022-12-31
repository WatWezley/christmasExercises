package xmasExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Shop {
    public static final double VAT = 0.175;
    private String shopName;
    private String shopAddress;
    private String shopBranch;

    private String shopPhoneNumber;

    private String cashierName;

    private String customerName;



    private int numberOfGoods;
    private double priceOfGoods;

    private double totalCost;

    private double subTotal;

    private  double discountedAmount;

    private  double VATPrice;

    private static double discount = 0.08;

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

    public void setName() {
        this.shopName = shopName;
    }

    public String getName() {return shopName;}

    public void setAddress() {
        this.shopAddress = shopAddress;
    }

    public String getAddress() {
        return shopAddress;
    }

    public void setBranch() {this.shopBranch = shopBranch;}

    public String getBranch() {
        return shopBranch;
    }

    public void setShopPhoneNumber(){this.shopPhoneNumber=shopPhoneNumber;}

    public String getShopPhoneNumber(){return shopPhoneNumber;}

    public void setCashierName(String cashierName){
        this.cashierName = cashierName;}

    public String getCashierName(){return cashierName;}

    public void setCustomerName(String customerName){
        this.customerName = customerName;}

    public String getCustomerName(){return customerName;}

    public void setSubTotal(){subTotal = 0;
        this.subTotal=subTotal;}

    public double getSubTotal(){return subTotal;}

    public void setDiscount(){
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

    public void setDiscountedAmount(){
        discountedAmount=0;
        this.discountedAmount =discountedAmount;}

    public double getDiscountedAmount(){return discountedAmount;}

    public void setVATPrice(){this.VATPrice=VATPrice;}

    public double getVATPrice(){return VATPrice;}

    public void setBillAmount(){
        this.billAmount = billAmount;}

    public double getBillAmount(){return billAmount;}

    public void setPayment(double payment){
        this.payment= payment;}

    public  double getPayment(){return payment;}


    public void collectPurchaseInformation() {
        int morePurchase = 0;
        String goods;
        do {

            System.out.println("What do you want to buy: ");
            goods = purchaseCollector.next();
            items.add(counter, goods);


            System.out.print("How many of it: ");
            numberOfGoods = purchaseCollector.nextInt();
            quantity.add(counter, numberOfGoods);

            System.out.print("price:");
            priceOfGoods = purchaseCollector.nextDouble();
            price.add(counter, priceOfGoods);

            calculateTotalCostOfGoods(priceOfGoods, numberOfGoods);
            total.add(counter, totalCost);

            counter++;
            System.out.print("Do you want more purchase, 1 for Yes, 0 for No: ");
            morePurchase = purchaseCollector.nextInt();

        }
        while (morePurchase != 0);


    }

    public double calculateTotalCostOfGoods(Double priceOfGoods, int numberOfGoods) {
        totalCost = priceOfGoods * numberOfGoods;
        return totalCost;
    }

    public void movingContentOfArrayListToArray(ArrayList<String>items,ArrayList<Integer>quantity,ArrayList<Double>price,ArrayList<Double>total) {

        purchaseSummary = new String[counter][4];
        this.purchaseSummary = purchaseSummary;

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

        public double calculatesSubTotal() {
        for (int t = 0; t < total.size(); t++) {
            subTotal = subTotal + total.get(t);}
            return subTotal;
        }


        public double calculateDiscountPrice(double discount,double subTotal){
        discountedAmount = discount * subTotal;
        return discountedAmount;}

        public double calculateVATPrice(double VAT, Double subTotal){
        VATPrice= VAT*subTotal;
        return VATPrice;}

        public double calculateBillTotal(double subTotal,double discountedAmount, double VATPrice){
             billAmount = (subTotal- discountedAmount+VATPrice);
            return billAmount;
        }

        public double calculateBalance(double billAmount){
            double balance = payment - billAmount;
            return balance;
        }

        public void heading(){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(shopName);
            System.out.println(shopBranch);
            System.out.println("LOCATION: " + shopAddress);
            System.out.println("TEL: "+ shopName);
            System.out.println("DATE: "+ famiba);
            System.out.println("Cashier: "+ cashierName);
            System.out.println("Customer Name:"+ customerName);

        }

    public void printPurchaseSummary() {
        summaryHeading = new String[]{"ITEMS", "QUANTITY", "PRICE", "TOTAL"};
        this.summaryHeading = summaryHeading;
            System.out.println("==============================================================================================");
            System.out.printf("%20s %20s  %20s %20s%n", summaryHeading[0],summaryHeading[1],summaryHeading[2],summaryHeading[3]);System.out.println();
            System.out.println("==============================================================================================");
        for (int s = 0; s < items.size(); s++) {
            System.out.printf("%20s %20s  %20s %20s%n", purchaseSummary[s][0], purchaseSummary[s][1], purchaseSummary[s][2], purchaseSummary[s][3]);}
            System.out.println("----------------------------------------------------------------------------------------------");
            String N = "SubTotal";
            System.out.printf("%50s: %.2f%n",N,subTotal);
            String M = "DISCOUNT";
            System.out.printf("%50s: %.2f%n",M,discountedAmount);
            String O = "VAT @ 17.50%";
            System.out.printf("%50s: %.2f%n",O,VATPrice);
            System.out.println("=============================================================================================");
            String P = "VAT @ BILLTOTAL";
            System.out.printf("%50s: %.2f%n",P,billAmount);
            System.out.println("=============================================================================================");
            String Q = "THIS IS NOT A RECEIPT KINDLY PAY: ";
            System.out.printf("%60s: %.2f%n",Q, billAmount);
            System.out.println("=============================================================================================");
    }

    public void printReceipt() {
        System.out.println();
        System.out.println();
        System.out.println("=========================================================================================");
        System.out.printf("%20s %20s  %20s %20s%n", summaryHeading[0],summaryHeading[1],summaryHeading[2],summaryHeading[3]);System.out.println();
        System.out.println("================================================================================================");
        for (int s = 0; s < items.size(); s++) {
            System.out.printf("%20s %20s  %20s %20s%n", purchaseSummary[s][0], purchaseSummary[s][1], purchaseSummary[s][2], purchaseSummary[s][3]);}
        System.out.println("--------------------------------------------------------------------------------------------");
        String N = "SubTotal";
        System.out.printf("%50s: %.2f%n",N,subTotal);
        String M = "DISCOUNT";
        System.out.printf("%50s: %.2f%n",M,discountedAmount);
        String O = "VAT @ 17.50%";
        System.out.printf("%50s: %.2f%n",O,VATPrice);
        System.out.println("============================================================================================");
        String P = "VAT @ BILLTOTAL";
        System.out.printf("%50s: %.2f%n",P,billAmount);
        String Q = "AMOUNT PAID: ";
        System.out.printf("%50s: %.2f%n",Q,getPayment());
        String R= "BALANCE: ";
        System.out.printf("%50s: %.2f%n",R,calculateBalance(billAmount));
        System.out.println("============================================================================================");
        String S="THANK YOU FOR YOUR PATRONAGE";
        System.out.printf("%60s%n",S);
        System.out.println("============================================================================================");
    }

}












