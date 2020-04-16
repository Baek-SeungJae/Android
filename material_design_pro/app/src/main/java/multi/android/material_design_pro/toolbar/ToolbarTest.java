package multi.android.material_design_pro.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import multi.android.material_design_pro.R;

/*
Toolbar는 find해서 사용해야 하며, 직접 만든 디자인을 연결할 수 있다.

 */
public class ToolbarTest extends AppCompatActivity {
    TextView result;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test);
        result = findViewById(R.id.result);
        toolbar = findViewById(R.id.toolbar);

        //액션바 대신 툴바를 사용하겠다고 정의
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드로 추가1");
        menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드로 추가2");

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String msg="";
        switch (id) {
            case R.id.option1:
                msg = "1번";
                break;
            case R.id.option2:
                msg = "2번";
                break;
            case R.id.option2_1:
                msg = "2-1번";
                break;
            case R.id.option2_2:
                msg = "2-2번";
                break;
            case R.id.option3:
                msg = "3번";
                break;
            case Menu.FIRST:
                msg = "메뉴로추가 1번";
                break;
            case Menu.FIRST+1:
                msg = "메뉴로추가 1+1번";
                break;
        }
        result.append(msg);
        return super.onOptionsItemSelected(item);
    }
}