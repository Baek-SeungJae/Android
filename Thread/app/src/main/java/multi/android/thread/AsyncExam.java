package multi.android.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AsyncExam extends AppCompatActivity {
    Button btn1;
    Button btn2;
    ImageView iv;
    TextView tv;
    ProgressBar pb;
    AsyncTaskExam asyncTaskExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_exam);
        init();
    }

    public void init() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn2.setEnabled(false);
        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.result);
        pb = findViewById(R.id.progressBar3);
    }

    public void btn_click1(View v) {
        asyncTaskExam = new AsyncTaskExam();
        asyncTaskExam.execute();
        btn1.setEnabled(false);
        btn2.setEnabled(true);

    }

    public void btn_click2(View v) {
        asyncTaskExam.cancel(true);
    }

    class AsyncTaskExam extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myasync", "onPreExecute");
            pb.setMax(50);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int sum = 0;
            int i = 1;
            while (isCancelled() == false) {
                if (i > 50)
                    break;
                sum += i;
                publishProgress(i);
                SystemClock.sleep(100);
                i++;
            }
            return sum;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
            if (values[0] % 2 == 0) {
                iv.setImageResource(R.drawable.d1);
            } else {
                iv.setImageResource(R.drawable.d2);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.d("myasync", "onCancelled");
            pb.setProgress(0);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            iv.setImageResource(0);
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);
            Log.d("myasync", "onPostExecute");
            tv.setText("Result: " + s);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
        }
    }
}
