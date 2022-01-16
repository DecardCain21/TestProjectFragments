package layout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marat.hvatit.testprojectfragments.R;


public class FragmentOne extends Fragment {
FragmentManager fragmentManager = new FragmentManager() {
    @Override
    public FragmentTransaction beginTransaction() {
        return super.beginTransaction();
    }
};




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentOne();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fr_place,fragment);
                ft.commit();
            }
        });
        return view;
    }
}