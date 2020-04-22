package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

public class RunOnThreadTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    boolean isRunning;
    long now_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_test);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        new MyThread().start();
    }

    public void btn_click(View v) {
        long now_time = SystemClock.currentThreadTimeMillis();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            while (!isRunning) {
                SystemClock.sleep(1000);
                now_time = System.currentTimeMillis();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        view2.setText("화면에 대한 처리" + now_time);
                    }
                });
            }
        }
    }
}
