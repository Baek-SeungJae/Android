package exam.day03view.selectView.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import exam.day03view.selectView.R;

public class ResourceDataListActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        listView = findViewById(R.id.listview1);
        textView = findViewById(R.id.listTxt);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.mylist_data, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        MyListener listener = new MyListener();
        listView.setOnItemClickListener(listener);
    }

    class MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView listTxt = (TextView)view;
            textView.setText(listTxt.getText());
        }
    }
}
