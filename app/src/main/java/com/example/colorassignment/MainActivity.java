package com.example.colorassignment;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //makes sure its landscape to keep drawing dimensions
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        //Object connected to surfaceView
        Drawing canvas = findViewById(R.id.surfaceView);

        //Seekbar objects
        SeekBar redSeekBar = findViewById(R.id.seekBarRed);
        SeekBar greenSeekBar = findViewById(R.id.seekBarGreen);
        SeekBar blueSeekBar = findViewById(R.id.seekBarBlue);

        //Textview
        TextView selectedObject = findViewById(R.id.selectedObject);

        //Instance variables for getCirlce or getRectangle methods
        final int[] currentCircle = {0};
        final int[] currentRect = {0};


        //Sets up listener
        canvas.setOnTouchListener(
                new View.OnTouchListener() {
                    //Instance Variables for color values
                    int color = 0;
                    int red = 0;
                    int green = 0;
                    int blue = 0;


                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        //Instance variables for coordinates, circle/rectangle objects, and
                        int x = (int)event.getX();
                        int y = (int)event.getY();

                        //Uses method to set customcircle and customrect objects to find if coordinates match up
                        CustomCircle plate = canvas.getCircle(1);
                        CustomCircle bagel = canvas.getCircle(2);
                        CustomRect sausage = canvas.getRectangle(1);
                        CustomRect water = canvas.getRectangle(2);
                        CustomRect spam = canvas.getRectangle(3);
                        CustomRect mask = canvas.getRectangle(4);


                        //resets what was chosen earlier
                        currentCircle[0] = 0;
                        currentRect[0] = 0;

                        //If statements to see which drawing is being clicked
                        if(spam.containsPoint(x,y)){
                            color = spam.getColor();
                            red = red(color);
                            green = green(color);
                            blue = blue(color);
                            currentRect[0] = 3;
                            selectedObject.setText(spam.getName());
                        }
                        else if (sausage.containsPoint(x, y)) {
                            color = sausage.getColor();
                            red = red(color);
                            green = green(color);
                            blue = blue(color);
                            currentRect[0] = 1;
                            selectedObject.setText(sausage.getName());
                        }
                        else if(bagel.containsPoint(x, y)) {
                            color = bagel.getColor();
                            red = red(color);
                            green = green(color);
                            blue = blue(color);
                            currentCircle[0] = 2;
                            selectedObject.setText(bagel.getName());
                        }
                        else if(water.containsPoint(x, y)) {
                            color = water.getColor();
                            red = red(color);
                            green = green(color);
                            blue = blue(color);
                            currentRect[0] = 2;
                            selectedObject.setText(water.getName());
                        }
                        else if(mask.containsPoint(x, y)) {
                            color = mask.getColor();
                            red = red(color);
                            green = green(color);
                            blue = blue(color);
                            currentRect[0] = 4;
                            selectedObject.setText(mask.getName());
                        }
                        else if(plate.containsPoint(x, y)) {
                            color = plate.getColor();
                            red = red(color);
                            green = green(color);
                            blue = blue(color);
                            currentCircle[0] = 1;
                            selectedObject.setText(plate.getName());
                        }

                        //sets seekbar values based on color of object
                        redSeekBar.setProgress(red);
                        greenSeekBar.setProgress(green);
                        blueSeekBar.setProgress(blue);

                        return false;
                    }
                });

        //Set up listener for redSeekBar and if user changes the seekbar it will get the value of the red and send back a new color value to set the drawing's color as
        redSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        int red = 0;
                        int green = 0;
                        int blue = 0;
                        CustomCircle selectedCircle;
                        CustomRect selectedRect;
                        if(b) {
                            if (currentCircle[0] > 0) {
                                selectedCircle = canvas.getCircle(currentCircle[0]);
                                green = green(selectedCircle.getColor());
                                blue = blue(selectedCircle.getColor());
                                canvas.setCircleColor(rgb(i, green, blue),currentCircle[0]);
                                canvas.invalidate();
                            } else if (currentRect[0] > 0) {
                                selectedRect = canvas.getRectangle(currentRect[0]);
                                green = green(selectedRect.getColor());
                                blue = blue(selectedRect.getColor());
                                canvas.setRectColor(rgb(i, green, blue), currentRect[0]);
                                canvas.invalidate();
                            }
                            canvas.invalidate();
                        }
                        }


                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        //Set up listener for greenSeekBar and if user changes the seekbar it will get the value of the green and send back a new color value to set the drawing's color as
        greenSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        int red = 0;
                        int green = 0;
                        int blue = 0;
                        CustomCircle selectedCircle;
                        CustomRect selectedRect;
                        if(b) {
                            if (currentCircle[0] > 0) {
                                selectedCircle = canvas.getCircle(currentCircle[0]);
                                red = red(selectedCircle.getColor());
                                blue = blue(selectedCircle.getColor());
                                canvas.setCircleColor(rgb(red, i, blue),currentCircle[0]);
                                canvas.invalidate();
                            } else if (currentRect[0] > 0) {
                                selectedRect = canvas.getRectangle(currentRect[0]);
                                red = red(selectedRect.getColor());
                                blue = blue(selectedRect.getColor());
                                canvas.setRectColor(rgb(red, i, blue), currentRect[0]);
                                canvas.invalidate();
                            }
                            canvas.invalidate();
                        }
                    }


                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        //Set up listener for blueSeekBar and if user changes the seekbar it will get the value of the blue and send back a new color value to set the drawing's color as
        blueSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        int red = 0;
                        int green = 0;
                        int blue = 0;
                        CustomCircle selectedCircle;
                        CustomRect selectedRect;
                        if(b) {
                            if (currentCircle[0] > 0) {
                                selectedCircle = canvas.getCircle(currentCircle[0]);
                                red = red(selectedCircle.getColor());
                                green = green(selectedCircle.getColor());
                                canvas.setCircleColor(rgb(red, green, i),currentCircle[0]);
                                canvas.invalidate();
                            } else if (currentRect[0] > 0) {
                                selectedRect = canvas.getRectangle(currentRect[0]);
                                red = red(selectedRect.getColor());
                                green = green(selectedRect.getColor());
                                canvas.setRectColor(rgb(red, green, i), currentRect[0]);
                                canvas.invalidate();
                            }
                            canvas.invalidate();
                        }
                    }


                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}
