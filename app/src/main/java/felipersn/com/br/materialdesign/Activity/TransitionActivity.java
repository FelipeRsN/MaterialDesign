package felipersn.com.br.materialdesign.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import felipersn.com.br.materialdesign.Application.App;
import felipersn.com.br.materialdesign.R;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView sharedImage_01;
    private ImageView sharedImage_02;
    private ImageView sharedImage_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared elements transitions");

        sharedImage_01 = (ImageView) findViewById(R.id.image);
        sharedImage_02 = (ImageView) findViewById(R.id.image_02);
        sharedImage_03 = (ImageView) findViewById(R.id.image_03);

        sharedImage_01.setOnClickListener(this);
        sharedImage_02.setOnClickListener(this);
        sharedImage_03.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                App.getInstance().vibrate(this, 10);
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, TransitionSubActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            if(v == sharedImage_01) {
                Bundle bundle = ActivityOptions
                        .makeSceneTransitionAnimation(this, sharedImage_01, sharedImage_01.getTransitionName())
                        .toBundle();
                i.putExtra("shared","1");
                startActivity(i,bundle);
            }
            if(v == sharedImage_02) {
                Bundle bundle = ActivityOptions
                        .makeSceneTransitionAnimation(this, sharedImage_02, sharedImage_02.getTransitionName())
                        .toBundle();
                i.putExtra("shared","2");
                startActivity(i,bundle);
            }
            if(v == sharedImage_03) {
                Bundle bundle = ActivityOptions
                        .makeSceneTransitionAnimation(this, sharedImage_03, sharedImage_03.getTransitionName())
                        .toBundle();
                i.putExtra("shared","3");
                startActivity(i,bundle);
            }
        }else startActivity(i);
    }
}
