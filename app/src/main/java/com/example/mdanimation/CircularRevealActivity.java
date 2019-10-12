package com.example.mdanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CircularRevealActivity extends AppCompatActivity {


    FloatingActionButton fab;
    Animator animator;
    ActionBar toolbar;
    androidx.appcompat.app.ActionBar toolbar1;
    FrameLayout frameLayout;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_circular_reveal);

        view = LayoutInflater.from(this).inflate(R.layout.activity_circular_reveal, null);
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);


                return true;
            }
        });

  frameLayout = findViewById(R.id.frame_layout_id);


        fab = findViewById(R.id.fab_id);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CircularRevealTransition();
            }
        });

        int cy = fab.getHeight()/2;
        int cx = fab.getWidth()/2;
        float finalRadius = (float) Math.hypot(cx,cy);

        toolbar = getActionBar();
        toolbar1 = getSupportActionBar();
        


      /*  int actionViewResId = Resources.getSystem().getIdentifier(
                "action_bar_title", "id", getPackageName());

       findViewById(actionViewResId).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Log.d("dsa","sadf");
           }
       });
*/





      /*  if(fab.isAttachedToWindow())
        {
            Log.d("attached","veiw is attached");
            Toast.makeText(this, "Attached To Window", Toast.LENGTH_SHORT).show();
            animator = ViewAnimationUtils.createCircularReveal(fab,cx,cy,0,finalRadius);
            animator.start();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
*/





     /*   // id of relative layout
        view = findViewById(R.id.cicular_reveal_id);
        CircularRevealTransition();*/
    }



    public void CircularRevealTransition() {

        Toast.makeText(CircularRevealActivity.this, "Hey Brother", Toast.LENGTH_SHORT).show();

        int cy = frameLayout.getHeight();
        int cx = frameLayout.getWidth();
        float finalRadius = (float) Math.hypot(cx,cy);
        Animator animator = ViewAnimationUtils.createCircularReveal(findViewById(R.id.frame_layout_id),cx,cy,0,finalRadius);
        frameLayout.setVisibility(View.VISIBLE);


        animator.start();
    }
}
