package multi.android.datamanagementpro.filesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class InternalFileMgr extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.fileTxt);
    }

    public void saveInternalFile(View v) {
        //내부저장소는 데이터를 저장하거나 데이터를 읽어올 때 스트림을 직접 생성하지 않는다.
        //name : 파일명,
        //mode : MODE_APPEND : 기존 파일에 추가, MODE_PRIVATE : 기존 파일을 덮어쓰겠다.
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = openFileOutput("myfile.txt", MODE_PRIVATE);
            dos = new DataOutputStream(fos);
            dos.writeUTF("테스트중...");
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public void openInternalFile(View v) {
        FileInputStream fis = null;
        DataInputStream dis = null;
        String data = "";
        try {
            fis = openFileInput("myfile.txt");
            dis = new DataInputStream(fis);
            data = dis.readUTF();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
            }
            textView.setText(data);
        }
    }
}
