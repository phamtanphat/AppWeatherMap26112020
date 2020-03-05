package com.example.appweather26112019.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.appweather26112019.R;
import com.example.appweather26112019.base.BaseActivity;
import com.victor.loading.rotate.RotateLoading;

public class MainActivity extends BaseActivity{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getProgressLayout() {
        return R.id.layoutProgress;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
