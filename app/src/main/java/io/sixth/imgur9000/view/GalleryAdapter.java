package io.sixth.imgur9000.view;

/**
 * Created by walle on 04/01/15.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.Imgur;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.util.App;

public class GalleryAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private ArrayList<ImgurData> mDataSet;

    public GalleryAdapter(ArrayList<ImgurData> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.image_row_item, viewGroup, false);

        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, final int position) {
        Picasso.with(App.getAppContext())
                .load(mDataSet.get(position).getThumbnail(Imgur.THUMBNAIL_LARGE))
                .into(viewHolder.getCardBackground());

        Log.d(App.TAG, "Element " + position + " set.");
        viewHolder.getCardTitle().setText(mDataSet.get(position).getTitle());
        viewHolder.setImgurData(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }

}
