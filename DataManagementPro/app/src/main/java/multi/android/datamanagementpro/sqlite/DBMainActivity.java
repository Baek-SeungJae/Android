package multi.android.datamanagementpro.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.datamanagementpro.R;

//SQL문을 이용해서 작업 - SQL문을 문자열로 표현
public class DBMainActivity extends AppCompatActivity {
    EditText id;
    EditText name;
    EditText age;
    TextView result;
    DBHelper dbHelper ;
    SQLiteDatabase db ; //로컬 db 연동을 위한 핵심 클래스
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbjob_main);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        result = findViewById(R.id.result);

        // 1. DBHelper 생성
        dbHelper = new DBHelper(this);
        // 2. SQLiteDatabase 객체생성
        db = dbHelper.getWritableDatabase();

    }
    public void insert(View v){
        String sql = "insert into " + "member(id,name,age) " + "values(?,?,?)";
        db.execSQL(sql,new String[]{id.getText().toString(), name.getText().toString(), age.getText().toString()});
        Toast.makeText(this, "삽입성공",Toast.LENGTH_SHORT).show();
    }
    public void selectAll(View v){
        String sql = "select * from member";
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount(); // 레코드 갯수를 반환
        Toast.makeText(this,"조회된 row: "+count,Toast.LENGTH_SHORT).show();
        result.setText("");
        while(cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String name = cursor.getString(2);
            int age = cursor.getInt(3);
            result.append(idx+"\t\t"+id+ "\t\t"+name+"\t\t"+age+"\n");
        }
    }
    public void update(View v){
        String sql = "update member set age=? where id=?";
        db.execSQL(sql,new String[]{age.getText().toString(), id.getText().toString()});
    }
    public void delete(View v){
        String sql = "delete from member where id=?";
        db.execSQL(sql,new String[]{id.getText().toString()});
    }
    public void search(View v){
        String sql = "select * from member where id=?";
        Cursor cursor = db.rawQuery(sql,new String[]{id.getText().toString()});
        result.setText("");
        while(cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String name = cursor.getString(2);
            int age = cursor.getInt(3);
            result.append(idx+"\t\t"+id+ "\t\t"+name+"\t\t"+age+"\n");
        }
    }
}
