package layout;

import android.app.Activity;
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


public class FragmentTwo extends Fragment {
    boolean fr2 = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        EditText editText = view.findViewById(R.id.eText2);
        TextView textView = view.findViewById(R.id.textView2);
        Button button = view.findViewById(R.id.button2);
        String args = getArguments().getString("tagfrtwo");
        textView.setText(args);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fr2 = false){
                    Log.e("Tag", "ERROR");
                }
                Log.e("Tag", "I M HERE!");
                String s = editText.getText().toString();
                Activity activity = requireActivity();
                try {
                    ((IonSomeEventListener) activity).someEvent(s,fr2);
                } catch (Exception e) {
                    Log.e("Tag", "ERROR");
                }

            }
        });
        return view;
    }
}
