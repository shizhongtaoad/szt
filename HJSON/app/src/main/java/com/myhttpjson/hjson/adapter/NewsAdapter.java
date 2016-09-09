package com.myhttpjson.hjson.adapter;

import android.content.Context;

import com.myhttpjson.hjson.base.BaseHolder;
import com.myhttpjson.hjson.base.MyBaseAdapter;
import com.myhttpjson.hjson.holder.NewsHolder;

/**
 * Created by Administrator on 2016/8/26.
 */
public class NewsAdapter extends MyBaseAdapter {
    @Override
    public BaseHolder getHolder(Context context) {
        return new NewsHolder(context);
    }
}
