package multi.android.datamanagementpro.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import multi.android.datamanagementpro.R;

public class MainActivity extends
        AppCompatActivity implements AdapterView.OnItemClickListener, OnClickListener {
    DBHandler handler;
    EditText edtName;
    EditText edtSu;
    EditText edtPrice;
    ListView listview;
    ArrayList<String> datalist = new ArrayList<String>();
    ArrayList<HashMap<String, String>> datalist2 = new ArrayList<HashMap<String, String>>();
    ArrayAdapter adapter;
    SimpleAdapter adapter2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        handler = DBHandler.open(this);

        findViewById(R.id.btnIns).setOnClickListener(this);
        findViewById(R.id.btnResult).setOnClickListener(this);
        findViewById(R.id.btnResult2).setOnClickListener(this);
        findViewById(R.id.btnSearch).setOnClickListener(this);
        listview = findViewById(R.id.list);
        listview.setOnItemClickListener(this);

        edtName = (EditText) findViewById(R.id.edtName);
        edtSu = (EditText) findViewById(R.id.edtSu);
        edtPrice = (EditText) findViewById(R.id.edtPrice);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIns:
                handler.insert(v, edtName.getText().toString(), edtPrice.getText().toString(), edtSu.getText().toString());
                break;
            case R.id.btnResult:
                handler.select1(v, datalist);
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datalist);
                listview.setAdapter(adapter);
                break;
            case R.id.btnResult2:
                handler.select2(v, datalist2);
                adapter2 = new SimpleAdapter(this, datalist2, android.R.layout.simple_list_item_2, new String[]{"name", "info"}, new int[]{android.R.id.text1, android.R.id.text2});
                listview.setAdapter(adapter2);
                break;
            case R.id.btnSearch:
                handler.search(v, edtName.getText().toString(), datalist2);
                adapter2 = new SimpleAdapter(this, datalist2, android.R.layout.simple_list_item_2, new String[]{"name", "info"}, new int[]{android.R.id.text1, android.R.id.text2});
                listview.setAdapter(adapter2);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra("product", datalist.get(position).substring(datalist.get(position).indexOf(", ") + 1, datalist.get(position).length()));
        startActivity(intent);
    }
}



















