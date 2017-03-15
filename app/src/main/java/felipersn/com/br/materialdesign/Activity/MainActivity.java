package felipersn.com.br.materialdesign.Activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import felipersn.com.br.materialdesign.Adapter.RecyclerAdapter;
import felipersn.com.br.materialdesign.Model.CardviewModel;
import felipersn.com.br.materialdesign.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    private ArrayList<CardviewModel> list;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Material Design");

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setData(); //adding data to array list
        adapter = new RecyclerAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        list = new ArrayList<CardviewModel>();
        list.add(new CardviewModel("Shared elements transitions",
                "The nature of this transition forces the human eye to focus on the content and its representation in the new activity instead of the actual activity frame sliding or fading which makes the experience a lot more seamless.",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.move)));

        list.add(new CardviewModel("Instructive Motion",
                "Our eyes are naturally drawn to motion. If something iss moving while everything around iy stays the same, we're naturally drawn to the thing that's moving.",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_eye_grey_48dp)));

        list.add(new CardviewModel("Animated Vector Drawables",
                "Starting from API 25, AnimatedVectorDrawable runs on RenderThread (as opposed to on UI thread for earlier APIs). This means animations in AnimatedVectorDrawable can remain smooth even when there is heavy workload on the UI thread.",
                BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_vector_curve_grey600_48dp)));

    }
}
