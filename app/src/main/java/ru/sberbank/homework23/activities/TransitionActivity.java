package ru.sberbank.homework23.activities;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import ru.sberbank.homework23.R;

public class TransitionActivity extends AppCompatActivity {
    private int count = 1;

    public static Intent newIntent(Context context) {
        return new Intent(context, TransitionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        init();
    }

    private void init() {
        ViewGroup scene_root = findViewById(R.id.scene_root);
        LayoutTransition transition = scene_root.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);

        final Scene scene1 = Scene.getSceneForLayout(scene_root, R.layout.sceen_a, this);
        final Scene scene2 = Scene.getSceneForLayout(scene_root, R.layout.sceen_b, this);
        final Scene scene3 = Scene.getSceneForLayout(scene_root, R.layout.sceen_c, this);

        Button switchButton = findViewById(R.id.transitButton);
        switchButton.setOnClickListener(v -> {

            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
            transitionSet.setDuration(1500);
            transitionSet.setInterpolator(new BounceInterpolator());
            if (count == 1) {
                TransitionManager.go(scene2, transitionSet);
                count = 2;
            } else if (count == 2) {
                TransitionManager.go(scene3, transitionSet);
                count = 3;
            } else {
                TransitionManager.go(scene1, transitionSet);
                count = 1;
            }
        });
    }
}
