package com.example.srinivas.brideandgroom.network;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.srinivas.brideandgroom.AppClass;
import com.example.srinivas.brideandgroom.utility.Display;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Random;


public class JsonRequester {
    Context con, con11;
    public static final String TAG = JsonRequester.class.getSimpleName();
    TaskListner listen = null;
    private static RequestQueue mRequestQueue;
    private static RequestQueue mRequestQueuePrioty;
    private static final String UNICODE_FORMAT = "UTF8";
    public JsonRequester(TaskListner con1, Context applicationContext) {
        try {
            try {
                con = (Context) con1;
            }catch (Exception e){ }
            con11 = applicationContext;
//            mRequestQueue = Volley.newRequestQueue(con11);
//            mRequestQueue = ((DropXLib) con).getDropXRequestQueue();
        }catch (Exception e){
            e.printStackTrace();
        }
        listen = con1;
    }
    public void JsonObjectRequester(String url, JSONObject jsonobject, int type, String _className, String _methodName, String Temp1, String Temp2) {
        Display.DisplayLogD("anil url", url);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(type, url, jsonobject, new OnResponseObjectlistner(_className, _methodName, Temp1, Temp2 ), new OnerrorListner(_className, _methodName, Temp1, Temp2));
        try {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(con11);
            }
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(jsonObjReq);
            ((AppClass) con.getApplicationContext()).addToRequestQueuePriority(jsonObjReq);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void JsonArrayRequester(String url, String _className, String _methodName, String Temp1, String Temp2) {
        JsonArrayRequest arrayrequest = new JsonArrayRequest(url, new OnResponseArraylistner(_className, _methodName, Temp1, Temp2), new OnerrorListner(_className, _methodName, Temp1, Temp2));
        try {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(con11);
            }
            arrayrequest.setRetryPolicy(new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(arrayrequest);
            ((AppClass) con.getApplicationContext()).addToRequestQueuePriority(arrayrequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void StringRequester(String url, int type, String _className, String _methodName, String Temp1, String Temp2) {
        StringRequest stringrequest = new StringRequest(type, url, new OnResponseStringlistner(_className, _methodName, Temp1, Temp2), new OnerrorListner(_className, _methodName, Temp1, Temp2));
        try {
            Display.DisplayLogI("ADITYA", "StringRequester "+_methodName+" :: "+url);
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(con11);
            }
            stringrequest.setRetryPolicy(new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(stringrequest);
            ((AppClass) con.getApplicationContext()).addToRequestQueuePriority(stringrequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void StringRequesterFormValues(String url, int type, String _className, String _methodName, Map<String, String> param, String Temp1, String Temp2) {
        StringRequest stringrequest = new StringRequest(type, url, new OnResponseStringlistner(_className, _methodName, Temp1, Temp2), new OnerrorListner(_className, _methodName, Temp1, Temp2));
        try {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(con11);
            }
            Display.DisplayLogI("ADITYA", "FINAL REQQQ _methodName "+_methodName+" url "+url);
            stringrequest.setRetryPolicy(new DefaultRetryPolicy(
                    30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(stringrequest);
            ((AppClass) con.getApplicationContext()).addToRequestQueuePriority(stringrequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void StringRequesterFormValues1(String url, int type, String _className, String _methodName, Map<String, String> param, String Temp1, String Temp2) {
        try {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(con11);
            }
            Display.DisplayLogI("ADITYA", "PARAMS11 : "+_methodName+" " + param.toString());
            final Map<String, String> param1 = param;
            param1.put("aditya", "test"+ new Random().nextInt(10) + 5);
            StringRequest stringrequest = new StringRequest(Request.Method.POST, url, new OnResponseStringlistner(_className, _methodName, Temp1, Temp2), new OnerrorListner(_className, _methodName, Temp1, Temp2)) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = param1;
                    Display.DisplayLogI("ADITYA", "PARAMS22 : " + param1.toString());
                    return params;
                }
            };
            Display.DisplayLogI("ADITYA", "PARAMS11 111: "+_methodName+" " + param1.toString());
            stringrequest.setRetryPolicy(new DefaultRetryPolicy(
                    0,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mRequestQueue.add(stringrequest);
            ((AppClass) con.getApplicationContext()).addToRequestQueuePriority(stringrequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    class OnResponseObjectlistner implements Response.Listener<JSONObject> {
        String className;
        String methodName;
        String Temp1, Temp2;
        public OnResponseObjectlistner(String _className, String _methodName, String temp1, String temp2) {
            className = _className;
            methodName = _methodName;
            Temp1 = temp1;
            Temp2 = temp2;
        }
        @Override
        public void onResponse(JSONObject jsonObject) {
            try {
                listen.onTaskfinished(jsonObject.toString(), 05, className, methodName, Temp1, Temp2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    class OnerrorListner implements Response.ErrorListener {
        String className;
        String methodName;
        String Temp1, Temp2;
        public OnerrorListner(String _className, String _methodName, String temp1, String temp2) {
            className = _className;
            methodName = _methodName;
            Temp1 = temp1;
            Temp2 = temp2;
        }
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            try {
                listen.onTaskfinished(volleyError.getMessage(), 00, className, methodName, Temp1, Temp2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public class OnResponseArraylistner implements Response.Listener<JSONArray> {
        String className;
        String methodName;
        String Temp1, Temp2;
        public OnResponseArraylistner(String _className, String _methodName, String temp1, String temp2) {
            className = _className;
            methodName = _methodName;
            Temp1 = temp1;
            Temp2 = temp2;
        }
        @Override
        public void onResponse(JSONArray jsonArray) {
            try {
                listen.onTaskfinished(jsonArray.toString(), 05, className, methodName, Temp1, Temp2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public class OnResponseStringlistner implements Response.Listener<String> {
        String className;
        String methodName;
        String Temp1, Temp2;
        public OnResponseStringlistner(String _className, String _methodName, String temp1, String temp2) {
            className = _className;
            methodName = _methodName;
            Temp1 = temp1;
            Temp2 = temp2;
        }
        @Override
        public void onResponse(String s) {
            try {
                listen.onTaskfinished(s, 05, className, methodName, Temp1, Temp2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}