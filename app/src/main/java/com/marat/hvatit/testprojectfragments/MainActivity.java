package com.marat.hvatit.testprojectfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;


import layout.FragmentOne;
import layout.FragmentTwo;
import layout.FragmentType;

public class MainActivity extends AppCompatActivity implements IonSomeEventListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment first = new FragmentOne();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_place, first)
                .addToBackStack("StackOne")
                .commit();

    }


    @Override
    public void someEvent(String somf, FragmentType type) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            Log.e("BackStack:", "Clear backstack!");
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
                getSupportFragmentManager().popBackStack();
            }
        }
        Fragment current;
        Bundle bundle = new Bundle();
        if (type == FragmentType.FRAGMENT_TWO) {
            bundle.putString("tagfrone", somf);
            current = new FragmentOne();
        } else {
            bundle.putString("tagfrtwo", somf);
            current = new FragmentTwo();
        }
        current.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_place, current)
                .addToBackStack("StackOne")
                .commit();

        Log.e("BackStack:", Integer.toString(getSupportFragmentManager().getBackStackEntryCount()));
    }

}