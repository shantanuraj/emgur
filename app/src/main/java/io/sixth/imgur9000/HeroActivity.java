package io.sixth.imgur9000;

import android.content.Intent;
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

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.login.LoginActivity;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;


public class HeroActivity extends ActionBarActivity {

    private Bus bus;

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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
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
            return rootView;
        }

        @Override
        public void onResume() {
            super.onResume();
            Picasso.with(App.getAppContext()).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        }
    }
}
