package multi.android.gotchar.member;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import multi.android.gotchar.R;

public class PrivacyPolicy extends Fragment {


    public PrivacyPolicy() {
    }
    public static PrivacyPolicy newInstance(String param1, String param2) {
        PrivacyPolicy fragment = new PrivacyPolicy();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_privacy_policy, container, false);
    }
}
