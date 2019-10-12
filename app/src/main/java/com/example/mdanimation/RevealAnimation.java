package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RevealAnimation extends AppCompatActivity {


    private ImageView imgLogo,imgProfilePic;
    private TextView txvshared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_animation);

        imgLogo = findViewById(R.id.logo);
        imgProfilePic = findViewById(R.id.profile_pic);
        txvshared = findViewById(R.id.activity_transition);
    }

    public void SharedElementTransition(View view) {

        /*
        this code will be responsible for the Animation by the help of activity options
        * */

        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View,String>(imgLogo,"logo_shared");
        pair[1] = new Pair<View,String>(txvshared,"transition_shared");
        pair[2] = new Pair<View,String>(imgProfilePic,"profile_pic_shared");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pair);

                Intent i = new Intent(RevealAnimation.this,SharedElementActivity.class);
        /*

        * what does the options do*/

        startActivity(i,options.toBundle());


    }
}
