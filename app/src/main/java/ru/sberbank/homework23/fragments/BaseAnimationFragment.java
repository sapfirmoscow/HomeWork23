package ru.sberbank.homework23.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import ru.sberbank.homework23.R;

public class BaseAnimationFragment extends Fragment {

    private ImageView mImageView;

    public static BaseAnimationFragment newInstance() {
        return new BaseAnimationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation_drawable, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mImageView = view.findViewById(R.id.drawable_animation_imageView);
        mImageView.setBackgroundResource(R.drawable.ic_signal_4);
    }

    @Override
    public void onResume() {
        super.onResume();
        AnimationSet set = new AnimationSet(true);

        Animation scale = new ScaleAnimation(2.5f, 1.0f, 2.5f, 1.0f);
        Animation alpha = new AlphaAnimation(0.0f, 1.0f);
        Animation rotate = new RotateAnimation(-180, 0f);

        set.addAnimation(scale);
        set.addAnimation(alpha);
        set.addAnimation(rotate);

        set.setDuration(1000);
        set.setRepeatMode(Animation.REVERSE);
        set.setRepeatCount(Animation.INFINITE);

        mImageView.startAnimation(set);
    }
}
