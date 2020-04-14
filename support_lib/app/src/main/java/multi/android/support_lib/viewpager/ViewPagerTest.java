package multi.android.support_lib.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;
/*
 * 1. ViewPager에 담을 데이터 - View, Fragment
 * 2. Adapter 커스트마이징
 * 3. ViewPager에 Adapter연결하기
 * */

public class ViewPagerTest extends AppCompatActivity {
    ArrayList<View> viewlist = new ArrayList<View>();
    ViewPager mainpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        mainpager = findViewById(R.id.mainPager);

        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.view1, null);
        View view2 = inflater.inflate(R.layout.view2, null);
        View view3 = inflater.inflate(R.layout.view3, null);
        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);

        // 3. viewpager에 어댑터 연결하기
        mainpagerAdapter adpater = new mainpagerAdapter();
        mainpager.setAdapter(adpater);
        mainpager.setCurrentItem(0);
    }
    class mainpagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewlist.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            mainpager.addView(viewlist.get(position));
            return viewlist.get(position);
        }

        //매개변수로 전달된 뷰들끼리 비교
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            mainpager.removeView((View) object);
        }
    }
}
