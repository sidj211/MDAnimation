package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SharedElementActivity extends AppCompatActivity {

    private RelativeLayout revealDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        /*
        * Inside your Activity (id you did not enabled transition in your theme)
        * for appcompat getwindow must be called before calling super.Oncreate()
        *
        * */

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element2);

        initpage();
    }

    @Override
    public boolean onNavigateUp() {
        finishAfterTransition();
        return super.onNavigateUp();
    }

    private void initpage() {

        /*
         * what will happen when the page will open
         * */

       /* getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");

        Button btnexit = findViewById(R.id.exit_button);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                *//*
         * what does this method do

         * *//*
                finishAfterTransition();
            }
        });

    */

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");

        revealDemo = findViewById(R.id.click_reveal);
        revealDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                makeCircularRevealAnimation(revealDemo);

            }
        });
    }

    private void makeCircularRevealAnimation(RelativeLayout revealDemo) {


        final TextView textdesc = findViewById(R.id.textdesc);
        int cx = revealDemo.getRight();
                int cy = revealDemo.getBottom();

                float radius = Math.max(textdesc.getWidth(),textdesc.getHeight())*2.0f;

                if(textdesc.getVisibility() == View.INVISIBLE)
                {
                    textdesc.setVisibility(View.VISIBLE);
                    textdesc.setText(R.string.description);

                    ViewAnimationUtils.createCircularReveal(textdesc,cx,cy,0,radius).start();
                   /* ViewAnimationUtils.createCircularReveal(textdesc,cx,cy,0,radius).start();*/

                }


    }
}
