package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {
    boolean[] fs_permission_state = new boolean[2]; // 0은 쓰기, 1은 읽기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);
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

    public void saveExternalFileSystem(View v) {
        Log.d("save", fs_permission_state[0] + "");
        if (fs_permission_state[0]) {
            Toast.makeText(this, "파일쓰기 권한설정완료", Toast.LENGTH_SHORT).show();
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                //사용가능
                File external = Environment.getExternalStorageDirectory();
                //외부저장소/임의의 디렉토리 생성 - 앱을 삭제해도 데이터는 남아있다.
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성하면 앱을 삭제할 때 같이 삭제된다.
                String dirPath = external.getAbsolutePath() + "myApp";
                File dir = new File(dirPath);
                Log.d("test",dirPath);
                //디렉토리가 없으면 생성
                if (dir.exists()) {
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir + "test1.txt");
                    fw.write("외부저장소 테스트중");
                } catch (IOException e) {
                } finally {
                    try {
                        if (fw != null) {
                            fw.close();
                        }
                    } catch (IOException e) {
                    }
                }

            }
        } else {
            Toast.makeText(this, "파일쓰기 권한설정하세요.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }
    }

    public void openExternalFileSystem(View v) {
        Log.d("open", fs_permission_state[1] + "");
        if (fs_permission_state[1]) {
            Toast.makeText(this, "파일열기 권한설정완료", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "파일열기 권한설정하세요.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2000);
        }
    }
}
