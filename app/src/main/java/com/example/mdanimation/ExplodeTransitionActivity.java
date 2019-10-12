package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.mdanimation.Constants.KEY_ANIM_TYPE;
import static com.example.mdanimation.Constants.KEY_TITLE;

public class ExplodeTransitionActivity extends AppCompatActivity {

    Constants.TransitionType transitionType;
    String toolbarTitle;
    String type, username, rollno, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explode_transition);

        initPage();

        initAnimation();
    }

    private void initPage() {


        /*
        *  This is an old question but everybody
        *  fails to mention that Enums are actually Serializable
        *  and therefore can perfectly be added to an Intent as an extra.
         * */
        transitionType = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);




        toolbarTitle = getIntent().getStringExtra(KEY_TITLE);
        Log.d("title", toolbarTitle);

        System.out.println("THIS IS TOOLBAR TITLE" + toolbarTitle);

        Button btnExit = findViewById(R.id.exit_button_id);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finishAfterTransition();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);

    }


    private void initAnimation() {

        System.out.println("Switch ke andar ayaa hia" + type);

        switch (transitionType) {

            case ExplodeJava: {
                Explode enterTransition = new Explode();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                getWindow().setEnterTransition(enterTransition);

                break;
            }

            case ExplodeXML:
            {
                Transition entertransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(entertransition);
                break;
            }


        }


    }


}


