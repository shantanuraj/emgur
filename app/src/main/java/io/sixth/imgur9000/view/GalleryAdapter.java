package io.sixth.imgur9000.view;

/**
 * Created by walle on 04/01/15.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.sixth.imgur9000.R;
import io.sixth.imgur9000.util.App;

public class GalleryAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private ArrayList<String> mDataSet;

    public GalleryAdapter(ArrayList<String> dataSet) {
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
        Log.d(App.TAG, "Element " + position + " set.");
        viewHolder.getCardTitle().setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDataSet == null)
            return 0;
        return mDataSet.size();
    }
}
