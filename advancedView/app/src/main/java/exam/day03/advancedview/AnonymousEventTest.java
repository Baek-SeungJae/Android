package exam.day03.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnonymousEventTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_test);
        Button btn = findViewById(R.id.mybtn);
        // 익명이너클래스
        // new 인터페이스명() => 지정한 인터페이스의 하위객체를 만들어서
        // setOnClickListener의 매개변수로 전달하겠다는 의미
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("???","???????");
                Toast.makeText(AnonymousEventTest.this,"익명이너클래스",Toast.LENGTH_LONG).show();
            }
        });
    }
}
