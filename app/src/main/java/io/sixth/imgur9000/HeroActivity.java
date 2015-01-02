package io.sixth.imgur9000;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.nispok.snackbar.Snackbar;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.api.ImgurResponse;
import io.sixth.imgur9000.model.Imgur;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;
import io.sixth.imgur9000.util.Constants;


public class HeroActivity extends ActionBarActivity {

    private static Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        bus = BusProvider.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
        loadGallery();
    }

    @Subscribe public void loginCompleted(String status) {
        Snackbar.with(App.getAppContext()).text(status).show(this);
    }

    private void loadGallery() {
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

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @InjectView(R.id.imageView)
        ImageView imageView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_hero, container, false);
            ButterKnife.inject(this, rootView);
            bus.register(this);
            return rootView;
        }

        @Subscribe
        public void galleryLoaded(JsonObject result) {
            Gson gson = new Gson();
            ImgurResponse response;
            Log.d("FOOMAN", result.toString());
            try {
                response = gson.fromJson(result, ImgurResponse.class);
                parseResponse(response);
            } catch (Exception e) {
                Log.d("FOOMAN", "DATA NF");
            }
        }

        private void parseResponse(ImgurResponse response) {
            List<ImgurData> list = response.getData();
            for (ImgurData image : list) {
                if (image.isAlbum())
                Log.d("FOOMAN", image.getLink());
            }
        }
    }
}
