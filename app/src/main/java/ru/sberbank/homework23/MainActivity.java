package ru.sberbank.homework23;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ru.sberbank.homework23.activities.TransitionActivity;
import ru.sberbank.homework23.fragments.AnimationDrawableFragment;
import ru.sberbank.homework23.fragments.BaseAnimationFragment;
import ru.sberbank.homework23.fragments.BaseAnimationXmlFragment;
import ru.sberbank.homework23.fragments.ObjectAnimatorFragment;
import ru.sberbank.homework23.fragments.ValueAnimatorFragment;
import ru.sberbank.homework23.fragments.ValueAnimatorSetFragment;

public class MainActivity extends AppCompatActivity {

    private Button mAnimationDrawable;
    private Button mBaseAnimation;
    private Button mBaseXmlAnimation;
    private Button mObjectAnimation;
    private Button mTransition;
    private Button mValueAnimator;
    private Button mValueSet;


    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initViews();
        initListeners();
    }

    private void init() {
        mFragmentManager = getSupportFragmentManager();
    }

    private void initListeners() {
        mAnimationDrawable.setOnClickListener(v -> mFragmentManager.beginTransaction()
                .replace(R.id.main_container, AnimationDrawableFragment.newInstance())
                .commitNow());

        mBaseAnimation.setOnClickListener(v -> mFragmentManager.beginTransaction()
                .replace(R.id.main_container, BaseAnimationFragment.newInstance())
                .commitNow());

        mBaseXmlAnimation.setOnClickListener(v -> mFragmentManager.beginTransaction()
                .replace(R.id.main_container, BaseAnimationXmlFragment.newInstance())
                .commitNow());

        mObjectAnimation.setOnClickListener(v -> mFragmentManager.beginTransaction()
                .replace(R.id.main_container, ObjectAnimatorFragment.newInstance())
                .commitNow());

        mValueAnimator.setOnClickListener(v -> mFragmentManager.beginTransaction()
                .replace(R.id.main_container, ValueAnimatorFragment.newInstance())
                .commitNow());

        mValueSet.setOnClickListener(v -> mFragmentManager.beginTransaction()
                .replace(R.id.main_container, ValueAnimatorSetFragment.newInstance())
                .commitNow());

        mTransition.setOnClickListener(v -> startActivity(TransitionActivity.newIntent(MainActivity.this)));
    }

    private void initViews() {
        mAnimationDrawable = findViewById(R.id.to_animation_drawable_button1);
        mBaseAnimation = findViewById(R.id.to_animation_drawable_button2);
        mBaseXmlAnimation = findViewById(R.id.to_animation_drawable_button3);
        mObjectAnimation = findViewById(R.id.to_animation_drawable_button4);
        mValueAnimator = findViewById(R.id.to_animation_drawable_button5);
        mValueSet = findViewById(R.id.to_animation_drawable_button6);
        mTransition = findViewById(R.id.to_animation_drawable_button7);

    }


}
