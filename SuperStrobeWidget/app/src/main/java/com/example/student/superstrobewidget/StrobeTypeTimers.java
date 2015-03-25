package com.example.student.superstrobewidget;

import android.hardware.Camera;
import android.util.Log;

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

    public void startStrobe(StrobeTypes type, int millis)
    {
        this.strobeType = type;
        startStrobe(millis);
    }

    public void startStrobe(int millis)
    {
        switch (this.strobeType) {
            case STROBE:
                startStrobeTimer(millis);
                break;
            case PULSE:
                startPulseTimer(millis);
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

    private void startPulseTimer(int millis) {

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

                    camera = Camera.open();

                    parameters = camera.getParameters();

                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);

                    camera.startPreview();
                    camera.stopPreview();

                    camera.release();

                    camera = Camera.open();

                    parameters = camera.getParameters();

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


    private void startStrobeTimer(int millis)
    {
        Log.i("Flash","Flash");
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
