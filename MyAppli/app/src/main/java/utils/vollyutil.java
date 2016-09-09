package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/8/29.
 */
public class vollyutil {
    private Context context;
    private static vollyutil util;
    private RequestQueue queue;
    private BitmapCache bitmapCache;
    public vollyutil(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
        bitmapCache=new BitmapCache();
    }

    public static vollyutil getInstance(Context context) {
        if (util == null) {
            synchronized (context) {
                if (util == null) {
                    util = new vollyutil(context);
                }
            }
        }
        return util;
    }
    public RequestQueue getQueue() {
        return queue;
    }
    public ImageLoader getLoader() {
        return new ImageLoader(queue, bitmapCache);
    }
    public static class BitmapCache implements ImageLoader.ImageCache {
        private LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(5 * 1024 * 1024) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
        @Override
        public Bitmap getBitmap(String s) {
            return lruCache.get(s);
        }

        @Override
        public void putBitmap(String s, Bitmap bitmap) {
            lruCache.put(s,bitmap);
        }
    }
}
