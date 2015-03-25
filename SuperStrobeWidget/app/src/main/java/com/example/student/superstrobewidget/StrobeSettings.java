package com.example.student.superstrobewidget;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class StrobeSettings extends ActionBarActivity {

    private RadioButton strobeButton;
    private RadioButton pulseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.strobeButton = (RadioButton) findViewById(R.id.strobe_radio_button);
        this.pulseButton = (RadioButton) findViewById(R.id.pulse_radio_button);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    public void testOnClick(View view) {
        if (this.pulseButton.isChecked()) {
            StrobeTypeTimers stt = new StrobeTypeTimers(StrobeTypes.PULSE);
            stt.startStrobe(3000);
        } else {
            StrobeTypeTimers stt = new StrobeTypeTimers(StrobeTypes.STROBE);
            stt.startStrobe(100);
        }
    }
}
