package multi.android.support_lib.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class view3 extends Fragment {

    public view3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view3,container,false);
    }
}
