package com.myhttp.http;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    // private String url = "http://118.244.212.82:9092/newsClient/news_list?ver=0&subid=1&dir=1&nid=0&stamp=20140321&cnt=20";

    @BindView(R.id.imageView)

    ImageView imageView;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        requestQueue = Volley.newRequestQueue(this);
    }

    @OnClick(R.id.bt1)
    public void htclick(View v) {
        //  getvolly();

        getpost();

    }
    //    private void getvolly() {
    //        Response.Listener<String> success=new Response.Listener<String>() {
    //            @Override
    //            public void onResponse(String s) {
    //                tv1.setText(s);
    //            }
    //        };
    //        Response.ErrorListener faled=new Response.ErrorListener()  {         @Override
    //            public void onErrorResponse(VolleyError volleyError) {
    //                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
    //            }
    //        };
    //        requestQueue.add(new StringRequest(url,success,faled));


    private void getpost() {
        // https://ps.ssl.qhimg.com/sdmt/180_135_100/t01f19bc25fe2eb1895.jpg
        String url = "https://ps.ssl.qhimg.com/sdmt/180_135_100/t01f19bc25fe2eb1895.jpg";
        //        Response.Listener<String> success=new Response.Listener<String>() {
        //            @Override
        //            public void onResponse(String s) {
        //                tv1.setText(s);
        //            }
        //        };
        //        Response.ErrorListener faled=new Response.ErrorListener() {
        //            @Override
        //            public void onErrorResponse(VolleyError volleyError) {
        //                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
        //            }
        //        };
        final HashMap<String, String> map = new HashMap<>();
        map.put("ver", "0");
        map.put("subid", "1");
        map.put("dir", "1");
        map.put("nid", "0");
        map.put("stamp", "20140321");
        map.put("cnt", "20");

        int m = new Byte(url);
        int h = new Byte(url);
        Bitmap.Config config = Bitmap.Config.ALPHA_8;
        Response.ErrorListener falied=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        };
        Response.Listener<Bitmap> sucess=new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        };
        Request add = requestQueue.add(new ImageRequest( url,sucess, m, h, config, falied) {
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        });
    }
}


