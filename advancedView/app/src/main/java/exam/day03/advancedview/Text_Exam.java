package exam.day03.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Text_Exam extends AppCompatActivity {
    TextView txtoutput;
    EditText txtinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_exam);
        txtinput=findViewById(R.id.textinput);
        txtoutput=findViewById(R.id.textoutput);

        txtinput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String msg = txtinput.getText()+"";
                    txtoutput.append(msg);
                    return true;
                }
                return false;
            }
        });
        Button btn = findViewById(R.id.btnsubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = txtinput.getText()+"";
                txtoutput.append(msg);
            }
        });
    }
}
