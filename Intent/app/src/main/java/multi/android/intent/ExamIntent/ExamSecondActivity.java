package multi.android.intent.ExamIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import multi.android.intent.R;

public class ExamSecondActivity extends AppCompatActivity {
    Intent intent;
    String name;
    String tel;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);

        TextView info = findViewById(R.id.exam_result_txt);
        intent = getIntent();
        name = intent.getStringExtra("name");
        tel = intent.getStringExtra("tel");
        info.setText("입력한 id: "+name+" ,입력한 pass: "+tel);
        checkBox = findViewById(R.id.member_state);
    }

    public void firstExamClickBtn2(View V){
        if(checkBox.isChecked()) {
            setResult(RESULT_OK, intent);
        }
        intent.putExtra("name2", name);
        intent.putExtra("tel2", tel);
        finish();
    }
}
