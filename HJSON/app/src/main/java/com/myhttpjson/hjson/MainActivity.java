package com.myhttpjson.hjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.myhttpjson.hjson.entity.news;
import com.myhttpjson.hjson.entity.wangyinews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1;
    private TextView tv1;
    private RequestQueue queue;
    String url="http://c.m.163.com/nc/topicset/android/subscribe/manage/listspecial.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= (Button) findViewById(R.id.bt1);
        tv1 = (TextView) findViewById(R.id.tv1);
        bt1.setOnClickListener(this);
        queue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View view) {
        getDataByVolleyGet();

    }

    private void getDataByVolleyGet() {
        Response.Listener<String> success=new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                wangyinews news = gson.fromJson(s, wangyinews.class);
                wangyinews data = news.getData().get(2);
                tv1.setText(data.toString());
            }
        };
        Response.ErrorListener failed=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, "失败，没有获取到数据", Toast.LENGTH_SHORT).show();
            }
        };
        queue.add(new StringRequest(url, success, failed));
    }
    private List<news> parseJson(String s) {
        List<news> list = null;
        try {
            list = new ArrayList<>(Integer.parseInt(s));
            JSONObject obj = new JSONObject();
            String tLIST = obj.getString("tLIST");
            JSONArray array = obj.getJSONArray("array");
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    String template = jsonObject.getString("template");
                    String hasCover = jsonObject.getString("hasCover");
                    String alias = jsonObject.getString("alias");
                    String subnum = jsonObject.getString("subnum");
                    String img = jsonObject.getString("img");
                    String color = jsonObject.getString("color");
                    String tname = jsonObject.getString("tname");
                    String showType = jsonObject.getString("showType");
                    String ename = jsonObject.getString("ename");
                    int topicid = jsonObject.getInt("topicid");
                    int recommendOrder = jsonObject.getInt("recommendOrder");
                    int isNew = jsonObject.getInt("isNew");
                    int isHot = jsonObject.getInt("isHot");
                    int cid = jsonObject.getInt("cid");
                    int recommend = jsonObject.getInt("recommend");
                    int bannerOrder = jsonObject.getInt("bannerOrder");
                    int special = jsonObject.getInt("special");
                    int tid = jsonObject.getInt("tid");
                    boolean hasIcon = jsonObject.getBoolean("hasIcon");
                    list.add(new news(template,hasCover,alias,subnum,
                            img,color, tname,showType,ename,topicid,recommendOrder,
                            isNew,isHot,cid, recommend,bannerOrder,special,tid,hasIcon));
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
