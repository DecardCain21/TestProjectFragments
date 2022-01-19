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

import com.marat.hvatit.testprojectfragments.R;

import java.util.Objects;


public class FragmentOne extends Fragment {

    public interface onSomeEventListener {
        void someEvent(String s);
    }

    onSomeEventListener someEventListener;

    /*@Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (getActivity().getSupportFragmentManager() != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
    }*/


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("TAG","ONATACH");
        try {
            Activity activity = (Activity) context;
            someEventListener = (onSomeEventListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(requireActivity().toString()+"Shiiieeeet");
        }
    }


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
                Log.e("TAG","someEvent in Fragment1");
                someEventListener.someEvent("Chlen");
            }
        });
        return view;
    }
}