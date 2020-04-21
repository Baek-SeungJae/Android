package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    TextView textPer;
    int progressVal;
    Handler handler1;
    Handler handler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.text1);
        textPer = findViewById(R.id.textper);
        //핸들러의 하위객체를 익명으로 생성
        handler1 = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Log.d("mythread", "handlerMessage요청");
                textPer.setText(progressVal + "%");
                progressBar.incrementProgressBy(1);
            }
        };
        handler2 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                textPer.setText(msg.arg1 + "%");
                progressBar.setProgress(msg.arg1);
            }
        };
    }

    /*
        화면을 변경하는 작업을 다른 메소드에서 처리
        긴 시간동안 실행하며 view를 변경하려 하는 경우 실행되는 동안 다르작업을 할 수 없다.
        실행이 되는 동안 사용자의 이벤트가 발생하고 이벤트에 5초동안 반응하지 않으면 안드로이드 OS는 어플리케이션을 강제 종료한다.
        ANR(Application Not Responding)
        오랫동안 처리해야 하는 작업을 UI쓰레드에 정의하면 안된다.
    */

    public void btnNoThread(View v) {
        for (progressVal = 0; progressVal < 100; progressVal++) {
            progressBar.setProgress(progressVal);
            SystemClock.sleep(10);
        }
    }

    public void useThread(View v) {
        // 프로그래스바에 진행상태가 출력되도록 설정
        // 프로그래스바의 progress가 변경되는 것을 쓰레드로 만들어서 실행
        // 개발자가 만든 쓰레드 - worker thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (progressVal = 0; progressVal < 100; progressVal++) {
                    progressBar.setProgress(progressVal);
                    textPer.setText(progressVal + "%");
                    SystemClock.sleep(100);
                }
            }
        }).start();
    }

    public void useHandler(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (progressVal = 0; progressVal < 100; progressVal++) {
                    handler1.sendMessage(handler1.obtainMessage());
                    SystemClock.sleep(100);
                }
            }
        }).start();
    }

    // 핸들러를 이용해서 UI변경 요청
    // 작업쓰레드에서 값을 핸들러에게 넘기기
    // 핸들러에게 작업을 외뢰할 때 Message 객체를 생성해서 전달
    public void useMessageHandler(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i=0; i<100;i++){
                   //변경할 뷰의 정보나 Handler에게 전달한 데이터를 Message객체로 생성한다.
                   Message msg = new Message();
                   //handler에게 작업을 의뢰한 쓰레드를 구분하기 위한 코드
                   msg.what = 1;
                   msg.arg1=i; //전달할 데이터
                   handler2.sendMessage(msg);
                   SystemClock.sleep(100);
               }
            }
        }).start();
    }
    /*
    안드로이드에서 쓰레드 처리하기
    1. Handler를 이용
        1) 동시 실행흐름을 처리할 내용을 쓰레드 객체로 구현
        2) UI 쓰레드에서 Handler객체를 생성
            On Create 메소드 내부에서 처리
        3) worker thread에서 Handler 객체에게 작업을 의로
        4) handler 객체에서 worker thread로 부터 의뢰받은 내용을 처리
            - handlerMessage메소드를 이용해서 처리(오버라이딩해서 구현)
            - work thread한테 전달받은 값으로 view를 변경
            - 쓰레드로 부터 요청이 올때마다 handleMessage메소드가 호출된다.
     */
}
