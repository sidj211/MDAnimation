package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * This will be our starting activity (MAIN ACTIVITY for shared transition)
 * then we will call the shared transition function for performing the transition
 *
 * */


public class Main2Activity extends AppCompatActivity {


    private ImageView imgLogo, imgProfilePic;
    private TextView txvshared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        imgLogo = findViewById(R.id.logo);
        imgProfilePic = findViewById(R.id.profile_pic);
        txvshared = findViewById(R.id.activity_transition);
    }

    public void SharedElementTransition(View view) {

        /*
        this code will be responsible for the Animation by the help of activity options

        Container to ease passing around a tuple of two objects.
        This object provides a sensible implementation of equals(),
        returning true if equals() is true on each of the contained objects.

        pairs mai har view kw sath transition name diya hua hai

        * */

        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View, String>(imgLogo, "logo_shared");
        pair[1] = new Pair<View, String>(txvshared, "transition_shared");
        pair[2] = new Pair<View, String>(imgProfilePic, "profile_pic_shared");

        /*
        * kya kya option hum intent ke time par de sakte hai
        * Helper class for building an
        * options Bundle that can be used with Context.startActivity(Intent, Bundle)
        * and related methods.
        * */
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);

        Intent i = new Intent(Main2Activity.this, SharedElementActivity.class);
        /*
        what does the options do
        */

        startActivity(i, options.toBundle());


    }

    public void explodeTransitionByCode(View view) {

        /*
        * required for initiating the animation
        * */

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(Main2Activity.this,ExplodeTransitionActivity.class);

        intent.putExtra(Constants.KEY_TITLE,"TitleType");
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.ExplodeJava);
        intent.putExtra(Constants.USERNAME,"Siddharth");
        intent.putExtra(Constants.ROLL_NO,"onetwo");
        intent.putExtra(Constants.PASSWORD,"jannymar");
        startActivity(intent,options.toBundle());


    }

    public void explodeTransitionByXML(View view) {


        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(Main2Activity.this,ExplodeTransitionActivity.class);

        intent.putExtra(Constants.KEY_TITLE,"Explode By XML");
        intent.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.ExplodeXML);

        startActivity(intent,options.toBundle());

    }
}
