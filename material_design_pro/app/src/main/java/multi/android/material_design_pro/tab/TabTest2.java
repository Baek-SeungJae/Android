package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class TabTest2 extends AppCompatActivity {
    TabLayout tabs;
    ViewPager viewPager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    ArrayList<String> tabdatalist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test2);
        tabs = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);

        tabs.setTabTextColors(Color.CYAN, Color.WHITE);
        for (int i = 1; i <= 10; i++) {
            ChildFragment fragment = new ChildFragment();
            fragment.setTitle(i + "번째 타이틀");
            fragmentArrayList.add(fragment);
            tabdatalist.add("탭" + i);
        }

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),fragmentArrayList.size());
        viewPager.setAdapter(adapter);

        //뷰페이저와 탭레이아웃을 연결 - ViewPager의 getPageTitle을 호출해서 탭의 문자열 셋팅
        tabs.setupWithViewPager(viewPager);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabdatalist.get(position);
        }
    }
}
