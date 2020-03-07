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
    protected abstract void init();
    protected abstract void mapview();
    protected abstract void obserData();
    protected abstract void setListener();
    private View layoutProgress;
    private RotateLoading rotateLoading;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (getProgressLayout() > 0){
            layoutProgress = findViewById(getProgressLayout());
            rotateLoading = layoutProgress.findViewById(R.id.rotateloading);
            hideProgress();
        }
        init();
        mapview();
        obserData();
        setListener();
    }
    public void showProgress(){
        if(layoutProgress != null){
            layoutProgress.setVisibility(View.VISIBLE);
            rotateLoading.start();
        }
    }
    public void hideProgress(){
        if(layoutProgress != null){
            layoutProgress.setVisibility(View.GONE);
            rotateLoading.stop();
        }
    }
}
