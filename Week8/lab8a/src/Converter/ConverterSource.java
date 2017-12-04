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
public class ConverterSource {

    private ConvertListener cl;
    ConvertEvent e;

    public ConverterSource(double value) {
        e = new ConvertEvent(value);
    }

    public ConverterSource(ConvertListener c) {
        this.cl = c;
    }

    public ConvertEvent getEvent() {
        return e;
    }

    public void setEvent(ConvertEvent ev) {
        if (e != null) {
            e = ev;
        } else {
            System.out.println("Error!");
        }
    }

    public void addListener(ConvertListener c) {
        this.cl = c;
    }

    public void convertCurrency(ConvertEvent e) {
        cl.convertPerformed(e);
    }

}
