package io.giodude.baccaratnhcaobil.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.giodude.baccaratnhcaobil.Model.TipsModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.View.TipsView;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {
    Context context;
    public List<TipsModel> data;
    TextView title1,desc1;
    public TipsAdapter(Context context, List<TipsModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.tipsitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tipsTitle.setText(data.get(position).getSubtitle());
        holder.tipDesc.setText(data.get(position).getDescription());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.clickdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.title);
        desc1 = myDialog.findViewById(R.id.desc);
        for (int i = 0; i<data.size(); i++) {
            if(holder.tipsTitle.getText()==data.get(position).getSubtitle()){
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
        TextView tipsTitle,tipDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tipsTitle = itemView.findViewById(R.id.tipsname);
            tipDesc = itemView.findViewById(R.id.tipsdesc);
        }
    }
}
