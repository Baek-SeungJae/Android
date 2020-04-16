package multi.android.material_design_pro.exam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragmentTest extends ListFragment {

    public ListFragmentTest() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] data = {"H", "He", "Li", "Be", "B", "C", "N", "O", "Al", "Si", "P", "S", "Fl", "Ne", "Na", "Mg", "Cl", "Al", "K", "Ca"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);
    }
}
