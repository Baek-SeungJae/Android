package multi.android.material_design_pro2.exam2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class RecyclerCardViewAdapter extends RecyclerView.Adapter<RecyclerCardViewAdapter.ViewHolder> {
    Context context;
    int row_res_id;
    List<CardViewItem> items = new ArrayList<CardViewItem>();

    public RecyclerCardViewAdapter(Context context, int row_res_id, List<CardViewItem> items) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerCardViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id, null);
        return new RecyclerCardViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCardViewAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getRes());
        holder.textView.setText(items.get(position).getIntro());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView2);
        }
    }
}

