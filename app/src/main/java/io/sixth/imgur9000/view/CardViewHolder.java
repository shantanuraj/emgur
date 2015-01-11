package io.sixth.imgur9000.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.sixth.imgur9000.R;

/**
 * Created by walle on 04/01/15.
 */
public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView cardTitle;
    private final ImageView cardBackground;

    public static final String KEY = "POSITION";

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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailActivity.class);
        intent.putExtra(KEY, getPosition());
        v.getContext().startActivity(intent);
    }
}