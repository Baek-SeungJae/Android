package multi.android.material_design_pro2.exam2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardViewRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerView;
    List<CardViewItem> items = new ArrayList<CardViewItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_recycler_test);
        recyclerView = findViewById(R.id.card_view_recycler);
        items.add(new CardViewItem(R.drawable.gong,"공유는 도깨비"));
        items.add(new CardViewItem(R.drawable.lee,"이민호는 신의"));
        items.add(new CardViewItem(R.drawable.jung,"정우성은 비트"));
        items.add(new CardViewItem(R.drawable.jang,"검색어를 입력하세요 WWW"));
        items.add(new CardViewItem(R.drawable.so,"미안하다사랑한다"));

        RecyclerCardViewAdapter adapter = new RecyclerCardViewAdapter(this, R.layout.card_view_item, items);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(getApplicationContext());
        LayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(adapter);

    }
}
