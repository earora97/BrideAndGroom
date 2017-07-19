package com.example.srinivas.brideandgroom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.srinivas.brideandgroom.R;

import org.w3c.dom.Text;

public class WeddingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_details);

        TextView catering = (TextView) findViewById(R.id.tvcatering);

       catering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WeddingDetails.this, CateringActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
