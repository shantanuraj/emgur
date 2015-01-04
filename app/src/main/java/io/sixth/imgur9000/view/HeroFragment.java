package io.sixth.imgur9000.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;

/**
 * Created by walle on 04/01/15.
 */
public class HeroFragment extends Fragment {

    private Bus bus;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataset;

    public HeroFragment() {
        bus = BusProvider.getInstance();
    }

    @InjectView(R.id.heroRecyclerView)
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hero, container, false);
        ButterKnife.inject(this, rootView);
        bus.register(this);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(App.getAppContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        return rootView;
    }

    @Subscribe
    public void displayResponse(ArrayList<ImgurData> images) {
//        ImgurData image = images.get(0);
//        Picasso.with(App.getAppContext()).load(image.getLink()).into(imageView);
        initDataset();
        mAdapter = new GalleryAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initDataset() {
        mDataset = new String[20];
        for (int i = 0; i < 20; ++i) {
            mDataset[i] = "Random text suffices: " +  (i + 1);
        }
    }

}