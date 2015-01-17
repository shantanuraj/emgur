package io.sixth.imgur9000.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.ImgurImageView;

/**
 * Created by walle on 18/01/15.
 */
public class DetailFragment extends Fragment {

    private ImgurData mImgurData;

    @InjectView(R.id.detail_image)
    protected ImgurImageView mDetailImage;

    @InjectView(R.id.image_title)
    protected TextView mImageTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.inject(this, rootView);
        int position = (int) getActivity().getIntent().getExtras().get(CardViewHolder.KEY);
        mImgurData = GalleryAdapter.getData(position);
        setUpView();
        return rootView;
    }

    private void setUpView() {
        Picasso.with(App.getAppContext()).load(mImgurData.getLink()).into(mDetailImage);
        mImageTitle.setText(mImgurData.getTitle());
    }
}
