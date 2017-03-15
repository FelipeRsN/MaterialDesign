package felipersn.com.br.materialdesign.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import felipersn.com.br.materialdesign.Activity.InstructiveActivity;
import felipersn.com.br.materialdesign.Activity.VectorDrawableActivity;
import felipersn.com.br.materialdesign.Application.App;
import felipersn.com.br.materialdesign.Model.CardviewModel;
import felipersn.com.br.materialdesign.R;
import felipersn.com.br.materialdesign.Activity.TransitionActivity;

/**
 * Created by Felipe Silveira on 3/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<CardviewModel> itens;
    private Activity activity;

    public RecyclerAdapter(Activity activity, List<CardviewModel> itens) {
        this.itens = itens;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //inflate your layout and pass it to view holder
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.cardview_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.view = view;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int position) {
        final int getPosition = position;
        final CardviewModel card = itens.get(position);
        viewHolder.title.setText(card.getTitle());
        viewHolder.desc.setText(card.getDescription());
        viewHolder.icon.setImageBitmap(card.getIcon());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().vibrate(activity.getBaseContext(), 10);
                switch (getPosition){
                    case 0: activity.startActivity(new Intent(activity, TransitionActivity.class));
                        break;
                    case 1: activity.startActivity(new Intent(activity, InstructiveActivity.class));
                        break;
                    case 2: activity.startActivity(new Intent(activity, VectorDrawableActivity.class));
                        break;
                    default: Snackbar.make(v,"Position not found",Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != itens ? itens.size() : 0);
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView desc;
        private ImageView icon;
        private View view;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            desc = (TextView) view.findViewById(R.id.description);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }
}
