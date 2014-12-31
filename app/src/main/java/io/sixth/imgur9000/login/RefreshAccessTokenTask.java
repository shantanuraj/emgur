package io.sixth.imgur9000.login;

/**
 * Created by walle on 01/01/15.
 */

import android.os.AsyncTask;
import android.util.Log;
import android.text.TextUtils;

public class RefreshAccessTokenTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = RefreshAccessTokenTask.class.getSimpleName();

    @Override
    protected String doInBackground(Void... params) {
        String accessToken = ImgurAuthorization.getInstance().requestNewAccessToken();
        if (!TextUtils.isEmpty(accessToken)) {
            Log.i(TAG, "Got new access token");
        }
        else {
            Log.i(TAG, "Could not get new access token");
        }
        return accessToken;
    }
}

