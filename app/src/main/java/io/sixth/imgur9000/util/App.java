package io.sixth.imgur9000.util;

import android.app.Application;
import android.content.Context;

import io.sixth.imgur9000.api.ResponseParser;

/**
 * Created by walle on 01/01/15.
 */
public class App extends Application {

    public static final String TAG = App.class.getSimpleName();
    private static Context context;
    private static ResponseParser responseParser;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        responseParser = new ResponseParser();
    }

    public static Context getAppContext() {
        return App.context;
    }
}
