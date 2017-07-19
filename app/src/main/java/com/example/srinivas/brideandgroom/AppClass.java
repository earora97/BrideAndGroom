package com.example.srinivas.brideandgroom;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.srinivas.brideandgroom.utility.SessionManager;

/**
 * Created by root on 9/2/17.
 */

public class AppClass extends Application {

    private ImageLoader mImageLoader;
    LruBitmapCache mLruBitmapCache;
    private static AppClass mInstance;

    public static final String TAG = AppClass.class.getSimpleName();
    private RequestQueue mRequestQueue;
    public static SessionManager session;

    public SessionManager getSession() {
        session = new SessionManager(getApplicationContext());
        return session;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    /**
     * This Method is used for adding the Request to High Priorit Request pool
     * @param req is a Request type
     * @param <T> it retruns based on the Request Type
     */
    public <T> void addToRequestQueuePriority(Request<T> req) {
        req.setTag(TAG);
        Request.Priority pr = req.getPriority();
        pr = Request.Priority.HIGH;
        getRequestQueue().add(req);
//        Toast.makeText(context, "addToRequestQueuePriority>" + getDropXRequestQueue().getSequenceNumber() + "", Toast.LENGTH_SHORT).show();
    }

    /**
     * This Method is used for adding the RequestQueue to the volley Library.
     * @return
     */

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public static synchronized AppClass getInstance() {
        return mInstance;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            getLruBitmapCache();
            mImageLoader = new ImageLoader(this.mRequestQueue, mLruBitmapCache);
        }

        return this.mImageLoader;
    }

    public LruBitmapCache getLruBitmapCache() {
        if (mLruBitmapCache == null)
            mLruBitmapCache = new LruBitmapCache();
        return this.mLruBitmapCache;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
