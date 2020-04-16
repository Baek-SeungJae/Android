package multi.android.material_design_pro.tab.exam;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import multi.android.material_design_pro.R;

public class view_pager_main extends AppCompatActivity{
    TabLayout tabs;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    FragmentManager fragmentManager;
    view1 v1 = new view1();
    view2 v2 = new view2();
    view3 v3 = new view3();
    view4 v4 = new view4();
    ListFragment vf = new ListFragmentTest();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam2);
        fragmentManager = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager);
        viewPager = (ViewPager) findViewById(R.id.fragment);
        tabs = findViewById(R.id.tabs);
        tabs.setTabTextColors(Color.WHITE, Color.YELLOW);
        fragmentAdapter.addFragment(v1,"첫번째 탭");
        fragmentAdapter.addFragment(v2,"두번째 탭");
        fragmentAdapter.addFragment(v3,"세번째 탭");
        fragmentAdapter.addFragment(vf,"리스트 탭");
        fragmentAdapter.addFragment(v4,"지도");
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);

    }

}
