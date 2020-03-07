package com.example.appweather26112019.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appweather26112019.R;
import com.example.appweather26112019.base.BaseActivity;
import com.example.appweather26112019.model.business.TempCurrent;
import com.example.appweather26112019.model.request.WeatherSearchLocationForm;
import com.example.appweather26112019.util.AppConstant;
import com.example.appweather26112019.viewmodel.MainViewmodel;
import com.victor.loading.rotate.RotateLoading;

public class MainActivity extends BaseActivity{

    MainViewmodel mMainViewmodel;
    EditText mEdtSearchLocation;
    TextView mTvSearch;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getProgressLayout() {
        return R.id.layoutProgress;
    }

    @Override
    protected void init() {
        mMainViewmodel = new MainViewmodel();
    }

    @Override
    protected void mapview() {
        mEdtSearchLocation = findViewById(R.id.editSearchLocation);
        mTvSearch = findViewById(R.id.tvSearch);
        getLifecycle().addObserver(mMainViewmodel);
    }

    @Override
    protected void obserData() {
        mMainViewmodel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean loading) {
                if (loading){
                    showProgress();
                }else{
                    hideProgress();
                }
            }
        });
        mMainViewmodel.isError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!s.isEmpty()){
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });
        mMainViewmodel.getWeatherLocationSuccess().observe(this, new Observer<TempCurrent>() {
            @Override
            public void onChanged(TempCurrent tempCurrent) {
                if (tempCurrent.getMessage() != null){
                    Toast.makeText(MainActivity.this, tempCurrent.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, tempCurrent.getMain().getTemp().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void setListener() {
        mTvSearch.setOnClickListener(v -> mMainViewmodel.callWeatherLocation(
                new WeatherSearchLocationForm(
                        mEdtSearchLocation.getText().toString().replaceAll(" ",""),
                        AppConstant.MODE,
                        AppConstant.UNIT,
                        AppConstant.APPID
                )));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
