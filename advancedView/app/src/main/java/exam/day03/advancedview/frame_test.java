package exam.day03.advancedview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class frame_test extends AppCompatActivity implements View.OnClickListener{
    LinearLayout frSignin; // 1
    LinearLayout frSignup; // 2
    LinearLayout frDetail; // 3
    Button btnSignin;
    Button btnSignup;
    Button btnDetail;
    Button btnSignupDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);
        frSignin = findViewById(R.id.layoutsignin);
        frSignup = findViewById(R.id.layoutsignup);
        frDetail = findViewById(R.id.layoutdetail);

        btnSignin = findViewById(R.id.btnsignin);
        btnSignup = findViewById(R.id.btnsignup);
        btnDetail = findViewById(R.id.btndetail);
        btnSignupDetail = findViewById(R.id.btnsignupsubmit);

        btnSignin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        btnDetail.setOnClickListener(this);
        btnSignupDetail.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId()==R.id.btnsignin){
            viewChange(0);
        }
        else if(v.getId()==R.id.btnsignup){
            viewChange(1);
        }
        else if(v.getId()==R.id.btndetail){
            viewChange(2);
        }
        else if(v.getId()==R.id.btnsignupsubmit){
            findViewById(R.id.signupdetail).setVisibility(View.VISIBLE);
            TextView tvName=findViewById(R.id.txtSigninNameResult);
            TextView tvId=findViewById(R.id.txtSigninIdResult);
            TextView tvPass=findViewById(R.id.txtSigninPassResult);
            EditText etName = findViewById(R.id.txtSignupName);

            EditText etId = findViewById(R.id.txtSignupId);
            EditText etPass = findViewById(R.id.txtSignupPass);
            tvName.setText("Name: "+etName.getText());
            tvId.setText("ID: "+etId.getText());
            tvPass.setText("Pass: "+etPass.getText());
        }
    }
    public void viewChange(int index){
        //버튼이 클릭될 때 이미지가 교체되어 보이도록 구현
        if(index==0){
            frSignin.setVisibility(View.VISIBLE);
            frSignup.setVisibility(View.INVISIBLE);
            frDetail.setVisibility(View.INVISIBLE);
        } else if(index==1){
            frSignin.setVisibility(View.INVISIBLE);
            frSignup.setVisibility(View.VISIBLE);
            frDetail.setVisibility(View.INVISIBLE);
        } else if(index==2){
            frSignin.setVisibility(View.INVISIBLE);
            frSignup.setVisibility(View.INVISIBLE);
            frDetail.setVisibility(View.VISIBLE);
        }
    }

}
