package felipersn.com.br.materialdesign.Activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Interpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.ScrollView;

import felipersn.com.br.materialdesign.Application.App;
import felipersn.com.br.materialdesign.R;

public class InstructiveActivity extends AppCompatActivity {

    private ScrollView mScrollView;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructive);

        mScrollView = (ScrollView) findViewById(R.id.scrollview);
        back = (ImageView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().vibrate(getBaseContext(), 10);
                finish();
            }
        });
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        final int startScrollPos = App.getInstance().dpToPx(this, 150);
        Animator animator = ObjectAnimator.ofInt(
                mScrollView,
                "scrollY",
                startScrollPos)
                .setDuration(300);
        animator.start();
    }
}

