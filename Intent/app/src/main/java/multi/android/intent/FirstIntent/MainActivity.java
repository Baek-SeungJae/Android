package multi.android.intent.FirstIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.intent.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReturnDataFirstActivity.class);

                //intent에 공유할 데이터 저장
                intent.putExtra("info","첫 번째 액티비티가 넘기는 메시지");
                intent.putExtra("value",10000);

                startActivity(intent);
            }
        });
    }
}
