package multi.android.datamanagementpro.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.datamanagementpro.R;

// ContentValues라는 값을 관리하는 객체를 이용해서 안드로이드의 메소드를 통해 SQL문이 실행될 수 있도록 작업
// 메소드를 호출하며 적절한 값을 넘겨주면 안드로이드 OS에서 SQL문을 만들어 실행
//
public class DBMainActivity_ContentValues extends AppCompatActivity {
    EditText id;
    EditText name;
    EditText age;
    TextView result;
    DBHelper dbHelper;
    SQLiteDatabase db; //로컬 db 연동을 위한 핵심 클래스

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

    public void insert(View v) {
        //컬럼에 저장할 값을 관리하는 ContentValues를 이용
        //Map구조
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id.getText().toString());
        contentValues.put("name", name.getText().toString());
        contentValues.put("age", age.getText().toString());
        db.insert("member", null, contentValues);
        Toast.makeText(this, "ContentValues 삽입성공", Toast.LENGTH_SHORT).show();
    }

    public void selectAll(View v) {
        Cursor cursor = db.query("member", new String[]{"idx","id", "name", "age"}, null, null, null, null, null);
        int count = cursor.getCount(); // 레코드 갯수를 반환
        Toast.makeText(this, "조회된 row: " + count, Toast.LENGTH_SHORT).show();
        result.setText("");
        while (cursor.moveToNext()) {
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String name = cursor.getString(2);
            int age = cursor.getInt(3);
            result.append(idx + "\t\t" + id + "\t\t" + name + "\t\t" + age + "\n");
        }
    }

    public void update(View v) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("age",age.getText().toString());
        db.update("member",contentValues,"id=?",new String[]{id.getText().toString()});
    }

    public void delete(View v) {
        db.delete("member","id=?",new String[]{id.getText().toString()});
    }

    public void search(View v) {
        String sql = "select * from member where id=?";
        Cursor cursor = db.rawQuery(sql, new String[]{id.getText().toString()});
        result.setText("");
        while (cursor.moveToNext()) {
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String name = cursor.getString(2);
            int age = cursor.getInt(3);
            result.append(idx + "\t\t" + id + "\t\t" + name + "\t\t" + age + "\n");
        }
    }
}
