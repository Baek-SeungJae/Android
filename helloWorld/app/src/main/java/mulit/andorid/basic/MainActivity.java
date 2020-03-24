package mulit.andorid.basic;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test, ","onCreate()호출");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        //onCreate() 다음으로 호출되는 메소드
        //액티비티가 실행:2 단, pause상태에서 되돌아 올 때는 start 부터 실행된다.
        super.onStart();
        Log.d("test, ","onStart()호출");
    }
    @Override
    protected void onPostResume() {
        //onStart() 다음으로 호출되는 메소드
        //액티비티가 실행:3
        super.onPostResume();
        Log.d("test, ","onResume()호출");
    }
    @Override
    protected void onPause() {
        //일시정지 상태로 바뀔 때 호출되는 메소드

        Log.d("test, ","onPause()호출");
        super.onPause();
    }
    @Override
    protected void onStop() {
        //일시정지나 종료상태로 바뀔 때 onPause()다음으로 호출되는 메소드
        super.onStop();
        Log.d("test, ","onStop()호출");
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d("test, ","onDestroy()호출");
    }

    // 버튼을 클릭했을 때 실행할 메소드를 정의
    // 메소드의 매개변수에 실행할 버튼을 정의
    // Button의 상위인 View타입으로 정의
    public void myclickMethod(View v) {
        Toast.makeText(this,"확인버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
    }
}
