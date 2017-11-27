/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmClock;

import java.time.LocalDateTime;

/**
 *
 * @author grade
 */
public class AlarmClock {

    private AlarmListener alarm;
    private int nrings;// define in the constructor

    public AlarmClock(int nrings) {
        setNrings(nrings);
    }

    public int getNrings() {
        return nrings;
    }

    public final void setNrings(int nrings) {
        this.nrings = nrings > 0 ? nrings : 3;
    }

    public void addAlarmListener(AlarmListener a) {
        alarm = a;
    }

    public void onAlarm(AlarmEvent e) {
        if (alarm != null) {
            //Invoke  the event handler.
            alarm.alarmActionPerformed(e);
        }
    }

// event handling method 
    public void start() {

        for (;;) {
            nrings--;
            if (nrings < 0) {
                break;
            } else {
                AlarmEvent e = new AlarmEvent(nrings);
                onAlarm(e);
            }

        }
    }// event handling method 

    public void startWithTime(int duractionBetweenRings) {
      LocalDateTime currDateTime ;
      currDateTime = LocalDateTime.now();
      int currentSeconds = currDateTime.getSecond();
      int passedSeconds = 0;
      int newTime;
        for (;;) {
            newTime = LocalDateTime.now().getSecond()/duractionBetweenRings; 
            if (newTime > passedSeconds) {
                nrings--;
                if (nrings < 0) {
                    break;
                } else {
                    AlarmEvent e = new AlarmEvent(nrings);
                    onAlarm(e);
                }
            }
            passedSeconds = newTime;
        }
    }
}
