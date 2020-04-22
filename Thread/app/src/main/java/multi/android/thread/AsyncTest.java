package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AsyncTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    long now_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_test);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
    }
    public void btn_click(View v){
        now_time = SystemClock.currentThreadTimeMillis();
        view1.setText(now_time+"");
        AsyncTaskExam asyncTaskExam = new AsyncTaskExam();
        asyncTaskExam.execute(10,20);

    }
    /*
        AsyncTask 이용
        시간이 오래 걸리는 작업도 가능, UI를 변경하는 작업도 가능
        1) AsycncTask를 상속받는 클래스를 정의
           => AsyncTask에 제네릭을 적용해서 벼눗 세 개의 타입을 정의(사용자 임의로)
           - 첫번째 제네릭 : execute를 호출해서 AsyncTask를 실행할 때 필요한 매개변수의 타입 -> doInBackground를 호출할 때 전달
           - 두번째 제네릭 : publishProgress의 매개변수 타입 -> onProgressUpdate의 매개변수 -> 화면출력에 필요한 값
           - 세번째 제네릭 : 작업이 끝나고 onPostExecute에 전달
        2) 메소드를 오버라이딩
           - doInBackground : Background에서 실행될 작업을 정의 일반 쓰레드에서
                             run메소드에 정의했던 코드를 구현,
                             네트워크, 시간이 오래 걸리는 작업을 여기서 처리,
                             화면관련 처리는 할 수 없다.
           => 매개변수가 가변형이고 배열로 처리
            - doPreExecute : doInBackground메소드가 호출되기 전에 실행되는 메소드
                             일반쓰레드로 처리할 일들이 실행되기 전에 해야하는 일들을 구현
                             메인쓰레드에서 호출되는 메소드이므로 화면처리 가능,
                             오래걸리는 작업을 넣으면 안된다.
            - doProgressUpdate : doInBackground가 실행되는 중에 UI를 변경해야 할 일이 있는 경우에 호출되는 메소드
                                doInBackground 내부에서 화면을 변경해야 할 일이 생기면 publishProgress메소드를 호출하면 자동으로 onProgressUpdate가 호출된다.
                                UI쓰레드에서 호출하기 때문에 시간이 오래걸리는 작업을 하면 안된다.
            - onCancelled : 작업이 취소되는 경우 호출되는 메소드
            - onPostExecute : doInBackground메소드가 끝나면 호출되는 메소드
                             UI쓰레드에서 호출되므로 뷰를 변경할 수 있고, 간단한 작업만 해야한다.
        3) AsyncTask의 하위객체를 생성
        4) 생성된 AsyncTask를 실행
            - AsyncTask의 execute메소드를 호출
     */
    class AsyncTaskExam extends AsyncTask<Integer,Long,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myasync","onPreExecute");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            StringBuffer sb = new StringBuffer();
            sb.append(integers[0]);
            for(int i=1; i<integers.length;i++){
                sb.append(","+ integers[i]);
            }
            for(int i=0; i<10; i++){
                SystemClock.sleep(1000);
                Log.d("myasync",i+" doInBackground "+sb.toString());
                publishProgress(i+now_time);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            Log.d("myasync","onProgressUpdate");
            view2.setText("Async테스트: "+values[0]);

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.d("myasync","onCancelled");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("myasync","onPostExecute");
        }
    }
}
