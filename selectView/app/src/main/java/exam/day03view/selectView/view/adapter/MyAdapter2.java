package exam.day03view.selectView.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import exam.day03view.selectView.R;

//성능개선
// 1. 한 번 만든 뷰는 재사용
// 2. findViewById -> 한번 작업한 뷰에 대한 정보는 저장해 놓고 다시 사용
public class MyAdapter2 extends ArrayAdapter<User> {
    private Context context;
    private int resId;
    private ArrayList<User> datalist;
    HashMap<Integer, SaveUserState> savedata = new HashMap<Integer, SaveUserState>();

    public MyAdapter2(Context context, int resId, ArrayList<User> datalist) {
        super(context, resId, datalist);
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }

    //매개변수로 전달받은 순서에 있는 리스트 항목을 반환
    @Override
    public int getCount() {
        return datalist.size();
    }
    @Override
    public User getItem(int position) {
        return datalist.get(position);
    }
    //리스트의 한 항목을 만들때 호출되는 메소드 - 리스트 항목이 100개면 100번 호출
    //position => 리스트 순서
    //convertView => 한 항목에 대한 뷰
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("getView", "getview" + position);
        long start = System.nanoTime();
        UserViewHolder holder = null;
        //뷰를 생성 - 매개변수로 전달되는 convertView를 재사용
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            // ========= 뷰를 만드는 최초작업 ===========
            holder = new UserViewHolder(convertView);
            //홀더를 저장
            convertView.setTag(holder);
        } else {
            // ========= 최초작업이 아님 ===========
            holder = (UserViewHolder) convertView.getTag();
        }

        //위에서 생성한 뷰의 각 요소에 데이터를 연결
        User user = datalist.get(position);
        if (user != null) {
            ImageView img = holder.img;
            TextView name = holder.name;
            TextView tel = holder.tel;
            final EditText editText = holder.editText;

            img.setImageResource(user.myImg);
            tel.setText(user.telNum);
            name.setText(user.name);

            SaveUserState state = savedata.get(position);
            if (state == null) {
                editText.setText("");
            } else {
                editText.setText(state.data);
            }
            //EditText가 focus를 잃어버리는 시점에 입력한 데이터를 저장
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        String data = editText.getText().toString();
                        SaveUserState objstate = new SaveUserState();
                        objstate.data = data;
                        savedata.put(position, objstate);
                    }
                }
            });
        }

        long end = System.nanoTime();
        Log.d("time", "" + (end - start) / 100000.);
        return convertView;
    }
}
