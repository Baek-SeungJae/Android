package exam.day03view.selectView.view.adapter2;


import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03view.selectView.R;

public class ViewHolder {
    ImageView exam_img;
    TextView exam_custxt1;
    TextView exam_custxt2;
    TextView exam_custxt3;
    CheckBox exam_checkbox;

    public ViewHolder(View ParentView) {
        this.exam_img = ParentView.findViewById(R.id.exam_img);
        this.exam_custxt1 = ParentView.findViewById(R.id.exam_custxt1);
        this.exam_custxt2 = ParentView.findViewById(R.id.exam_custxt2);
        this.exam_custxt3 = ParentView.findViewById(R.id.exam_custxt3);
        this.exam_checkbox = ParentView.findViewById(R.id.exam_checkbox);
    }

    @Override
    public String toString() {
        return "ViewHolder{" +
                "exam_img=" + exam_img +
                ", exam_custxt1=" + exam_custxt1 +
                ", exam_custxt2=" + exam_custxt2 +
                ", exam_custxt3=" + exam_custxt3 +
                ", exam_checkbox=" + exam_checkbox +
                '}';
    }
}
