package ru.sberbank.homework23.fragments;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
import java.util.stream.Collectors;

import ru.sberbank.homework23.R;

public class ValueAnimatorSetFragment extends Fragment {
    private static final float SCALE_FROM = 0.0f;
    private static final float SCALE_TO = 5.0f;
    private static final int DURATION = 3000;

    private List<ImageView> mImageViews;
    private AnimatorSet mAnimatorSet;

    public static ValueAnimatorSetFragment newInstance() {
        return new ValueAnimatorSetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_value_animator, container, false);
        initViews(view);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initAnimators() {
        List<ValueAnimator> animators = new ArrayList<>();

        for (int i = 0; i < mImageViews.size(); ++i) {
            ValueAnimator animator = ValueAnimator
                    .ofFloat(SCALE_FROM, SCALE_TO)
                    .setDuration(DURATION);
            animators.add(animator);
        }

        for (int i = 0; i < animators.size(); ++i) {
            final int position = i;
            animators.get(position).addUpdateListener(animation ->
                    mImageViews.get(position).setScaleX((float) animation.getAnimatedValue()));
        }

        animators.get(0).setInterpolator(new OvershootInterpolator());
        animators.get(1).setInterpolator(new AnticipateOvershootInterpolator());
        animators.get(2).setInterpolator(new LinearOutSlowInInterpolator());
        animators.get(3).setInterpolator(new FastOutSlowInInterpolator());
        animators.get(4).setInterpolator(new LinearInterpolator());

        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(animators
                .stream()
                .map(valueAnimator -> (Animator) valueAnimator)
                .collect(Collectors.toList()));
    }

    @Override
    public void onResume() {
        super.onResume();
        mAnimatorSet.start();
    }
}