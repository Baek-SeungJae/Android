package exam.day03view.selectView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import exam.day03view.selectView.R;

public class RadioActivity extends AppCompatActivity {
    // 뷰의 주소값을 담을 참조변수
    RadioButton radio3, radio4;
    RadioGroup group1, group2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        // 뷰의 주소 값을 얻어온다.
        radio3 = (RadioButton) findViewById(R.id.radioButton3);
        radio4 = (RadioButton) findViewById(R.id.radioButton4);
        group1 = (RadioGroup) findViewById(R.id.group1);
        group2 = (RadioGroup) findViewById(R.id.group2);
        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);

        // 라디오 그룹에 리스너를 설정한다.
        RadioListener listener = new RadioListener();
        group1.setOnCheckedChangeListener(listener);
        group2.setOnCheckedChangeListener(listener);
    }

    public void btnRadioCheck(View v) {
        radio3.setChecked(true);
        radio4.setChecked(true);
    }

    public void btnGetRadioStatus(View v) {
        //라디오 그룹 내에서 해야됨
        int Id1 = group1.getCheckedRadioButtonId();
        int Id2 = group2.getCheckedRadioButtonId();
        text1.setText(Id1 + "버튼이 선택");
        text2.setText(Id2 + "버튼이 선택");
    }

    class RadioListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getId()) {
                case R.id.group1:
                    switch (checkedId) {
                        case R.id.radioButton:
                            Log.d("radio", "1번그룹의 1-1버튼");
                    }
                    break;
                case R.id.group2:
                    break;
            }
        }
    }
}










