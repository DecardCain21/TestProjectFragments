package layout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.marat.hvatit.testprojectfragments.IonSomeEventListener;
import com.marat.hvatit.testprojectfragments.R;

import java.util.Objects;


public class FragmentOne extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        TextView textView = view.findViewById(R.id.textView);
        Button button = view.findViewById(R.id.button);
        EditText editText = view.findViewById(R.id.eText);
        if (getArguments() != null) {
            String args = getArguments().getString("tagfrone");
            textView.setText(args);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                Activity activity = requireActivity();
                try {
                    ((IonSomeEventListener) activity).someEvent(s, false);
                } catch (Exception e) {
                    Log.e("Tag", "ERROR");
                }

            }
        });
        return view;
    }
}