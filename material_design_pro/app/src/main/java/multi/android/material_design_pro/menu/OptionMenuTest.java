package multi.android.material_design_pro.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import multi.android.material_design_pro.R;

public class OptionMenuTest extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_test);
        tv = findViewById(R.id.result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드로 추가1");
        menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드로 추가2");
        return true;
    }

    // 옵션 메뉴의 아이템을 선택하면 자동으로 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        tv.setText(item.getTitle().toString());
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
        tv.append(msg);
        return super.onOptionsItemSelected(item);
    }
}
