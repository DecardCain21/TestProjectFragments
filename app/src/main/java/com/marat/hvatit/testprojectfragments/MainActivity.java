package com.marat.hvatit.testprojectfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.util.Objects;

import layout.FragmentOne;
import layout.FragmentTwo;

public class MainActivity extends AppCompatActivity implements IonSomeEventListener {
    FragmentTransaction ft;
    Bundle bundle = new Bundle();
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void someEvent(String somf, boolean b) {
        //вызов Менеджера для нахождения фрагмента в контейнере(по дефолту стоит фрагмент 1
        //#2
        if (b) {
            Log.e("Tag", "THIS FUCKIN B == TRUE");
        }
        if (!b) {
            Log.e("Tag", "THIS FUCKIN B == FALSE");
        }

        ft = getSupportFragmentManager().beginTransaction();
        if (b) {
            bundle.putString("tagfrone", somf);
            Fragment fragment1 = new FragmentOne();
            fragment1.setArguments(bundle);
            ft.replace(R.id.fr_place, fragment1);
        }
        if (!b) {
            bundle.putString("tagfrtwo" + (count), somf);
            Log.e("Message","tagfrtwo" + (count));
            count++;
            if (!ft.isEmpty()) {
                Fragment temp = getSupportFragmentManager().findFragmentByTag("tagfrtwo" + (count));
                ft.remove(temp);
            }
            Fragment fragment2 = new FragmentTwo();
            fragment2.setArguments(bundle);
            ft.replace(R.id.fr_place, fragment2);
            ft.addToBackStack(null);
        }

        ft.commit();
    }

}