package com.example.frat.fra;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class LeftFragment extends Fragment  implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText ed_text;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentActionListener fragmentActionListener;

    public LeftFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static LeftFragment newInstance(String param1, String param2) {
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lankfrag, null);
        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ed_text = (EditText) view.findViewById(R.id.ed_text);
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
        view.findViewById(R.id.btn3).setOnClickListener(this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentActionListener) {
            fragmentActionListener = (FragmentActionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement fragmentActionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentActionListener = null;
    }

    @Override
    public void onClick(View v) {
        String text = ed_text.getText().toString();
        if (fragmentActionListener != null) {
            Bundle buddle = new Bundle();
            buddle.putString("text", text);
            fragmentActionListener.onButtonPressed(v.getId(), buddle);
        }
    }

    public interface FragmentActionListener {
        // TODO: Update argument type and name
        void onButtonPressed(int viewId, Bundle bundle);
    }
}
