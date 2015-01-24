package io.sixth.imgur9000.view;

import android.os.Bundle;

import io.sixth.imgur9000.R;
import io.sixth.imgur9000.util.BaseActivity;

/**
 * Created by walle on 06/01/15.
 */
public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

}
