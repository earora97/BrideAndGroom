package com.example.srinivas.brideandgroom.network;

import org.json.JSONException;

/**
 * Created by root on 9/2/17.
 */

public interface TaskListner {

    public void onTaskfinished(String response, int cd, String className, String methodName, String Temp1, String Temp2) throws JSONException;
}
