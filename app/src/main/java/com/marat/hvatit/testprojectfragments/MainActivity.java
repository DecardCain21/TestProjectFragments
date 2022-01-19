package com.marat.hvatit.testprojectfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import layout.FragmentOne;

public class MainActivity extends AppCompatActivity implements FragmentOne.onSomeEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment1 = new FragmentOne();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fr_place,fragment1);
        ft.commit();
    }

    @Override
    public void someEvent(String somf) {
        Log.e("TAG","someEvent in Activity");
        Fragment frag1 = getSupportFragmentManager().findFragmentById(R.id.fr_place);
        ((TextView)frag1.getView().findViewById(R.id.textView)).setText("chlen:"+somf);
    }
}