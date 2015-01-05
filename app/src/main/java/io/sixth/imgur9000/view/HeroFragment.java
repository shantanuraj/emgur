package io.sixth.imgur9000.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
        mLayoutManager = new GridLayoutManager(App.getAppContext(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return rootView;
    }

    @Subscribe
    public void displayResponse(ArrayList<ImgurData> images) {
        mAdapter = new GalleryAdapter(images);
        mRecyclerView.setAdapter(mAdapter);
    }

}