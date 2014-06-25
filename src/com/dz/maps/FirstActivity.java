package com.dz.maps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by dz on 25.04.14.
 */
public class FirstActivity extends Activity {

    TextView score_text;
    Button button_start;
    Button about;

    private AdView adView;//ad block


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_xml);

        init();


        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-4271356805977933/7773787208");

        // Add the AdView to the view hierarchy. The view will have no size
        // until the ad is loaded.
        FrameLayout layout = (FrameLayout) findViewById(R.id.bottom_layout_first);
        //layout.addView(adView);

        layout.addView(adView);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        //.addTestDevice(deviceid).build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);

        SharedPreferences preferences = getSharedPreferences("mySettings", Context.MODE_PRIVATE);


        if(preferences.contains("count_score"))
        {
           int count_score = preferences.getInt("count_score", 0);
            score_text.setText(count_score + " руб.");
        }
        else score_text.setText("0 руб.");

    }

    private void init(){

        score_text = (TextView) findViewById(R.id.TextEconomy);

        button_start = (Button) findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("StartActivity", "START");
                Intent intent = new Intent(FirstActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });

        about = (Button) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("StartActivity","ABOUT");
                Intent intent = new Intent(FirstActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }

}
