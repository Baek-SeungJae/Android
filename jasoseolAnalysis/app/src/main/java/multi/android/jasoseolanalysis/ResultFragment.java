package multi.android.jasoseolanalysis;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ResultFragment extends Fragment {
    TextView textResult;
    String content;
    public ResultFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            textResult = getActivity().findViewById(R.id.resultText);
            content = getArguments().getString("content");
            Log.d("test",content);
            //textResult.setText(content);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        textResult = getActivity().findViewById(R.id.resultText);
        return inflater.inflate(R.layout.fragment_result, container, false);
    }
}
