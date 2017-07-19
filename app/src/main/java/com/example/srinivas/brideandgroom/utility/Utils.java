package com.example.srinivas.brideandgroom.utility;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


import java.util.Calendar;

/**
 * Created by root on 20/2/17.
 */

public class Utils {

    public static final String english = "english";
    public static final String telugu = "telugu";
    public static final String hindi = "hindi";
    public static final String marati = "marati";
    public static final String tamil = "tamil";
    public static final String malayalam = "malayalam";
    public static final String punjabi = "punjabi";

    public static final String TODAY = "today";
    public static final String RANDOM = "random";
    public static final String SWIPE_LEFT = "swipe_left";
    public static final String SWIPE_RIGHT = "swipe_right";
    private static final int NOTIFICATION_REMINDER_NIGHT = 10;


    public void displayDialog(Context mContext, String text) {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
    //alertDialog.setTitle("Alert");
    alertDialog.setMessage(text);
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",
            new DialogInterface.OnClickListener()

    {
        public void onClick (DialogInterface dialog,int which){
        dialog.dismiss();
    }
    }

    );
    alertDialog.show();
}
}

