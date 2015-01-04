package io.sixth.imgur9000.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.sixth.imgur9000.R;
import io.sixth.imgur9000.util.App;

/**
 * Created by walle on 04/01/15.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public CardViewHolder(View v) {
        super(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(App.TAG, "Element " + getPosition() + " clicked.");
            }
        });
        textView = (TextView) v.findViewById(R.id.imageTitle);
    }

    public TextView getTextView() {
        return textView;
    }
}