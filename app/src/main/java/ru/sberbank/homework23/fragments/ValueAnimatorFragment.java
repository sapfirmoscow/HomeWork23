package ru.sberbank.homework23.fragments;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework23.R;

public class ValueAnimatorFragment extends Fragment {

    private static final float SCALE_FROM = 0.0f;
    private static final float SCALE_TO = 5.0f;
    private static final int DURATION = 3000;

    private List<ImageView> mImageViews;
    private List<ValueAnimator> mAnimators;

    public static ValueAnimatorFragment newInstance() {
        return new ValueAnimatorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_value_animator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initAnimators();
    }

    private void initViews(View v) {
        mImageViews = new ArrayList<>();
        mImageViews.add((ImageView) v.findViewById(R.id.imageView1));
        mImageViews.add((ImageView) v.findViewById(R.id.imageView2));
        mImageViews.add((ImageView) v.findViewById(R.id.imageView3));
        mImageViews.add((ImageView) v.findViewById(R.id.imageView4));
        mImageViews.add((ImageView) v.findViewById(R.id.imageView5));
    }

    private void initAnimators() {
        mAnimators = new ArrayList<>();

        for (int i = 0; i < mImageViews.size(); ++i) {
            ValueAnimator animator = ValueAnimator
                    .ofFloat(SCALE_FROM, SCALE_TO)
                    .setDuration(DURATION);
            mAnimators.add(animator);
        }

        for (int i = 0; i < mAnimators.size(); ++i) {
            final int position = i;
            mAnimators.get(position).addUpdateListener(animation ->
                    mImageViews.get(position).setScaleX((float) animation.getAnimatedValue()));
        }

        mAnimators.get(0).setInterpolator(new OvershootInterpolator());
        mAnimators.get(1).setInterpolator(new AnticipateOvershootInterpolator());
        mAnimators.get(2).setInterpolator(new LinearOutSlowInInterpolator());
        mAnimators.get(3).setInterpolator(new FastOutSlowInInterpolator());
        mAnimators.get(4).setInterpolator(new LinearInterpolator());
    }

    @Override
    public void onResume() {
        super.onResume();
        for (ValueAnimator animator : mAnimators) {
            animator.setupStartValues();
            animator.setRepeatMode(ValueAnimator.REVERSE);
            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.start();
        }
    }
}
