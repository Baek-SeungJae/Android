package exam.day03view.selectView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckActivity extends AppCompatActivity {
    // 뷰의 주소값을 담을 참조변수
    TextView text1;
    CheckBox[] checkArr = new CheckBox[3];
    Switch mySwitch;
    Button showStatus;
    Button setCheckBtn;
    Button clearCheckBtn;
    Button reverseCheckStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        // 뷰의 주소 값을 가지고 온다. - 26버전부터는 캐스팅 클래스를 정의하지 않아도 된다.
        text1 = findViewById(R.id.checkTxt);
        checkArr[0] = findViewById(R.id.checkBox1);
        checkArr[1] = findViewById(R.id.checkBox2);
        checkArr[2] = findViewById(R.id.checkBox3);
        showStatus = findViewById(R.id.btnCheck1);
        setCheckBtn = findViewById(R.id.btnCheck2);
        clearCheckBtn = findViewById(R.id.btnCheck3);
        reverseCheckStats = findViewById(R.id.btnCheck4);
        mySwitch = findViewById(R.id.switch1);
        // 체크박스에 리스너를 설정한다.
        CheckBoxListener listener = new CheckBoxListener();
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].setOnCheckedChangeListener(listener);
        }
        mySwitch.setOnCheckedChangeListener(listener);
        showStatus.setOnClickListener(listener);
        setCheckBtn.setOnClickListener(listener);
        clearCheckBtn.setOnClickListener(listener);
        reverseCheckStats.setOnClickListener(listener);
    }

    public void getCheckStatus(View v) {
        //체크된 박스 확인하기
        text1.setText("");
        for (int i = 0; i < checkArr.length; i++) {
            if (checkArr[i].isChecked()) {
                text1.append(checkArr[i].getText() + " ");
            }
        }
    }

    public void setCheckVal(View v, boolean status) {
        //모든 체크박스를 status상태로 설정하기
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].setChecked(status);
        }
    }

    public void toggle(View v) {
        //체크박스의 상태 토글
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].toggle();
        }
    }

    public void checkBoxChange(String name, boolean status) {
        if (status) {
            Toast.makeText(CheckActivity.this, name + "체크 박스 선택", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CheckActivity.this, name + "체크 박스 해제", Toast.LENGTH_SHORT).show();
        }
    }

    public void swtichChange(String name, boolean status) {
        if (status) {
            Toast.makeText(CheckActivity.this, name + "스위치 선택", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CheckActivity.this, name + "스위치 해제", Toast.LENGTH_SHORT).show();
        }
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnCheck1:
                    setCheckVal(v, true);
                    break;
                case R.id.btnCheck2:
                    getCheckStatus(v);
                    break;
                case R.id.btnCheck3:
                    setCheckVal(v, false);
                    break;
                case R.id.btnCheck4:
                    toggle(v);
                    break;
            }
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch (buttonView.getId()) {
                case R.id.checkBox1:
                case R.id.checkBox2:
                case R.id.checkBox3:
                    checkBoxChange(  buttonView.getTag().toString(),isChecked);
                    break;
                case R.id.switch1:
                    swtichChange("스위치", isChecked);
                    break;
            }
        }
    }
}
