package exam.day03view.selectView.view.adapter2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> actorlist;
    HashMap<Integer, SaveCheckState> savedata = new HashMap<Integer, SaveCheckState>();

    public ExamAdapter(Context context, int resId, ArrayList<ActorItem> actorlist) {
        super(context, resId, actorlist);
        this.context = context;
        this.resId = resId;
        this.actorlist = actorlist;
    }

    @Override
    public int getCount() {
        return actorlist.size();
    }
    @Override
    public ActorItem getItem(int position) {
        return actorlist.get(position);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ActorItem actor = actorlist.get(position);
        if (actor != null) {
            ImageView exam_img = holder.exam_img;
            TextView exam_custxt1 = holder.exam_custxt1;
            TextView exam_custxt2 = holder.exam_custxt2;
            TextView exam_custxt3 = holder.exam_custxt3;
            final CheckBox exam_checkbox = holder.exam_checkbox;

            exam_img.setImageResource(actor.exam_img);
            exam_custxt1.setText(actor.name);
            exam_custxt2.setText(actor.date);
            exam_custxt3.setText(actor.comment);

            SaveCheckState state = savedata.get(position);
            if (state == null) {
                exam_checkbox.setChecked(false);
            } else {
                exam_checkbox.setChecked(state.check);
            }
            exam_checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean check = exam_checkbox.isChecked();
                    SaveCheckState objstate = new SaveCheckState();
                    objstate.check = check;
                    Log.d("status",check+"");
                    savedata.put(position, objstate);
                }
            });
        }


        return convertView;

    }
}
