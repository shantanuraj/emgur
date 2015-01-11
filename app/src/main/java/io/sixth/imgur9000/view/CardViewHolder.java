package io.sixth.imgur9000.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.util.App;

/**
 * Created by walle on 04/01/15.
 */
public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView cardTitle;
    private final ImageView cardBackground;
    private ImgurData mImgurData;

    public CardViewHolder(View v) {
        super(v);
        v.setOnClickListener(this);
        cardTitle = (TextView) v.findViewById(R.id.cardTitle);
        cardBackground = (ImageView) v.findViewById(R.id.cardBackground);
    }

    public TextView getCardTitle() {
        return cardTitle;
    }

    public ImageView getCardBackground() {
        return cardBackground;
    }

    public void setImgurData(ImgurData imgurData) {
        mImgurData = imgurData;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailActivity.class);
        v.getContext().startActivity(intent);
    }
}