package io.sixth.imgur9000.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BaseActivity;
import io.sixth.imgur9000.util.BusProvider;
import io.sixth.imgur9000.util.ImgurImageView;

/**
 * Created by walle on 06/01/15.
 */
public class DetailActivity extends BaseActivity {

    private static Bus bus = BusProvider.getInstance();
    private ImgurData mImgurData;

    @InjectView(R.id.detail_image)
    protected ImgurImageView mDetailImage;

    @InjectView(R.id.image_title)
    protected TextView mImageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        int position = (int) getIntent().getExtras().get(CardViewHolder.KEY);
        mImgurData = GalleryAdapter.getData(position);
        Picasso.with(App.getAppContext()).load(mImgurData.getLink()).into(mDetailImage);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setUpView();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    private void setUpView() {
        mImageTitle.setText(mImgurData.getTitle());
    }

}
