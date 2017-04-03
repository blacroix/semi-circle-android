package fr.blacroix.semicircle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static android.graphics.Color.BLUE;

public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        SemiCircleView semiCircleView = (SemiCircleView) findViewById(R.id.semi_circle_view);
        semiCircleView.setColor(BLUE);
        SemiCircleAnimation animation = new SemiCircleAnimation(semiCircleView, 180);
        animation.setDuration(2_000);
        semiCircleView.startAnimation(animation);
    }
}
