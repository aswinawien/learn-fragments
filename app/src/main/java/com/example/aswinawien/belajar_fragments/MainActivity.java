package com.example.aswinawien.belajar_fragments;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;
        int id = item.getItemId();
        switch (id){
            case R.id.menu_date:
                startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                break;
            case R.id.menu_location:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                break;
            case R.id.menu_sleep:
                startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
