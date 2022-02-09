package com.example.colorassignment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class TouchListener implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        return false;
    }
}
