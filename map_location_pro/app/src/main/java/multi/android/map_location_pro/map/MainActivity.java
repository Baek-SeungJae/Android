package multi.android.map_location_pro.map;
/*
**** v2로 바뀌면서 적용된 내용이므로 2016년 이전자료에는 해당되지 않는다. ****
* v2부터 마치 카메라가 내려다보듯한 형태로 모델링이 되어있다.
SupportMapFragment로 부터 지도 객체를 추출해야 지도에 여러가지 작업을 처리할 수 있다.
0. FragmentManager를 이요해서 SupportMapFragment를 find
1. OnMapReadyCallback을 구현하고 onMapReady메소드를 오버라이딩
2. SupportMapFragment 객체에 getMapAsync 메소드를 이용해서 1번에서 구현한 OnMapReadyCallback 객체를 연결
3. 맵이 준비되었을 때 자동으로 onMapReady 메소드가 호출되면서 매개변수로 구글맵이 전달된다.
 */

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import multi.android.map_location_pro.R;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener,
        GoogleMap.OnCameraMoveListener, GoogleMap.OnCameraMoveStartedListener, LocationListener
{
    LocationManager locationManager;
    Location location = null;
    List<String> provider_list;
    List<String> enableProvider_list;
    String[] permission_list = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    GoogleMap map;
    MarkerOptions markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Map프레그먼트로 부터 맵을 얻기
        //현재 xml 문서에 정의된 fargment를 추출하는 경우 FragmentManager를 이용해서 추출해야 한다.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permission_list, 1000);
        } else {
            init();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                return;
            }
        }
        init();
    }
    public void getProviders() {
        provider_list = locationManager.getAllProviders();
        enableProvider_list = locationManager.getProviders(true);
    }
    public void getLocation() {
        String provider = enableProvider_list.get(0);
            try {
                location = locationManager.getLastKnownLocation(provider);
                if (location != null) {
                    Log.d("test",provider+", "+location.getLatitude()+", "+location.getLongitude());
                    locationManager.requestLocationUpdates(provider,3000,1,this);
                } else {
                }
            } catch (SecurityException e) {
            }
    }
    public void init() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getProviders();
        getLocation();
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);
        map.setOnCameraMoveListener(this);
        map.setOnCameraMoveStartedListener(this);
        if (map != null) {
            //위도,경도지정
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            map.getUiSettings().setZoomControlsEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);
            googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker in 현재위치"));

            // 변경사항에 대한 내용을 담고 있는 객체 - CameraUpdate
            // CameraUpdate 객체에 변경할 값들을 세팅해서 매개변수로 전달하면 된다.
            // CameraUpdateFactory


            // map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

            //target() - 화면에 출력되기 위해서 특정 위치의 중앙으로 이동
            //zoom() - 지도의 확대 축소 레벨을 설정

            CameraPosition.Builder builder = new CameraPosition.Builder();
            builder.target(latLng);
            builder.zoom(15);
            CameraPosition position = builder.build();
            map.moveCamera(CameraUpdateFactory.newCameraPosition(position));

        }
    }

    public void setPosition(View view) {
        LatLng multi = new LatLng(37.501244, 127.039501);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(multi, 16));
    }

    public void setMarker(View view) {
        LatLng multi = new LatLng(37.501244, 127.039501);
        markerOptions = new MarkerOptions();
        markerOptions.position(multi);
        markerOptions.title("멀티캠퍼스");
        markerOptions.snippet("IT교육센터");
        map.addMarker(markerOptions);

    }

    public void addCircle(View view) {
        LatLng multi = new LatLng(37.501244, 127.039501);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(multi);
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(Color.GREEN);
        circleOptions.fillColor(Color.argb(100, 255, 0, 0));
        circleOptions.radius(100);
        map.addCircle(circleOptions);
    }

    public void changeMarker(View view) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.arrow);
        Bitmap bitmap = bitmapDrawable.getBitmap();

        Bitmap smallmarker = Bitmap.createScaledBitmap(bitmap, 100, 200, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallmarker));
        map.addMarker(markerOptions);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        map.clear();
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(latLng);
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(Color.GREEN);
        circleOptions.fillColor(Color.argb(100, 255, 0, 0));
        circleOptions.radius(100);
        map.addCircle(circleOptions);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        map.clear();
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(latLng);
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(Color.RED);
        circleOptions.fillColor(Color.argb(100, 255, 0, 0));
        circleOptions.radius(100);
        map.addCircle(circleOptions);
    }


    @Override
    public void onCameraMove() {
        Toast.makeText(this,"카메라가 이동됩니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCameraMoveStarted(int i) {
        Toast.makeText(this,"카메라이동이 시작됩니다.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {

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
