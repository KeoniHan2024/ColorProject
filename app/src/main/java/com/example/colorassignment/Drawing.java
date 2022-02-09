package com.example.colorassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;


public class Drawing extends SurfaceView {
    //Instance variables for customcircles and customrectangles
    public CustomCircle plate;
    public CustomRect sausage;
    public CustomRect water;
    public CustomRect spam;
    public CustomRect mask;
    public CustomCircle bagel;

    private Canvas cv;

    private Paint magentaPaint = new Paint();

    //Instance variables for object colors so you can change them with ease
    private int bagelColor = 0xFFF0D1A0;
    private int plateColor = 0xEFEFEFEF;
    private int sausageColor = 0xFF964B00;
    private int waterColor = 0xFF007577;
    private int spamColor = 0xFFB41F1F;
    private int maskColor = 0xFF44B4A8;


    public Drawing(Context context) {
        super(context);
        initPaints();
        setWillNotDraw(false);
    }

    public Drawing(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
        setWillNotDraw(false);
    }

    public Drawing (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
        setWillNotDraw(false);
    }

    private void initPaints() {
        this.magentaPaint.setColor(0xFF7D0552);
        this.magentaPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        plate = new CustomCircle("Plate", plateColor , canvas.getWidth()/2, canvas.getHeight()/2, 500);
        sausage = new CustomRect("Sausage", sausageColor , canvas.getWidth()/8 * 5, canvas.getHeight()/8 + 20,(canvas.getWidth()/8 * 5) + 60, 800);
        water = new CustomRect("Water", waterColor , canvas.getWidth()/10 - 80, canvas.getHeight()/7, canvas.getWidth()/10 * 2 + 20, canvas.getHeight() - 30);
        spam = new CustomRect("Spam", spamColor, canvas.getWidth()/8 * 2 + 80, canvas.getHeight()/8 + 50, canvas.getWidth()/8 * 3 + 20, 650);
        mask = new CustomRect("Mask", maskColor, canvas.getWidth()/8 * 6 + 20,canvas.getHeight()/7 + 20, canvas.getWidth()/8*7 + 90, 900);
        bagel = new CustomCircle("Bagel", bagelColor, canvas.getWidth()/8 * 4, canvas.getHeight()/7*4, 200 );
        plate.drawMe(canvas);
        sausage.drawMe(canvas);
        water.drawMe(canvas);
        spam.drawMe(canvas);
        mask.drawMe(canvas);
        bagel.drawMe(canvas);
        cv = canvas;
    }

    //Returns circle object based on number
    public CustomCircle getCircle(int type) {
        if (type == 1) {
            return this.plate;
        }
        else if(type == 2) {
            return this.bagel;
        }
        return null;
    }

    //Returns rectangle object based on number
    public CustomRect getRectangle(int type) {
        if (type == 1) {
            return this.sausage;
        }
        else if (type == 2) {
            return this.water;
        }
        else if (type == 3) {
            return this.spam;
        }
        else if (type == 4) {
            return this.mask;
        }
        return null;
    }

    //sets the color of the rectangle object based on the int based on the above methods
    public void setRectColor(int color, int type) {
        if (type == 1) {
            sausageColor = color;
        }
        else if (type == 2) {
            waterColor = color;
        }
        else if (type == 3) {
            spamColor = color;
        }
        else if (type == 4) {
            maskColor = color;
        }
    }

    //sets the color of the circle object based on the int based on the above methods
    public void setCircleColor(int color, int type) {
        if (type == 1) {
            plateColor = color;
        }
        else if(type == 2) {
            bagelColor = color;
        }
    }

    public Canvas getCanvas(){
        return cv;
    }
}
