/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class InvoiceTest {

    public static void main(String[] args) {
        //declaration
        Invoice invoice;
        String partNumber, partDescription;
        int quantity;
        double price, result;

        Scanner kbd;
        //initialization

        kbd = new Scanner(System.in);

        System.out.print("Enter part number: ");
        partNumber = kbd.nextLine();

        System.out.print("Enter part description: ");
        partDescription = kbd.nextLine();

        System.out.print("Enter part quantity: ");
        quantity = kbd.nextInt();

        System.out.print("Enter part price: ");
        price = kbd.nextDouble();

        invoice = new Invoice(partNumber, partDescription, quantity, price);
        //processing
        result = invoice.getInvoiceAmount();

        //output
        System.out.printf("An item with part number: %s"
                + " is with invoice amount: %.2f%n", partNumber, result);
    }

}
