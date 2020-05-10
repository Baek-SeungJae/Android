package multi.android.datamanagementpro.oracle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import multi.android.datamanagementpro.R;

public class DBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

        BoardDAO dao = new BoardDAO();
        BoardDTO dto = dao.select().get(0);
        Log.d("DBTest",dto.getContents());

    }
}
