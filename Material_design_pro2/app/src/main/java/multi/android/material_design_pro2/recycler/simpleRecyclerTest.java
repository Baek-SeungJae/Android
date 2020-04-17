package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class simpleRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_test);
        recyclerView = findViewById(R.id.list);
        // 1. Recycler에 출력할 데이터 준비
        List<SimpleItem> recycler_simple_data = new ArrayList<SimpleItem>();
        for (int i = 0; i < 50; i++) {
            SimpleItem item = new SimpleItem("simple_item_" + i*1000000);
            recycler_simple_data.add(item);
        }
        // 2. Adapter 생성
        SimpleItemAdapter adapter = new SimpleItemAdapter(this, R.layout.simple_item, recycler_simple_data);
        // 2-2. Recycler의 레이아웃을 설정 ( ex) LinearLayout, GridLayout
        GridLayoutManager LayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LayoutManager);
        // 3. Recycler와 adpater를 연결
        recyclerView.setAdapter(adapter);
        // 4. 추가적인 요소들을 적용할 수 있다. - 꾸미기, 애니매이션
    }
}
