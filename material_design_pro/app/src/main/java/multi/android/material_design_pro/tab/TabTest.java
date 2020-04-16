package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.FragmentAdapter;
import multi.android.material_design_pro.exam.ListFragmentTest;
import multi.android.material_design_pro.exam.view1;
import multi.android.material_design_pro.exam.view2;
import multi.android.material_design_pro.exam.view3;
import multi.android.material_design_pro.exam.view4;
import multi.android.material_design_pro.exam.view_pager_main;

public class TabTest extends AppCompatActivity {
    FragmentAdapter fragmentAdapter;
    FragmentManager fragmentManager;
    view1 v1 = new view1();
    view2 v2 = new view2();
    view3 v3 = new view3();
    view4 v4 = new view4();
    ListFragment vf = new ListFragmentTest();
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        tabLayout = findViewById(R.id.tabLayout);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할 때 보여줄 프래그먼트 지정
        getSupportFragmentManager().beginTransaction().replace(R.id.container,v1).commit();

        //탭에
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v1).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v2).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v3).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v4).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_item1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v1).commit();
                        break;
                    case R.id.bottom_item2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v2).commit();
                        break;
                    case R.id.bottom_item3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,v3).commit();
                        break;
                }
                return false;
            }
        });
    }
}
