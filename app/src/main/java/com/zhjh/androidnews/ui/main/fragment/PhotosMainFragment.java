package com.zhjh.androidnews.ui.main.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.aspsine.irecyclerview.widget.LoadMoreFooterView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhjh.androidnews.R;
import com.zhjh.androidnews.app.AppConstant;
import com.zhjh.androidnews.bean.PhotoChannelTable;
import com.zhjh.androidnews.bean.PhotoGirl;
import com.zhjh.androidnews.bean.VideoChannelTable;
import com.zhjh.androidnews.db.PhotosChannelTableManager;
import com.zhjh.androidnews.db.VideosChannelTableManager;
import com.zhjh.androidnews.ui.news.activity.PhotosDetailActivity;
import com.zhjh.androidnews.ui.news.contract.PhotoListContract;
import com.zhjh.androidnews.ui.news.fragment.PhotosFragment;
import com.zhjh.androidnews.ui.news.fragment.VideosFragment;
import com.zhjh.androidnews.ui.news.model.PhotosListModel;
import com.zhjh.androidnews.ui.news.presenter.PhotosListPresenter;
import com.zhjh.androidnews.utils.MyUtils;
import com.zhjh.common.base.BaseFragment;
import com.zhjh.common.base.BaseFragmentAdapter;
import com.zhjh.common.commonwidget.LoadingTip;
import com.zhjh.common.commonwidget.NormalTitleBar;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * des:图片首页
 * Created by xsf
 * on 2016.09.11:49
 */
public class PhotosMainFragment extends BaseFragment {
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private BaseFragmentAdapter fragmentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.app_bar_photo;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        List<String> channelNames = new ArrayList<>();
        List<PhotoChannelTable> photoChannelTableList = PhotosChannelTableManager.loadPhotosChannelsMine();
        List<Fragment> mNewsFragmentList = new ArrayList<>();
        for (int i = 0; i < photoChannelTableList.size(); i++) {
            channelNames.add(photoChannelTableList.get(i).getChannelName());
            mNewsFragmentList.add(createListFragments(photoChannelTableList.get(i)));
        }
        fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        MyUtils.dynamicSetTabLayoutMode(tabs);
        setPageChangeListener();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP, "");
            }
        });
    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private PhotosFragment createListFragments(PhotoChannelTable photoChannelTable) {
        PhotosFragment fragment = new PhotosFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.PHOTO_TYPE, photoChannelTable.getChannelId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}

