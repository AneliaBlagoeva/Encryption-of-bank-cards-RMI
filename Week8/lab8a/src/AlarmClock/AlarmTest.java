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
public class AlarmTest implements AlarmListener {

    private AlarmClock clock;

    public AlarmTest(int rings) {
        this.clock = new AlarmClock(rings);
        this.clock.addAlarmListener(this);
    }

    public AlarmClock getClock() {
        return clock;
    }

    @Override
    public void alarmActionPerformed(AlarmEvent args) {
        System.out.printf("Rings: %d   %n", clock.getNrings());
    }

    public static void main(String[] args) {
        AlarmTest at = new AlarmTest(10);
        System.out.println("Ring with time no duration between rings.");
        at.getClock().start();// rings without time interval between rings
        System.out.println("Ring with time duration of 2 secs between rings.");
        at.getClock().setNrings(10);
        at.getClock().startWithTime(2);// rings with 2 secs between rings
    }

}
