package www.com.chapter_3;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView textview;
    int mlast_x = 0, mlast_y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (ImageView) findViewById(R.id.textview);

        textview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ObjectAnimator.ofFloat(textview, "translationX", mlast_x, x).setDuration(5).start();
                        ObjectAnimator.ofFloat(textview, "translationY", mlast_y, y).setDuration(5).start();
                        mlast_x = x;
                        mlast_y = y;
                        break;
                }

                return true;
            }
        });
    }
}
