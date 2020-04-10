package multi.android.intent.ExamIntent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import multi.android.intent.R;

public class ExamFirstActivity extends AppCompatActivity {
    public static final int SECOND_ACTIVTIY = 10;
    EditText editTextName;
    EditText editTextTel;
    TextView first_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        Button btn = findViewById(R.id.Button01);
        editTextName = findViewById(R.id.EditText01);
        editTextTel = findViewById(R.id.EditText02);
        first_return = findViewById(R.id.first_return);
    }
    public void firstExamClickBtn(View v){
        Intent intent = new Intent(this, ExamSecondActivity.class);
        intent.putExtra("name",editTextName.getText().toString());
        intent.putExtra("tel",editTextTel.getText().toString());
        first_return.setText("");
        startActivityForResult(intent, SECOND_ACTIVTIY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SECOND_ACTIVTIY){
            if(resultCode==RESULT_OK){
                first_return.setText("우수회원설정");
                editTextName.setText(data.getStringExtra("name2"));
                editTextTel.setText(data.getStringExtra("tel2"));
            }
        }
    }
}
