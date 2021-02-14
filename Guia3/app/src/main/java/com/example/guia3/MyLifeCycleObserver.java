package com.example.guia3;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.view.View;
import android.widget.Toast;
import android.util.Log;
public class MyLifeCycleObserver implements LifecycleObserver {

    private static final String TAG ="MyLifeCycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void Oncreate()
    {
        Log.i(TAG,"On Create");

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void OnStart()
    {
        Log.i(TAG,"On Start");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void OnPause()
    {
        Log.i(TAG,"On Pause");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void OnResume()
    {
        Log.i(TAG,"On Resume");

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void OnStop()
    {
        Log.i(TAG,"On Stop");

    }
}
