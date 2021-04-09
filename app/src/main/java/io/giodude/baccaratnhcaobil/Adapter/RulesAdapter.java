package io.giodude.baccaratnhcaobil.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.giodude.baccaratnhcaobil.Model.RulesModel;
import io.giodude.baccaratnhcaobil.R;
import io.giodude.baccaratnhcaobil.View.RulesView;

public class RulesAdapter extends RecyclerView.Adapter<RulesAdapter.ViewHolder> {
    Context context;
    public List<RulesModel> data;

    public RulesAdapter(Context context, List<RulesModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.rulesitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.title.setText(data.get(position).getSubtitle());
    holder.desc.setText(data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rulename);
            desc = itemView.findViewById(R.id.ruledesc);
        }
    }
}
