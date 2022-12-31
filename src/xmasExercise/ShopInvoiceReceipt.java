package xmasExercise;

import java.util.Scanner;

public class ShopInvoiceReceipt {

    public static void main(String[] args) {

        Scanner purchaseCollector = new Scanner(System.in);
        Shop famibaShop = new Shop("Famiba", "No 1 Constution Crescent", "Main","08036457939");
        famibaShop.collectPurchaseInformation();
        famibaShop.movingContentOfArrayListToArray(famibaShop.items,famibaShop.quantity,famibaShop.price,famibaShop.total);
        famibaShop.calculatesSubTotal();
        famibaShop.calculateDiscountPrice(famibaShop.getDiscount(), famibaShop.getSubTotal() );
        famibaShop.calculateVATPrice(Shop.VAT,famibaShop.getSubTotal());
        famibaShop.calculateBillTotal(famibaShop.getSubTotal(),famibaShop.getDiscountedAmount(),famibaShop.getVATPrice());
        System.out.print("Cashier: ");
        String cashierName = purchaseCollector.nextLine();
        famibaShop.setCashierName(cashierName);
        System.out.print("Customer Name: ");
        String customerName = purchaseCollector.nextLine();
        famibaShop.setCustomerName(customerName);
        famibaShop.heading();
        famibaShop.printPurchaseSummary();
        System.out.print("How much did the customer give: ");
        double payment = purchaseCollector.nextDouble();
        famibaShop.setPayment(payment);
        famibaShop.calculateBalance(famibaShop.getBillAmount());
        famibaShop.heading();
        famibaShop.printReceipt();

    }
}
