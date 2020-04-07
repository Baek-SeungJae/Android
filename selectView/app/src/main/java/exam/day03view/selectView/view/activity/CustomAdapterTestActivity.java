package exam.day03view.selectView.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import exam.day03view.selectView.R;
import exam.day03view.selectView.view.adapter.MyAdapter;
import exam.day03view.selectView.view.adapter.User;
import exam.day03view.selectView.view.adapter.MyAdapter2;

public class CustomAdapterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_test);
        TextView info = findViewById(R.id.txtInfo_cust);
        ListView listview = findViewById(R.id.cust_listView);

        //1. 리스트에 출력할 데이터
        ArrayList<User> datalist = new ArrayList<User>();
        for(int i=0; i<100; i++){
            User user = new User(R.drawable.ic_launcher_foreground,"name"+i,"000000"+i);
            datalist.add(user);
        }
        //2. Adapter 생성
        MyAdapter adapter = new MyAdapter(this, R.layout.custrow2, datalist);

        //3. Adapter붙여넣기
        listview.setAdapter(adapter);
    }
}
