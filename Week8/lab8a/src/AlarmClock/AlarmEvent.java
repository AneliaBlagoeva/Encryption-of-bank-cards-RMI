/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmClock;

/**
 *
 * @author grade
 */
public class AlarmEvent {
    private int nrings; // 0 by default

    public AlarmEvent(int nrings) {
        this.nrings = nrings;
    }

    public int getNrings() {
        return nrings;
    }
    
}
