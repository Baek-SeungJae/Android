package multi.android.map_location_pro.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import multi.android.map_location_pro.R;

// 위치정보를 가져오는 방법 -두 가지 제공
// 표준 방법 - LocationManager를 통해 가져오기
// 위치 정보를 제공하는 객체의 종류와 현재 사용할 수 있는 위치 정보 제공자를 확인

// (GPS, NETWORK 모듈을 함께 호출해서 먼저 받아지는 Provider를 사용

public class BasicLocationTest2 extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    TextView result;
    boolean permission_state;
    List<String> provider_list;
    List<String> enableProvider_list;
    Location location = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_location_test);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        result = findViewById(R.id.result);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            permission_state = true;
            Toast.makeText(this, "권한을 설정해야합니다.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);

        } else {
            permission_state = false;
            Toast.makeText(this, "권한이 설정되었습니다.", Toast.LENGTH_SHORT).show();
            getProviders();
            getLocation();
        }

        //startLocationService();
    }

    // 전체 위치제공자 객체목록과 사용가능한 객체 목록을 출력
    public void getProviders() {
        String msg = "모든 provider list...";
        provider_list = locationManager.getAllProviders();
        for (String provider : provider_list) {
            msg = msg + "\n" + provider + "\n";
        }

        //사용가능한 목록
        msg = msg + "사용 가능한 목록....\n";
        enableProvider_list = locationManager.getProviders(true);
        for (String provider : enableProvider_list) {
            msg = msg + "\n" + provider + "\n";
        }
        result.append(msg);
    }

    public void getLocation() {
        for (String provider : enableProvider_list) {

            try {
                location = locationManager.getLastKnownLocation(provider);
                if (location != null) {
                    //위치정보
                    printInfo(provider, location);
                    Log.d("msg", provider + "성공");
                    locationManager.requestLocationUpdates(provider,3000,1,this);
                } else {
                    Log.d("msg", provider + "실패");
                }

            } catch (SecurityException e) {
                Log.d("msg", e.getMessage());
            }
        }
    }

    public void printInfo(String provider, Location location) {
        if (location != null) {
            result.append(provider + "\n" + location.getLatitude() + "\n" + location.getLongitude() + "\n");
            Date date = new Date(location.getTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
            result.append("시간: " + simpleDateFormat.format((date)) + "\n");
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000 && grantResults.length > 0) {
            Log.d("msg", grantResults[0] + "");
            Log.d("msg", grantResults[1] + "");
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                permission_state = true;
            }
        }
    }

    public void startLocationService() {

        //위치정보를 제공하는 제공자로부터 위치정보를 담고 있는 Location 객체를 가져오기
        try {
            //Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                double latitude = location.getLatitude();
                double longtitude = location.getLongitude();
            }
        } catch (SecurityException e) {
            Log.d("msg", e.getMessage());
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        String provider = location.getProvider();
        printInfo(provider, location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
