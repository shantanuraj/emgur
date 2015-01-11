package io.sixth.imgur9000.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.nispok.snackbar.Snackbar;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.Imgur;
import io.sixth.imgur9000.login.ImgurAuthorization;
import io.sixth.imgur9000.login.LoginActivity;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BaseActivity;
import io.sixth.imgur9000.util.BusProvider;


public class HeroActivity extends BaseActivity {

    private static Bus bus = BusProvider.getInstance();
    private static Activity activity;

    @InjectView(R.id.drawer) protected DrawerLayout mDrawer;
    @InjectView(R.id.logoutButton) protected Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bus.register(this);

        ButterKnife.inject(this);
        setActionBarIcon(R.drawable.ic_ab_drawer);

        if (!ImgurAuthorization.getInstance().isLoggedIn()) {
            //hide logout button if user is not logged in.
            mLogoutButton.setVisibility(View.GONE);
        }

        Imgur.loadDefaultGallery();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new HeroFragment())
                    .commit();
        }

        activity = this;
        mDrawer.setStatusBarBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_hero;
    }

    @Subscribe public void loginCompleted(String status) {
        this.recreate();
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

    @OnClick(R.id.loginButton) protected void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.logoutButton) protected void logoutImgur() {
        ImgurAuthorization.getInstance().logout();
        this.recreate();
    }

    public static Activity getHeroActivity() {
        return activity;
    }

}
