package exam.day03view.selectView.view.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03view.selectView.R;

//모든 뷰를 findViewById를 최소화하기 위해 정의
public class UserViewHolder {
    ImageView img;
    TextView name;
    TextView tel;
    EditText editText;

    //객체가 생성될 때 targetView(parentView)를 전달받는다.
    public UserViewHolder(View ParentView) {
        this.img = ParentView.findViewById(R.id.img);
        this.name = ParentView.findViewById(R.id.txtcust1);
        this.tel = ParentView.findViewById(R.id.txtcust2);
        this.editText = ParentView.findViewById(R.id.edtinfo);
    }
}
