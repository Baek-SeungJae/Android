package exam.day03view.selectView.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import exam.day03view.selectView.R;

public class ListViewTestActivity extends AppCompatActivity {
    //1. 리스트뷰에 출력할 데이터
    String[] datalist = {"java", "oracle", "HTML5", "CSS", "javascript", "servlet", "jsp", "spring", "hadoop", "flume", "sqoop", "hive", "R", "android"};
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        listView = findViewById(R.id.listview1);
        textView = findViewById(R.id.listTxt);
        /*
        리스트 뷰에 출력할 데이터?
        어떤 디자인으로 출력?
         */
        //2. Adapter 객체를 선택해서 생성
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datalist);

        //3. ListView에서 어댑터가 작업할 수 있도록 어댑터 연결
        listView.setAdapter(adapter);

        //이벤트 연결
        MyListener listener = new MyListener();
        listView.setOnItemClickListener(listener);
    }

    class MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            textView.setText(datalist[position]);
        }
    }
}
