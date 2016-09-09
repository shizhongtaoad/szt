package com.myhttpjson.hjson.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.View;

import com.myhttpjson.hjson.util.LogUtil;

public abstract class BaseHolder<T> {

    private View mRootView;
    protected Context context;
    private static LruCache<String, Bitmap> ache;

    public View getmRootView() {
        return mRootView;
    }

    public BaseHolder(Context context) {
        super();
        this.context = context;
        // TODO Auto-generated constructor stub
        mRootView = initView();
        mRootView.setTag(this);
        ache = new LruCache<String, Bitmap>(5 * 1024) {
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };

    }

    public void put(String key, Bitmap value) {
        LogUtil.d(this, "保存图片");
        ache.put(key, value);
    }

    public Bitmap get(String key) {
        LogUtil.d(this, "获取图片");
        return ache.get(key);

    }

    // 初始化布局的方法，交给子类完成
    public abstract View initView();

    // 设置属性到控件的方法， 交给子类完成
    public abstract void setData(T t, boolean isFling);

}
