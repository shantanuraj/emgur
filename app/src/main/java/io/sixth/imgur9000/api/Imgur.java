package io.sixth.imgur9000.api;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.otto.Bus;

import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;
import io.sixth.imgur9000.util.Constants;

/**
 * Created by walle on 01/01/15.
 */
public class Imgur {
    private final String API = "https://api.imgur.com/3/";
    private StringBuilder apiCall;
    private static Bus bus = BusProvider.getInstance();

    public Imgur() {
        apiCall = new StringBuilder(API);
    }

    public Imgur gallery () {
        apiCall.append("gallery/");
        return this;
    }

    public Imgur reddit (String subreddit) {
        apiCall.append("r/").append(subreddit);
        return this;
    }

    public Imgur defaultView() {
        apiCall = apiCall.append("hot/viral/0.json");
        return this;
    }

    public String getUrl() {
        return this.apiCall.toString();
    }

    public static void loadDefaultGallery() {
        final String url = new Imgur().gallery().defaultView().getUrl();
        Ion.with(App.getAppContext())
                .load(url)
                .setHeader("Authorization", "Client-ID " + Constants.CLIENT_ID)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (result != null) {
                            bus.post(result);
                        }
                    }
                });
    }

}
