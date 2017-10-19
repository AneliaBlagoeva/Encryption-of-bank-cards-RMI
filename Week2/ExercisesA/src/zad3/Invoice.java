/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author user
 */
public class Invoice {
    
    private String partNumber;

    /**
     * Get the value of partNumber
     *
     * @return the value of partNumber
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Set the value of partNumber
     *
     * @param partNumber new value of partNumber
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    private String partDescription;

    /**
     * Get the value of partDescription
     *
     * @return the value of partDescription
     */
    public String getPartDescription() {
        return partDescription;
    }

    /**
     * Set the value of partDescription
     *
     * @param partDescription new value of partDescription
     */
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    private int quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        if(quantity>0){
            this.quantity = quantity;
        }else{
            quantity=0;
        }
    }

    private double price;

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price) {
        if(price>0){
            this.price = price;
        }else{
            price=0.0;
        }
    }

    public Invoice(String partNumber, String partDescription, int quantity, double price) {
        setPartNumber(partNumber);
        setPartDescription(partDescription);
        setPrice(price);
        setQuantity(quantity);

    }
    
    public Invoice(){
        
    }

    public double getInvoiceAmount() {
       
        return quantity*price;
    }
    
    
}
