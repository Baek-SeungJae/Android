package multi.android.map_location_pro.map;
/*
**** v2로 바뀌면서 적용된 내용이므로 2016년 이전자료에는 해당되지 않는다. ****
SupportMapFragment로 부터 지도 객체를 추출해야 지도에 여러가지 작업을 처리할 수 있다.
0. FragmentManager를 이요해서 SupportMapFragment를 find
1. OnMapReadyCallback을 구현하고 onMapReady메소드를 오버라이딩
2. SupportMapFragment 객체에 getMapAsync 메소드를 이용해서 1번에서 구현한 OnMapReadyCallback 객체를 연결
3. 맵이 준비되었을 때 자동으로 onMapReady 메소드가 호출되면서 매개변수로 구글맵이 전달된다.
 */


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import multi.android.map_location_pro.R;

public class MapEventTest extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    MarkerOptions markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_event_test);
        //Map프레그먼트로 부터 맵을 얻기
        //현재 xml 문서에 정의된 fargment를 추출하는 경우 FragmentManager를 이용해서 추출해야 한다.
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if (map != null) {
            //위도,경도지정
            LatLng latLng = new LatLng(37.5858031, 126.9763605);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }
    }
}
