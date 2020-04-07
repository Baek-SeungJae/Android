package exam.day03view.selectView.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AddViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        //layout 만들기 - width, height 지정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Layout에 추가할 view를 생성 - 상위 뷰의 크기정보를 갖고있는 LayoutParams를 설정
        Button btn = new Button(this);
        btn.setText("코드로 만들어진 버튼");
        btn.setLayoutParams(params);

        //Layout에 뷰를 추가
        layout.addView(btn);

        setContentView(layout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn2 = new Button(AddViewTestActivity.this);
                btn2.setText("이벤트로 만들어진 객체");
                layout.addView(btn2);
            }
        });
    }
}
