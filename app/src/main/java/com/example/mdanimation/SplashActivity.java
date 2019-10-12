package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    ImageView  imageView;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.boy_image_id);
        linearLayout = findViewById(R.id.linear_layout_id);

        SpringAnimation animation = new SpringAnimation(imageView, SpringAnimation.Y);
        /*
        X direction mai spring animation karna hai
        */
        // create a spring with desired parameters
        SpringForce spring = new SpringForce(); //spring force aur uske features dalenge spring mai
        // can also be passed directly in the constructor
        spring.setFinalPosition(252f);
        // optional, default is STIFFNESS_MEDIUM
        spring.setStiffness(SpringForce.STIFFNESS_LOW);
        // optional, default is DAMPING_RATIO_MEDIUM_BOUNCY
        spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        // set your animation's spring
        animation.setSpring(spring);
        //
        animation.setStartVelocity(2000f);
        // animate!
        animation.start();

        linearLayout.animate().scaleX(.8f).scaleY(.8f).setStartDelay(500);

      /*
        final SpringAnimation springAnimation = new SpringAnimation(imageView, DynamicAnimation.SCALE_Y,0);

        SpringForce spring = new SpringForce();
        spring.setFinalPosition(imageView.getY());
        spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        spring.setStiffness(SpringForce.STIFFNESS_LOW);

        springAnimation.setStartVelocity(2000f);
        springAnimation.setSpring(spring);
        springAnimation.start();

       */




    }
}
