package com.example.fragment.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;
    @BindView(R.id.button5)
    Button mButton5;
    @BindView(R.id.button6)
    Button mButton6;
    @BindView(R.id.button7)
    Button mButton7;
    @BindView(R.id.button8)
    Button mButton8;
    FragmentManager fm;
    Fragment1 f1;
    Fragment2 f2;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        f1 = new Fragment1();
        f2 = new Fragment2();

    }

    @OnClick({R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                ft = fm.beginTransaction();
                ft.add(R.id.frag, f1).commit();
                break;
            case R.id.button4:
                ft = fm.beginTransaction();
                ft.add(R.id.frag, f2).commit();
                break;
            case R.id.button5:
                ft = fm.beginTransaction();
                ft.remove(f1).commit();
                break;
            case R.id.button6:
                ft = fm.beginTransaction();
                ft.remove(f2).commit();

                break;
            case R.id.button7:
                ft = fm.beginTransaction();
                ft.replace(R.id.frag,f2).commit();
                break;
            case R.id.button8:
                ft = fm.beginTransaction();
                ft.hide(f1).commit();
                break;
        }
    }
}
