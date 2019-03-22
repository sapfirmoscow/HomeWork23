package ru.sberbank.homework23.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import ru.sberbank.homework23.R;


public class BaseAnimationXmlFragment extends Fragment {


    private ImageView mImageView;

    public static BaseAnimationXmlFragment newInstance() {
        return new BaseAnimationXmlFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animation_drawable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = view.findViewById(R.id.drawable_animation_imageView);
        mImageView.setBackgroundResource(R.drawable.ic_signal_4);
    }

    @Override
    public void onResume() {
        super.onResume();
        mImageView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.base));
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}