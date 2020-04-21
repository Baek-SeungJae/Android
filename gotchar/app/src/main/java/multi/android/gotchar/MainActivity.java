package multi.android.gotchar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.auth.ApiErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;

import multi.android.gotchar.member.PrivacyPolicy;
import multi.android.gotchar.member.login.LoginActivity;
import multi.android.gotchar.member.login.MemberInfo;

public class MainActivity extends AppCompatActivity {
    public MemberInfo v1 = new MemberInfo();
    public PrivacyPolicy v2 = new PrivacyPolicy();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();

        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle(1);
        bundle.putString("strName",intent.getStringExtra("name"));
        bundle.putString("strProfile",intent.getStringExtra("profile"));
        bundle.putString("strEmail",intent.getStringExtra("email"));
        bundle.putString("strAgeRange",intent.getStringExtra("ageRange"));
        bundle.putString("strGender",intent.getStringExtra("gender"));
        bundle.putString("strBirthday",intent.getStringExtra("birthday"));
        v1.setArguments(bundle);

        /*
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, v1);
        transaction.commit();
        */
    }
    public void privacypolicy(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, v2);
        transaction.addToBackStack("v2");
        transaction.commit();

    }

}
