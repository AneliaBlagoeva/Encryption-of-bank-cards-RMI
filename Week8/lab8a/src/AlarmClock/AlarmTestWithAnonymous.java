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
public class AlarmTestWithAnonymous{
    private AlarmClock  clock;

    public AlarmTestWithAnonymous(int rings) {
        this.clock = new AlarmClock(rings);
        this.clock.addAlarmListener(new AlarmListener() {
            @Override
            public void alarmActionPerformed(AlarmEvent args) {
                System.out.printf("Rings: %d   %n", clock.getNrings() );
            }
        });
    }

    public AlarmClock getClock() {
        return clock;
    }
    
    public static void main(String[] args) {
       AlarmTestWithAnonymous at = new AlarmTestWithAnonymous(10);
       at.getClock().start();
    }
}
