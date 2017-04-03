package fr.blacroix.semicircle;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class SemiCircleAnimation extends Animation {

    private final SemiCircleView semiCircleView;
    private final float oldAngle;
    private final float newAngle;

    public SemiCircleAnimation(SemiCircleView semiCircleView, float newAngle) {
        this.semiCircleView = semiCircleView;
        this.oldAngle = semiCircleView.getAngle();
        this.newAngle = newAngle;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float angle = 0 + ((newAngle - oldAngle) * interpolatedTime);
        semiCircleView.setAngle(angle);
        semiCircleView.requestLayout();
    }
}
