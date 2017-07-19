package com.example.srinivas.brideandgroom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.srinivas.brideandgroom.R;

public class MyWedding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wedding);

        Button bProceed = (Button) findViewById(R.id.button_proceed);

        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyWedding.this, WeddingDetails.class);
                startActivity(i);
                finish();
            }
        });

    }
}
