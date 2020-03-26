package exam.day02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

//액티비티가 실행될 때 TextView의 문자열을 변경
//
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv = findViewById(R.id.second_txtView);
        tv.setText("안녕");
    }
}
