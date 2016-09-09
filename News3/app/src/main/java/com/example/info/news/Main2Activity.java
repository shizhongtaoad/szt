package com.example.info.news;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.List;

import Fragments.FavorFragment;
import Fragments.HotFragment;
import Fragments.LoginFragment;
import Fragments.NewsFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener, RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.radiogroup1)
    FavorFragment ff;
    HotFragment hf;
    LoginFragment lf;
    NewsFragment nf;
    RadioGroup radiogroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        ff = new FavorFragment();
        hf = new HotFragment();
        lf = new LoginFragment();
        nf = new NewsFragment();
        addFragment(nf);
        setListeners();

    }

    private void setListeners() {

        radiogroup1.setOnCheckedChangeListener(this);
    }

    private void addFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().add(R.id.main_content, f).commit();
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radioButton1:
                showFragment(nf);
                break;
            case R.id.radioButton2:
                break;
            case R.id.radioButton3:
                break;
            case R.id.radioButton4:
                break;
        }
    }
    private void showFragment(Fragment f) {

        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> list = fm.getFragments();
        Fragment tempFragment = null;
        if (list != null) {

            for (Fragment fragment : list) {
                if (fragment != f) {
                    //
                    fm.beginTransaction().hide(fragment).commit();
                } else {
                    tempFragment = fragment;
                }
            }
            if (tempFragment == null) {
                addFragment(f);
                tempFragment = f;
            }
            fm.beginTransaction().show(tempFragment).commit();

        }

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}