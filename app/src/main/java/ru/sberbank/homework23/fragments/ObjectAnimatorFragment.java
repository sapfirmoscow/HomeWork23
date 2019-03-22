package ru.sberbank.homework23.fragments;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

import ru.sberbank.homework23.R;

public class ObjectAnimatorFragment extends Fragment {

    private Button mButton;

    public static ObjectAnimatorFragment newInstance() {
        return new ObjectAnimatorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_object_animator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViws(view);
        initListeners();
    }

    private void initListeners() {
        mButton.setOnClickListener(v -> animate());
    }

    private void animate() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mButton, View.X, 1200);
        animator.setDuration(3000);
        animator.setInterpolator(new AnticipateOvershootInterpolator());
        animator.start();
    }

    private void initViws(View v) {
        mButton = v.findViewById(R.id.happy_button);
    }

}
