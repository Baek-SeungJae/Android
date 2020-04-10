package multi.android.datamanagementpro.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import multi.android.datamanagementpro.R;

public class RuntimePermissionTest extends AppCompatActivity {
    //퍼미션의 상태를 저장할 변수
    boolean permission_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission_test);
        //1. Permission을 먼저 체크
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            permission_state = true;
            Toast.makeText(this, "권한이 설정되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            permission_state = false;
            Toast.makeText(this, "권한을 설정해야합니다.", Toast.LENGTH_SHORT).show();

            //2. 권한을 설정하라는 메시지를 띄운다.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1000);
        }

    }

    //3. requestPermissions의 메시지창에서 선택한 후 호출되는 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000 && grantResults.length > 0) {
            Log.d("grant", grantResults[0] + "");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permission_state = true;
            }
        }
    }

    public void runCamera(View v) {
        if (permission_state) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        } else {
            Toast.makeText(this, "권한을 설정해야합니다.", Toast.LENGTH_SHORT).show();
            //권한을 설정할 수 있는 페이지로 자동 이동하도록 해야함
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1000);
        }
    }
}
