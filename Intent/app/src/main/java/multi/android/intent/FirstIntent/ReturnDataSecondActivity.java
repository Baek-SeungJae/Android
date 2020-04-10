package multi.android.intent.FirstIntent;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.intent.R;

public class ReturnDataSecondActivity extends AppCompatActivity {
	String code;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.second);
	    Button btn = (Button)findViewById(R.id.bt2);
	    final TextView txt = findViewById(R.id.secondTxt);
		final Intent intent = getIntent();
		String msg = intent.getStringExtra("code");
		final String value = intent.getStringExtra("data");
		Toast.makeText(this,"추출한 메시지:"+msg+", 값:"+value,Toast.LENGTH_LONG).show();
		code = msg;
	    btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (code){
					case "call2":
						//String data = value;
						//txt.setText(data);
						intent.putExtra("second","두 번째 액티비티에서 실행 완료");
						//실행 후에 호출한 액티비티로 되돌아가기
						//되돌아 갈 때 값을 공유하기 위해 intent객체를 넘긴다.
						setResult(RESULT_OK,intent);
						finish();
				}
			}
		});
	}
}
