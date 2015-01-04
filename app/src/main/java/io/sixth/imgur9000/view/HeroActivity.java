package io.sixth.imgur9000.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.nispok.snackbar.Snackbar;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.Imgur;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;


public class HeroActivity extends ActionBarActivity {

    private static Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bus = BusProvider.getInstance();

        setContentView(R.layout.activity_hero);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new HeroFragment())
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

}
