package fr.blacroix.semicircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import static android.graphics.Color.RED;
import static android.graphics.Paint.Style.FILL;

public class SemiCircleView extends View {

    public static final float MAX_ANGLE = 180;

    private static final int START_ANGLE = -180;

    private final RectF rectF = new RectF();
    private final Paint paint = new Paint();

    private float angle = 0;

    public SemiCircleView(Context context) {
        super(context);
        init();
    }

    public SemiCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SemiCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                rectF.set(0, 0, getWidth(), getWidth());
            }
        });
        paint.setAntiAlias(true);
        paint.setStyle(FILL);
        paint.setColor(RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rectF, START_ANGLE, angle, true, paint);
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    /**
     * @param color int color not Resource color
     */
    public void setColor(int color) {
        paint.setColor(color);
    }

    public float getAngle() {
        return angle;
    }
}
