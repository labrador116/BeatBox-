package com.example.sbt_markin_aa.beatbox.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.sbt_markin_aa.beatbox.R;


public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment= fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment==null){
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }
}
