/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import javax.swing.JOptionPane;

public class StockTest {

    public static void main(String[] args) {
        //declaration
        Stock r = new Stock();

        String currentPrice,
                previousClosingPrice;

        //initialization
        currentPrice = JOptionPane.showInputDialog("Enter current price: ");
        r.setCurrentPrice(Double.parseDouble(currentPrice));

        previousClosingPrice = JOptionPane.showInputDialog("Enter previous closing price: ");
        r.setPriviousClosingPrice(Double.parseDouble(previousClosingPrice));

        //output
        JOptionPane.showMessageDialog(null, "Percent of change is: "+ r.changePercent() + "%");
    }
}
