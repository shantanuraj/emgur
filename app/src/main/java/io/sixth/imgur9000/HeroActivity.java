package io.sixth.imgur9000;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nispok.snackbar.Snackbar;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.api.ResponseParser;
import io.sixth.imgur9000.api.Imgur;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;


public class HeroActivity extends ActionBarActivity {

    private static Bus bus;
    private static ResponseParser responseParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bus = BusProvider.getInstance();
        responseParser = new ResponseParser();

        setContentView(R.layout.activity_hero);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
        Imgur.loadDefaultGallery();
    }

    @Subscribe public void loginCompleted(String status) {
        Snackbar.with(App.getAppContext()).text(status).show(this);
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
        public void displayResponse(ArrayList<ImgurData> images) {
            ImgurData image = images.get(0);
            Picasso.with(App.getAppContext()).load(image.getLink()).into(imageView);
        }

    }
}
