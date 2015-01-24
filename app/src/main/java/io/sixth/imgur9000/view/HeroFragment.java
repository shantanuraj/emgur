package io.sixth.imgur9000.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.sixth.imgur9000.R;
import io.sixth.imgur9000.api.Imgur;
import io.sixth.imgur9000.api.ImgurData;
import io.sixth.imgur9000.util.App;
import io.sixth.imgur9000.util.BusProvider;

/**
 * Created by walle on 04/01/15.
 */
public class HeroFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private Bus bus;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public HeroFragment() {
        bus = BusProvider.getInstance();
    }

    @InjectView(R.id.heroRecyclerView)
    protected RecyclerView mRecyclerView;

    @InjectView(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hero, container, false);
        ButterKnife.inject(this, rootView);
        bus.register(this);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(App.getAppContext(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRefreshLayout.setOnRefreshListener(this);
        return rootView;
    }

    @Subscribe
    public void displayResponse(ArrayList<ImgurData> images) {
        mRefreshLayout.setRefreshing(false);
        mAdapter = new GalleryAdapter(images);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        Imgur.loadDefaultGallery();
    }
}