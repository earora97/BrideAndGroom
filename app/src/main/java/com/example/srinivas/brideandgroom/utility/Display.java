package com.example.srinivas.brideandgroom.utility;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


/**
 * Class is used for debbugging and testing purpose
 * Single log class for all the logs
 */

public class Display {
    Context context;
    public static Toast toast;

    public Display(Context cont) {
        context = cont;
    }


    /**
     * Method is used to print the optional Toast message for debugging
     * @param msg string type, message
     * @param context
     * @return void
     */


    public static void DisplayToast(Context context, String msg) {
        try {
            try {
                if(toast != null) {
                    toast.cancel();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.setDuration(1000);
            // toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method is used to print the mandatory Toast message
     * @param msg string type, message
     * @param context
     * @return void
     */
    public static void DisplayToastMust(Context context, String msg) {
        try {
            try {
                if(toast != null) {
                    toast.cancel();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.setDuration(1000);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //********** DONT USE THIS VERSION 1 *****************//

    public static void DisplayLogI(String tag, String msg) {
        Log.i(tag, "" + msg);
    }

    public static void DisplayLogD(String tag, String msg) {
       Log.d (tag, msg);
    }

    public static void DisplayLogE(String tag, String msg) {
        Log.e (tag, msg);
    }

    //********** DONT USE THIS VERSION 1 *****************//


    public static void DisplayLogII(String tag, String msg) {
        Log.i (tag, "" + msg);
    }
}
