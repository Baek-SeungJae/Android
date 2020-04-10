package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BasicAppRun extends AppCompatActivity {
    String[] permission_list = {
            Manifest.permission.CALL_PHONE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_app_run);

        //권한체크 메소드를 호출
        runPermission();
    }

    public void runGoogleMap(View v) {
        Uri uri = Uri.parse("geo:37.5012,127.0394");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public void runChrome(View v) {
        Uri uri = Uri.parse("https://www.naver.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void runDial(View v) {
        Uri uri = Uri.parse("tel:00000000");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void runCall(View v) {
        //전화를 걸려면 권한을 체크해야 한다. 필요하면 승인처리까지
        Intent intent = null;
        int chk = PermissionChecker.checkSelfPermission(this,Manifest.permission.CALL_PHONE);
        if(chk==PackageManager.PERMISSION_GRANTED) {
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5554"));
            startActivity(intent);
            Log.d("chk","성공");
        }
        else{
            Log.d("chk","실패");
            return;
        }
    }

    public void runPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        //모든 권한을 셀프 체크
        for (String permission : permission_list) {
            int chk = checkCallingOrSelfPermission(permission);
            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list,0);
                break;
            }
        }
    }
}
