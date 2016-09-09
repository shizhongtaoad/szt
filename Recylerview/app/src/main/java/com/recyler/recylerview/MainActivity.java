package com.recyler.recylerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import Adapter.RecylerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import entity.News;
import utils.vollyutil;

public class MainActivity extends AppCompatActivity {
    RecylerAdapter adapter;
@BindView(R.id.recylerview1)
    RecyclerView recylerview1;
    String url="http://118.244.212.82:9092/newsClient/news_list?ver=0&subid=1&dir=1&nid=0&stamp=20140321&cnt=20";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter=new RecylerAdapter(this);
        recylerview1.setAdapter(adapter);
        recylerview1.setLayoutManager(new LinearLayoutManager(this));
      // recylerview1.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        //recylerview1.setLayoutManager(new GridLayoutManager(this,2);
        getrecyler();

    }

    private void getrecyler() {
        Response.Listener<String> sucess=new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                News news = gson.fromJson(s, News.class);
                adapter.setList(news.getData());
                adapter.notifyDataSetChanged();
            }
        };
        Response.ErrorListener falied=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        };
        vollyutil.getInstance(this).getQueue().add(new StringRequest(url,sucess,falied));
    }
}
