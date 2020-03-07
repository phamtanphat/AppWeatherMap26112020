package com.example.appweather26112019.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.appweather26112019.model.business.TempCurrent;
import com.example.appweather26112019.model.request.WeatherSearchLocationForm;
import com.example.appweather26112019.repository.WeatherRepository;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewmodel extends ViewModel implements LifecycleObserver {

    private CompositeDisposable compositeDisposable;
    private WeatherRepository weatherRepository;
    private MutableLiveData<TempCurrent> mWeatherLocation;
    private MutableLiveData<String> mError;
    private MutableLiveData<Boolean> mLoading;

    public MainViewmodel() {
        this.weatherRepository = WeatherRepository.getInstance();
        this.mWeatherLocation = new MutableLiveData<>();
        this.mError = new MutableLiveData<>();
        this.mLoading = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    public LiveData<Boolean> isLoading(){
        return mLoading;
    }
    public LiveData<String> isError(){
        return mError;
    }

    public LiveData<TempCurrent> getWeatherLocationSuccess(){
        return  mWeatherLocation;
    }
    public void callWeatherLocation(WeatherSearchLocationForm locationForm){
        mLoading.setValue(true);
        weatherRepository.getTempAtLocation(locationForm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TempCurrent>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(TempCurrent tempCurrent) {
                        mWeatherLocation.setValue(tempCurrent);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mError.setValue(e.getMessage());
                        mLoading.setValue(false);
                    }

                    @Override
                    public void onComplete() {
                        mLoading.setValue(false);
                    }
                });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void clear(){
        compositeDisposable.clear();
    }
}
