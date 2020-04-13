package multi.android.support_lib.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import multi.android.support_lib.R;

public class MainActivity extends AppCompatActivity {
    // 화면에 연결할 프래그먼트 객체를 생성한다.
    FirstFragment firstFragments = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFirst = findViewById(R.id.btnAddFrag);
        Button btnRemove = findViewById(R.id.btnRemoveFrag);
        Button btnSecond = findViewById(R.id.btnSecondFrag);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("first");
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("remove");
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("second");
            }
        });
    }
    // 구분해 놓은 영역에 fragment를 교체해서 보여줄 메소드
    public void setFragment(String fragment){
        //fragment 객체를 관리하는 관리자객체를 구한다.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (fragment){
            case "first":
                //특정영역을 지정한 fragment로 교체
                transaction.replace(R.id.container,firstFragments);
                break;
            case "second":
                transaction.replace(R.id.container,secondFragment);
                break;
            case "remove":
                //firstFragment를 안 보이도록
                transaction.remove(firstFragments);
                // detach을 한 번 사용하면 replace 다시 못함
                //transaction.detach(firstFragments);
                break;
        }
        //commitNow는 지금 당장 처리해달라고 요청
        //commit은 스케줄 고려해서 알아서 변경해 달라고 요청
        //transaction.commitNow();
        transaction.commit();
    }
}
