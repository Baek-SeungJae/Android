package multi.android.support_lib.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kakao.usermgmt.LoginButton;

import multi.android.support_lib.R;

public class view_pager_main extends AppCompatActivity {

    view1 v1 = new view1();
    view2 v2 = new view2();
    view3 v3 = new view3();
    fragment_main fm = new fragment_main();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

    }

    public void btn_click(View v) {
        FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.button:
                transaction.replace(R.id.fragment, v1);
                break;
            case R.id.button2:
                transaction.replace(R.id.fragment, v2);
                break;
            case R.id.button3:
                transaction.replace(R.id.fragment, v3);
                break;
        }
        transaction.commit();
    }
}
