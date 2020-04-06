package exam.day03.advancedview;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity {
    // 뷰의 주소 값을 담을 참조변수
    SeekBar seek1, seek2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_main);
        seek1 = (SeekBar) findViewById(R.id.seekBar);
        seek2 = (SeekBar) findViewById(R.id.seekBar2);
        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int id = seekBar.getId();
                switch (id) {
                    case R.id.seekBar:
                        text1.setText("첫번째 seekbar:" + progress);
                        break;
                    case R.id.seekBar2:
                        text1.setText("두번째 seekbar:" + progress);
                        break;
                }
                if (fromUser) {
                    text2.setText("사용자가 변경");
                } else {
                    text2.setText("코드가 변경");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                int id = seekBar.getId();
                switch (id) {
                    case R.id.seekBar:
                        text1.setText("첫 번째 SeekBar Touch 시작");
                        break;
                    case R.id.seekBar2:
                        text1.setText("두 번째 SeekBar Touch 시작");
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int id = seekBar.getId();
                switch (id) {
                    case R.id.seekBar:
                        text1.setText("첫 번째 SeekBar Touch 종료");
                        break;
                    case R.id.seekBar2:
                        text1.setText("두 번째 SeekBar Touch 종료");
                }
            }
        };

        seek1.setOnSeekBarChangeListener(listener);
        seek2.setOnSeekBarChangeListener(listener);
    }

    public void seekbtn1_onclick(View v) {
        // 증가
        seek2.incrementProgressBy(1);
    }

    public void seekbtn2_onclick(View v) {
        // 감소
        seek2.incrementProgressBy(-1);
    }

    public void seekbtn3_onclick(View v) {
        //값 세팅
        seek2.setProgress(5);
    }

    public void seekbtn4_onclick(View v) {
        // 값 가져오기
        Toast.makeText(this, seek2.getProgress() + "", Toast.LENGTH_SHORT).show();
    }
}








