package io.sixth.imgur9000.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;

/**
 * Created by walle on 02/01/15.
 */
public class ResponseParser {
    private static Bus bus = BusProvider.getInstance();
    private static Gson gson = new Gson();

    public ResponseParser() {
        bus = BusProvider.getInstance();
        bus.register(this);
    }

    @Subscribe
    public void parseResponseData(JsonObject result) {

        ImgurResponse response;
        try {
            response = gson.fromJson(result, ImgurResponse.class);
            parseResponse(response);
        } catch (Exception e) {
            Log.d(App.TAG, "DATA NF");
        }
    }

    private void parseResponse(ImgurResponse response) {
        List<ImgurData> list = response.getData();
        ArrayList<ImgurData> images = new ArrayList<>();
        for (ImgurData image : list) {
            if (!image.isAlbum()) {
                images.add(image);
            }
        }
        bus.post(images);
    }
}
