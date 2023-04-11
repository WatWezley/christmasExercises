package xmasExercise.InvoiceReceipt;

import xmasExercise.InvoiceReceipt.Shop;

import java.util.Scanner;

public class ShopInvoiceReceipt {

    public static void main(String[] args) {

        Scanner purchaseCollector = new Scanner(System.in);
        Shop famibaShop = new Shop("Famiba", "No 1 Constution Crescent", "Main","08036457939");
        famibaShop.collectPurchaseInformation();
        System.out.print("How much did the customer give: ");
        double payment = purchaseCollector.nextDouble();
        famibaShop.setPayment(payment);
        famibaShop.printReceipt();

    }
}
