package exam.day03.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// 이벤트를 발생시킬 소스가 있는 액티비티에서 이벤트를 처리하는 작업도 같이 할 수 있도록 구현
// 1. 이벤트에 반응하는(미리 정해져 있음) 클래스를 상속받는다.
// 2. 메소드를 오버라이딩 한다.
//  ex) 버튼을 클릭할 때 실행될 리스너 => View.OnClickListener의 OnClick메소드가 호출
public class Challenge03 extends AppCompatActivity implements View.OnClickListener {
    ImageView img01;
    ImageView img02;
    Button btn01;
    Button btn02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge03);

        //layout에 디자인한 ImageView와 Button 찾아오기
        img01 = findViewById(R.id.image01);
        img02 = findViewById(R.id.image02);
        btn01 = findViewById(R.id.button1);
        btn02 = findViewById(R.id.button2);

        //setOnClickListener라는 메소드를 이용해서 이벤트소스에 이벤트가 발생했을 때
        // 처리할 기능이 구현된 리스너객체가 어떤 것인지 등록
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.d("myevent","이벤트가 발생되었습니다. -이벤트 처리합니다.");
        if(v==btn02)
            imageDown();
        if(v.getId()==R.id.button1)
            imageUp();
    }
    public void imageDown(){
        //ImageView에 이미지리소스를 추가
        img02.setImageResource(R.drawable.beach);
        //setImageResource메소드를 이용해서 이미지를 변경했다고 하더라도 화면이 자동으로 갱신되지 않음
        img01.setImageResource(0);
        img01.invalidate();
        img02.invalidate();
    }
    public void imageUp(){
        //ImageView에 이미지리소스를 추가
        img01.setImageResource(R.drawable.beach);
        //setImageResource메소드를 이용해서 이미지를 변경했다고 하더라도 화면이 자동으로 갱신되지 않음
        img02.setImageResource(0);
        img01.invalidate();
        img02.invalidate();
    }
}
