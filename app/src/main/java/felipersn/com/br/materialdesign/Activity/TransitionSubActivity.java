package felipersn.com.br.materialdesign.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import felipersn.com.br.materialdesign.Application.App;
import felipersn.com.br.materialdesign.R;

public class TransitionSubActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView sharedContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_sub);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Content shared");

        sharedContent = (ImageView) findViewById(R.id.image);

        if(getIntent().hasExtra("shared")){
            String shared = getIntent().getStringExtra("shared");
            switch (shared){
                case "1": sharedContent.setImageResource(R.drawable.image_transition);
                    break;
                case "2": sharedContent.setImageResource(R.drawable.image_transition_2);
                    break;
                case "3": sharedContent.setImageResource(R.drawable.image_transition_3);
                    break;
                default: break;
            }
        }


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Slide slide = new Slide(Gravity.BOTTOM);
//            slide.addTarget(R.id.text);
//            slide.setInterpolator(AnimationUtils.loadInterpolator(this,android.R.interpolator.linear_out_slow_in));
//            slide.setDuration(400);
//            getWindow().setEnterTransition(slide);
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                App.getInstance().vibrate(this, 10);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
