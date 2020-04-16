package multi.android.material_design_pro.actionBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class ActionBarTest extends AppCompatActivity {
    String[] strarr = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii","jjj","kkk","lll","mmm","nnn"};
    TextView result1;
    TextView result2;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);
        listView = findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,strarr);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        result1 = findViewById(R.id.textView2);
        result2 = findViewById(R.id.textView3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드로 추가1");
        menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드로 추가2");

        //검색뷰가 셋팅되어 있는 메뉴아이템을 추출
        MenuItem searchItem = menu.findItem(R.id.search);
        //액션뷰로 설정되어 있는 뷰를 추출한다.
        SearchView searchView = (SearchView) searchItem.getActionView();
        //안내문구를 등록
        searchView.setQueryHint("검색어를 입력하세요");
        //이벤트 연결하기
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 키보드의 엔터키를 누르면 호출
            @Override
            public boolean onQueryTextSubmit(String query) {
                result1.setText(query);
                listView.setFilterText(query);
                return true;
            }
            // searchView의 텍스트가 변경될 때 호출
            @Override
            public boolean onQueryTextChange(String newText) {
                result2.setText(newText);
                if(newText.length()==0){
                    listView.clearTextFilter();
                }else{
                    listView.setFilterText(newText);
                }
                return true;
            }
        });

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            //메뉴가 펼처질 때
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                result1.setText("메뉴가 펼쳐짐");
                return true;
            }
            // 메뉴가 접힐 때
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                result1.setText("메뉴가 접혀짐");
                return true;
            }
        });
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
        result1.append(msg);
        return super.onOptionsItemSelected(item);
    }
}
