package multi.android.material_design_pro.appbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class AppbarTest extends AppCompatActivity {
    Toolbar toolbar;
    ImageView app_bar_image;
    CollapsingToolbarLayout toolbarLayout;
    FloatingActionButton fab;
    ListView listView;
    ArrayList<String> datalist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_test);
        // 리소스 연결
        toolbar = findViewById(R.id.toolbar);
        app_bar_image = findViewById(R.id.app_bar_image);
        toolbarLayout = findViewById(R.id.toolbarLayout);
        fab = findViewById(R.id.fab);
        listView = findViewById(R.id.listview);

        // 어댑터 연결
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datalist);
        listView.setAdapter(adapter);

        // 앱바 이미지 변경
        app_bar_image.setImageResource(R.drawable.lee);

        // 앱바에 텍스트 추가, 변경
        toolbar.setTitle("툴바입니다.");
        toolbarLayout.setCollapsedTitleTextColor(Color.CYAN);
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
        toolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);
        toolbarLayout.setExpandedTitleGravity(Gravity.RIGHT + Gravity.TOP);

        // 플로팅 액션 버튼을 눌렀을 때
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppbarTest.this);
                //AlertDialog의 제목을 정의
                builder.setTitle("데이터입력");
                //AlertDialog의 화면을 inflate
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.input,null);
                builder.setPositiveButton("확인",new DialogListener());
                builder.setNegativeButton("취소",null);
                builder.setView(dialogView);
                builder.show();
            }
        });
    }
    class DialogListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //AlertDialog에서 입력하는 내용을 ListView에 추가
            AlertDialog inputAlert = (AlertDialog) dialog;
            EditText input = inputAlert.findViewById(R.id.input);
            String data = input.getText().toString();
            datalist.add(data);
            Log.d("datainput",data);
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }
}
