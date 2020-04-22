package multi.android.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HandlerExam2 extends AppCompatActivity {
    Handler handler;
    TextView textView;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_exam);
        textView = findViewById(R.id.textView);
        handler = new Handler();
    }

    public void useMessageHandlerExam2(View v) {
        new NumThread().start();
    }

    class UIUpdateThread implements Runnable {
        @Override
        public void run() {
            textView.setText(num + "");
        }
    }

    class NumThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                num = i;
                handler.post(new UIUpdateThread());
                SystemClock.sleep(100);
            }
        }
    }
}
