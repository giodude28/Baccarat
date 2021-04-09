package io.giodude.baccaratnhcaobil.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.giodude.baccaratnhcaobil.Model.VariationModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.View.VariationView;

public class VariationAdapter extends RecyclerView.Adapter<VariationAdapter.ViewHolder> {
    Context context;
    public List<VariationModel> data;
    TextView title1,desc1;
    public VariationAdapter(Context context, List<VariationModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item  = layoutInflater.inflate(R.layout.variationitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getSubtitle());
        Picasso.get().load(data.get(position).getImage()).into(holder.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.prog.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                holder.img.setImageResource(R.drawable.ic_launcher_background);
                holder.prog.setVisibility(View.GONE);
            }
        });

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.clickdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.title);
        desc1 = myDialog.findViewById(R.id.desc);
        for (int i = 0; i<data.size(); i++) {
            if(holder.title.getText()==data.get(position).getSubtitle()){
                title1.setText(data.get(position).getSubtitle());
                desc1.setText(data.get(position).getDescription());
            }
        }
        holder.itemView.setOnClickListener(v -> myDialog.show());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        ProgressBar prog;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.vartitle);
            img = itemView.findViewById(R.id.varimg);
            prog = itemView.findViewById(R.id.progressicon);
        }
    }
}
