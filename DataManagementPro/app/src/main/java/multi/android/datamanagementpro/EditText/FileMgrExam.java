package multi.android.datamanagementpro.EditText;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import multi.android.datamanagementpro.R;

public class FileMgrExam extends AppCompatActivity {
    boolean[] fs_permission_state = new boolean[2]; //0은쓰기, 1은 읽기
    Date currentTime = Calendar.getInstance().getTime();
    String date_text = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(currentTime);
    String filename = "/"+date_text+"_memo.txt";
    EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_mgr_exam);
        content = findViewById(R.id.file_content);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            fs_permission_state[0] = true;
        } else {
            fs_permission_state[0] = false;
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            fs_permission_state[1] = true;
        } else {
            fs_permission_state[1] = false;
        }
    }

    public void fileOpen(View v) {
        Log.d("open", fs_permission_state[1] + "");
        if (fs_permission_state[1]) {
            Toast.makeText(this, "파일열기 권한설정완료", Toast.LENGTH_SHORT).show();
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                File external = Environment.getExternalStorageDirectory();
                String dirPath = "/sdcard/mynote";
                try {
                    FileReader fr = new FileReader(dirPath + filename);
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    content.setText("");
                    while ((line = br.readLine()) != null) {
                        content.append(line + "\n");
                    }
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        } else {
            Toast.makeText(this, "파일열기 권한설정하세요.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2000);
        }
    }

    public void fsave(View v) {
        Log.d("save", fs_permission_state[0] + "");
        if (fs_permission_state[0]) {
            Toast.makeText(this, "파일쓰기 권한설정완료", Toast.LENGTH_SHORT).show();
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                File external = Environment.getExternalStorageDirectory();
                String dirPath = "/sdcard/mynote";
                File dir = new File(dirPath);
                Log.d("test", dirPath);
                dir.mkdir();
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir + filename);
                    fw.write(content.getText().toString());
                } catch (IOException e) {
                } finally {
                    try {
                        if (fw != null) {
                            fw.close();
                        }
                    } catch (IOException e) {
                    }
                }
            } else {
                Toast.makeText(this, "파일쓰기 권한설정하세요.", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
            }
        }
    }

    public void newfile(View v) {
        content.setText("");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("requestCode", requestCode + "");
        if (requestCode == 1000 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fs_permission_state[0] = true;
            }
        } else if (requestCode == 2000 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fs_permission_state[1] = true;
            }
        }
    }
}
