package exam.day03.advancedview;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBar = findViewById(R.id.progress3);
    }
    public void btn1_click(View v){
        //5증가
        progressBar.incrementProgressBy(5);
    }
    public void btn2_click(View v){
        //5감소
        progressBar.incrementProgressBy(-5);
    }
    public void btn3_click(View v){
        //값 셋팅
        progressBar.setProgress(80);
    }
}