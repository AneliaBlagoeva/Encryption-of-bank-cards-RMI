package zad4;

public class Stock {

    private String symbol;

    private String name;

    private double priviousClosingPrice;

    private double currentPrice;

    public Stock() {
    }
    

    public Stock(String symbol, String name) {
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPriviousClosingPrice() {
        return priviousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPriviousClosingPrice(double priviousClosingPrice) {
        if(priviousClosingPrice<0)
        {
            priviousClosingPrice=0;
        }
        else{
            this.priviousClosingPrice=priviousClosingPrice;
        }
    }

    public void setCurrentPrice(double currentPrice) {
        if(currentPrice<0)
        {
            currentPrice=0;
        }
        else{
            this.currentPrice=currentPrice;
        }
    }

    public double changePercent() {
        //declaration
        double percent;
        
        //initialization
        percent=0;
        
        //processing
        percent=this.getPriviousClosingPrice()/(this.getPriviousClosingPrice()-
                this.getCurrentPrice());
        
        //output
        return percent;
    }
}
