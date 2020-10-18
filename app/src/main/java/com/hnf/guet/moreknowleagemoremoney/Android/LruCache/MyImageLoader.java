package com.hnf.guet.moreknowleagemoremoney.Android.LruCache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Lrccache图片缓存框架
 * Created by SNOW on 2020/8/25.
 */
public class MyImageLoader {

    private LruCache<String, Bitmap> mLrucache;

    public MyImageLoader(){
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        //设置缓存控件为运行内存的八分之一
        int cacheSize = maxMemory /8;

        mLrucache = new LruCache<>(cacheSize);
    }

    /**
     * 添加图片到缓存中
     * @param key
     * @param bitmap
     */
    public void addBitmap(String key,Bitmap bitmap){
        if (getBitmap(key) == null){
            mLrucache.put(key,bitmap);
        }
    }

    /**
     * 从缓存中读取图片
     * @param key
     * @return
     */
    public Bitmap getBitmap(String key){
        return mLrucache.get(key);
    }

    /**
     * 从缓存中删除指定的bitmap
     * @param key
     */
    public void removeBitmapByKey(String key){
        mLrucache.remove(key);
    }
}
