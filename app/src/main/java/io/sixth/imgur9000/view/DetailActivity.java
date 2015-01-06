package io.sixth.imgur9000.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.util.BaseActivity;
import io.sixth.imgur9000.util.BusProvider;

/**
 * Created by walle on 06/01/15.
 */
public class DetailActivity extends BaseActivity {

    private static Bus bus = BusProvider.getInstance();

    @InjectView(R.id.detail_image)
    protected ImageView mDetailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Subscribe
    private void imageClicked() {
        Intent i = getIntent();
        startActivity(i);
    }
}
