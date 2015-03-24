package com.example.student.superstrobewidget;

import android.hardware.Camera;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Isaac on 3/24/2015.
 */
public class StrobeTypeTimers {

    private StrobeTypes strobeType;
    private Timer timer;

    public StrobeTypeTimers() {
        this(StrobeTypes.STROBE);
    }

    public StrobeTypeTimers(StrobeTypes type)
    {
        this.timer = new Timer();
        this.strobeType = type;
    }

    public void setType(StrobeTypes type, int millis)
    {
        this.strobeType = type;
        setType(millis);
    }

    public void setType(int millis)
    {
        switch (this.strobeType) {
            case STROBE:
                startStrobeTimer(millis);
                break;
            case PULSE:
                break;
            default:
                break;
        }
    }

    private void stopTimers() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
    }


    private void startStrobeTimer(int millis)
    {
        TimerTask tt =  new TimerTask() {
            @Override
            public void run() {
                try {
                    Camera camera = Camera.open();

                    Camera.Parameters parameters = camera.getParameters();

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);

                    camera.startPreview();
                    camera.stopPreview();

                    camera.release();
                } catch (Exception e)
                {
                    stopTimers();
                }
            }
        };

        stopTimers();
        timer.scheduleAtFixedRate(tt, 0, millis);
    }

}
