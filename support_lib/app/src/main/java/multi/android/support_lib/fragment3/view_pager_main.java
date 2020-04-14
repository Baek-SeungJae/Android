package multi.android.support_lib.fragment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import multi.android.support_lib.R;

public class view_pager_main extends AppCompatActivity {

    view1 v1 = new view1();
    view2 v2 = new view2();
    view3 v3 = new view3();
    fragment_main fm = new fragment_main();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);

    }

    public void btn_click(View v) {
        Log.d("fragment",v.toString());
        FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        switch (v.getTag().toString()) {
            case "0":
                transaction.replace(R.id.fragment, v1);
                break;
            case "1":
                transaction.replace(R.id.fragment, v2);
                break;
            case "2":
                transaction.replace(R.id.fragment, v3);
                break;
        }
        transaction.commit();
    }
}
