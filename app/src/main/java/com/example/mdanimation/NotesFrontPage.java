package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

public class NotesFrontPage extends AppCompatActivity {


    ImageView imageView;

    TextInputLayout et_username;
    TextInputLayout et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_front_page);

/*        AppCompatButton ProceedLogin = findViewById(R.id.button8);
        AppCompatButton Register = findViewById(R.id.button9);*/

        imageView = findViewById(R.id.notes_logo);
        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);

        SpringAnimation animation = new SpringAnimation(imageView, SpringAnimation.Y);
        /*
        X direction mai spring animation karna hai
        */
        // create a spring with desired parameters
        SpringForce spring = new SpringForce(); //spring force aur uske features dalenge spring mai
        // can also be passed directly in the constructor
        spring.setFinalPosition(100f);
        // optional, default is STIFFNESS_MEDIUM
        spring.setStiffness(SpringForce.STIFFNESS_LOW);
        // optional, default is DAMPING_RATIO_MEDIUM_BOUNCY
        spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        // set your animation's spring
        animation.setSpring(spring);
        //
        animation.setStartVelocity(4000f);
        // animate!
        animation.start();




    }
}
