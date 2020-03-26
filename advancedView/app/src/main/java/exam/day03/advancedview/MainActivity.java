package exam.day03.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img01;
    ImageView img02;
    int index=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img01 = findViewById(R.id.img01);
        img02 = findViewById(R.id.img02);
    }
    public void myclick(View v){
        //버튼이 클릭될 때 호출되는 메소드
        imageChange();
    }

    public void imageChange(){
        //버튼이 클릭될 때 이미지가 교체되어 보이도록 구현
        if(index==0){
            img01.setVisibility(View.VISIBLE);
            img02.setVisibility(View.INVISIBLE);
            Log.d("value","현재index값:"+index);
            index++;
        } else if(index==1){
            img01.setVisibility(View.INVISIBLE);
            img02.setVisibility(View.VISIBLE);
            Log.d("value","현재index값:"+index);
            index++;
        }
        if(index>1){
            index=0;
        }

    }
}
