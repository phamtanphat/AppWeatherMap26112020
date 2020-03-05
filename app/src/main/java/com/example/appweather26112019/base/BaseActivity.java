package com.example.appweather26112019.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appweather26112019.R;
import com.victor.loading.rotate.RotateLoading;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutId();
    protected abstract int getProgressLayout();
    private View layoutProgress;
    private RotateLoading rotateLoading;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        layoutProgress = findViewById(getProgressLayout());
        rotateLoading = layoutProgress.findViewById(R.id.rotateloading);
        hideProgress();
    }
    public void showProgress(){
        layoutProgress.setVisibility(View.VISIBLE);
        rotateLoading.start();

    }
    public void hideProgress(){
        layoutProgress.setVisibility(View.GONE);
        rotateLoading.stop();
    }
}
