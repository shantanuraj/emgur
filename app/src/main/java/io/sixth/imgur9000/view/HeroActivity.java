package io.sixth.imgur9000.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.nispok.snackbar.Snackbar;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.Imgur;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BaseActivity;
import io.sixth.imgur9000.util.BusProvider;


public class HeroActivity extends BaseActivity {

    private static Bus bus;

    @InjectView(R.id.drawer) protected DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.inject(this);

        setActionBarIcon(R.drawable.ic_ab_drawer);

        bus = BusProvider.getInstance();



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new HeroFragment())
                    .commit();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_hero;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
