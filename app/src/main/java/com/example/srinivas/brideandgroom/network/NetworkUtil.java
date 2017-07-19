package com.example.srinivas.brideandgroom.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by root on 21/2/17.
 */

public class NetworkUtil {

    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo currentNetworkInfo = connectivity.getActiveNetworkInfo();
        if (currentNetworkInfo != null && currentNetworkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
