package com.example.aswinawien.belajar_fragments;

import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentAnalog.OnFragmentInteractionListener,FragmentDigital.OnFragmentInteractionListener{

    private Button analogBtn, digitalBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analogBtn =(Button) findViewById(R.id.button_analog);
        analogBtn.setOnClickListener(this);
        digitalBtn = (Button)findViewById(R.id.button_digital);
        digitalBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        if(view == analogBtn){
            fragment = new FragmentAnalog();
        }else{
            fragment = new FragmentDigital();
        }
        replaceFragment(fragment);
    }
    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .add(R.id.fragment_container,fragment).addToBackStack(null).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
