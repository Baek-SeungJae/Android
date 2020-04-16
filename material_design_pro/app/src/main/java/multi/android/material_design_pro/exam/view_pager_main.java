package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class view_pager_main extends AppCompatActivity{
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
        setContentView(R.layout.activity_view_pager_exam);
        fragmentManager = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager);
        viewPager = (ViewPager) findViewById(R.id.fragmentPager);
        fragmentAdapter.addFragment(v1,"v1");
        fragmentAdapter.addFragment(v2,"v2");
        fragmentAdapter.addFragment(v3,"v3");
        fragmentAdapter.addFragment(vf,"vf");
        fragmentAdapter.addFragment(v4,"v4");
        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(new PageListener());
    }
    public void btn_click(View v) {
        Log.d("fragment",v.toString());
        switch (v.getTag().toString()) {
            case "0":
                viewPager.setCurrentItem(0);
                break;
            case "1":
                viewPager.setCurrentItem(1);
                break;
            case "2":
                viewPager.setCurrentItem(2);
                break;
            case "3":
                viewPager.setCurrentItem(3);
                break;
        }
    }
    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Toast.makeText(view_pager_main.this,"페이지 변경",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
