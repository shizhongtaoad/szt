package com.example.frat.fra.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.frat.fra.R;

/**
 * Created by Administrator on 2016/8/30.
 */
public class RightFragment  extends Fragment {
    TextView tv_text;
    TextView tv_text2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item, null);

        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tv_text = (TextView) view.findViewById(R.id.tv_text);
        tv_text2 = (TextView) view.findViewById(R.id.tv_text2);
    }


    public void setText1(String str) {
        tv_text.setText(str);
    }

    public void setText2(String str) {
        tv_text2.setText(str);
    }
}
