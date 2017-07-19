package com.example.srinivas.brideandgroom.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.srinivas.brideandgroom.MainFragment;
import com.example.srinivas.brideandgroom.R;

/**
 * Created by Srinivas on 3/12/2017.
 */
public class LoginFBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_login);

        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }
}
