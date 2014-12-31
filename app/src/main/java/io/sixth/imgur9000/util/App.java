package io.sixth.imgur9000.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by walle on 01/01/15.
 */
public class App extends Application {

    private static final String TAG = App.class.getSimpleName();
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return App.context;
    }
}
