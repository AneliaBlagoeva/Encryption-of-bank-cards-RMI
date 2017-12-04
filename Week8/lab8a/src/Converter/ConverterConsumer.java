/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

/**
 *
 * @author Administrator
 */
public class ConverterConsumer implements ConvertListener {

    ConverterSource source;
    
    public ConverterConsumer(double value) {
        this.source = new ConverterSource(value);
        this.source.addListener(this);
    }

    public ConverterSource getCv() {
        return source;
    }

    public void setCv(ConverterSource cv) {
        this.source = cv;
    }

    @Override
    public void convertPerformed(ConvertEvent e) {
        double valueInEU = e.getValue() * 2.00;
        System.out.println(valueInEU);
    }

    public static void main(String[] args) {
        ConverterConsumer cons = new ConverterConsumer(10);
        cons.getCv().convertCurrency(cons.getCv().getEvent());
    }

}
