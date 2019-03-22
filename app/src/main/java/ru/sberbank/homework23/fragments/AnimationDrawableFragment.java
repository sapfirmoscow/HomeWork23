package ru.sberbank.homework23.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ru.sberbank.homework23.R;

public class AnimationDrawableFragment extends Fragment {

    private AnimationDrawable mAnimation;

    public static AnimationDrawableFragment newInstance() {
        return new AnimationDrawableFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation_drawable, container, false);
        ImageView imageView = view.findViewById(R.id.drawable_animation_imageView);
        imageView.setBackgroundResource(R.drawable.wifi_animation);
        mAnimation = (AnimationDrawable) imageView.getBackground();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAnimation.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mAnimation.stop();
    }
}
