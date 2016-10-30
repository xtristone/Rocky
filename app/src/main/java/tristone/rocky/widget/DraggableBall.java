package tristone.rocky.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/9/25.
 */

public class DraggableBall extends View {

    private static final int SCREEN_WIDTH = 0;
    private static final int SCREEN_HEIGHT = 1;

    private Paint paint;

    private int radius;

    private int screenWidth;

    private int screenHeight;

    public DraggableBall(Context context) {
        super(context);
    }

    public DraggableBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        screenWidth = getScreenSize(context, SCREEN_WIDTH);
        screenHeight = getScreenSize(context, SCREEN_HEIGHT);
        radius = 100;
    }

    public DraggableBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int resultWidth;
        int resultHeight;

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        if (modeWidth == MeasureSpec.EXACTLY) {
            resultWidth = MeasureSpec.getSize(widthMeasureSpec);
        } else {
            resultWidth = screenWidth;            //UNSPECIFIED

            if (modeWidth == MeasureSpec.AT_MOST) {
                resultWidth = radius * 6;
            }
        }

        if (modeHeight == MeasureSpec.EXACTLY) {
            resultHeight = MeasureSpec.getSize(heightMeasureSpec);
        } else {
            resultHeight = screenHeight;            //UNSPECIFIED

            if (modeHeight == MeasureSpec.AT_MOST) {
                resultHeight = radius * 6;
            }
        }
        setMeasuredDimension(resultWidth, resultHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(radius*3, radius*3, radius, paint);
        canvas.drawCircle(radius*3, radius, radius/2, paint);
        canvas.drawCircle(radius*3, radius*5, radius/2, paint);

        canvas.save();
        canvas.translate(radius*3, radius*3);
        canvas.rotate(90);
        canvas.drawCircle(0, radius*2, radius/2, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(radius*3, radius*3);
        canvas.rotate(270);
        canvas.drawCircle(0, radius*2, radius/2, paint);
        canvas.restore();
    }

    private int getScreenSize(Context context, int type) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        if (type == SCREEN_WIDTH) {
            return metrics.widthPixels;       //The absolute width of the display in pixels.
        } else if (type == SCREEN_HEIGHT) {
            return metrics.heightPixels;    //The absolute height of the display in pixels.
        }

        return 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);
    }
}
