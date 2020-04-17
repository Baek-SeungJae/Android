package multi.android.material_design_pro2.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerView;
    List<CircleItem> items = new ArrayList<CircleItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        recyclerView = findViewById(R.id.circle_recycler_view);
        items.add(new CircleItem(R.drawable.gong));
        items.add(new CircleItem(R.drawable.jang));
        items.add(new CircleItem(R.drawable.jung));
        items.add(new CircleItem(R.drawable.lee));
        items.add(new CircleItem(R.drawable.so));


        RecyclerCircleAdapter adapter = new RecyclerCircleAdapter(this, R.layout.circle_item, items);
        /*
        GridLayoutManager LayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setHasFixedSize(true);
        */
        LinearLayoutManager LayoutManager = new LinearLayoutManager(getApplicationContext());
        LayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(LayoutManager);

        recyclerView.setAdapter(adapter);
    }
}
