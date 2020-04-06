package exam.day03view.selectView.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTestActivity extends ListActivity {
    ArrayList<HashMap<String, String>> listdata = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("name", "김서연");
        item.put("telNum", "010-1111-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name", "김범수");
        item.put("telNum", "010-1111-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name", "김진호");
        item.put("telNum", "010-1111-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name", "조권");
        item.put("telNum", "010-1111-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name", "강민경");
        item.put("telNum", "010-1111-2222");
        listdata.add(item);

        SimpleAdapter adapter = new SimpleAdapter(this,
                listdata, // HashMap으로 구성된 데이터가 저장된 리스트
                android.R.layout.simple_list_item_2, // row의 디자인
                new String[]{"name", "telNum"}, // HashMap에 저장된 키 리스트
                new int[]{android.R.id.text1,android.R.id.text2} // 위에서 저장한 map데이터를 view에 출력할 것인지 key의 순서에 따라서 리소스 아이디 순서
                );
        setListAdapter(adapter);
    }
}
