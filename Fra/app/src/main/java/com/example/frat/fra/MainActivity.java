package com.example.frat.fra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.frat.fra.dummy.RightFragment;

public class MainActivity extends AppCompatActivity implements LeftFragment.FragmentActionListener {
    LeftFragment left;
    RightFragment right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = new LeftFragment();
        right = new RightFragment();
        addFragment(R.id.left_content, left, "left");
        addFragment(R.id.right_content, right, "right");
    }

    public void addFragment(int containnerId, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().add(containnerId, fragment, tag).commit();
    }

    @Override
    public void onButtonPressed(int viewId, Bundle bundle) {
        switch (viewId) {
            case R.id.btn1:
                String str = null;
                if (bundle != null) {
                    str = bundle.getString("text");
                    right.setText1(str);
                }

                break;
            case R.id.btn2:
                if (bundle != null) {
                    str = bundle.getString("text");
                    right.setText2(str);
                }
                break;
            case R.id.btn3:
                break;
        }
    }
}

