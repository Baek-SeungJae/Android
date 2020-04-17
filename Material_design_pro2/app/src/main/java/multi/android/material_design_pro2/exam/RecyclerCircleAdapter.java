package multi.android.material_design_pro2.exam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class RecyclerCircleAdapter extends RecyclerView.Adapter<RecyclerCircleAdapter.ViewHolder>{
    Context context;
    int row_res_id;
    List<CircleItem> items = new ArrayList<CircleItem>();

    public RecyclerCircleAdapter(Context context, int row_res_id, List<CircleItem> items) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Log.d("test",items.get(position).getRes()+"");
        holder.civ.setImageResource(items.get(position).getRes());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView civ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            civ = itemView.findViewById(R.id.circle_img_view);
        }
    }
}
