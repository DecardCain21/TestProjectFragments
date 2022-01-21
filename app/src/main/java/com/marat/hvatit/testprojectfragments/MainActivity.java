package com.marat.hvatit.testprojectfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import layout.FragmentOne;
import layout.FragmentTwo;

public class MainActivity extends AppCompatActivity implements FragmentOne.IonSomeEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void someEvent(String somf) {
        //вызов Менеджера для нахождения фрагмента в контейнере(по дефолту стоит фрагмент 1
        //#2
        Bundle bundle = new Bundle();
        FragmentTransaction ft;
        if(bundle.containsKey("tagfrtwo")||bundle.isEmpty()){
            Log.e("TAG", "This is fuckin work dudeeee2");
            bundle.putString("tagfrone", somf);
            Fragment fragment1 = new FragmentOne();
            fragment1.setArguments(bundle);
            ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack(null);
            ft.replace(R.id.fr_place, fragment1);
            ft.commit();
            bundle.remove("tagfrtwo");
        }
        if (bundle.containsKey("tagfrone")) {
            Log.e("TAG", "This is fuckin work dudeeee1");
            bundle.putString("tagfrtwo", somf);
            Fragment fragment2 = new FragmentTwo();
            fragment2.setArguments(bundle);
            ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack(null);
            ft.replace(R.id.fr_place, fragment2);
            ft.commit();
            bundle.remove("tagfrone");
        }
    }

}