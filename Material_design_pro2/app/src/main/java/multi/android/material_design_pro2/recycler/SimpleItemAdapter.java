package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

import multi.android.material_design_pro2.R;

// RecyclerView에서 사용하는 Adapter를 커스트마이징
// Adapter안에 ViewHolder포함 - 정의(ListView를 사용할 때와 동일한 역할)
// xml로부터 뷰(한 row에 대한 뷰)를 만ㄹ덜어서 ViewHolder 넘기는 작업
// View를 구성하는 구성요소의 리소스를 가져오는 작업을 하는 객체
// 1. onCreateViewHolder에서 row에 대한 정보를 가져온다.
// 2. ViewHolder 객체로 만들어서 1번에서 생성한 뷰를 넘긴다.
// 3. ViewHolder 객체 안에서 onCreateViewHolder메소드에서 리턴받은 객체에서 데이터를 연결할 뷰를 찾아온다.
// 4. onBindViewHolder메소드에서 ViewHolder가 갖고 있는 구성요소에 데이터를 연결하기
public class SimpleItemAdapter extends RecyclerView.Adapter<SimpleItemAdapter.ViewHoler> {
    Context context;
    int row_res_id;
    List<SimpleItem> data = new ArrayList<SimpleItem>();

    public SimpleItemAdapter(Context context, int row_res_id, List<SimpleItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id, null);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, final int position) {
        Log.d("recycler", "onBindViewHoler" + position);
        holder.txtView.setText(data.get(position).getData());
        holder.txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"데이터연결완료"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHoler extends RecyclerView.ViewHolder {
        TextView txtView;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.itemView);
        }
    }
}
