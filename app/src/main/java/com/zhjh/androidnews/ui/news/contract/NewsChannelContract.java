package com.zhjh.androidnews.ui.news.contract;

import com.zhjh.androidnews.bean.NewsChannelTable;
import com.zhjh.common.base.BaseModel;
import com.zhjh.common.base.BasePresenter;
import com.zhjh.common.base.BaseView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * des:
 * Created by xsf
 * on 2016.09.11:53
 */
public interface NewsChannelContract {

    interface Model extends BaseModel {
        Observable<List<NewsChannelTable>> lodeMineNewsChannels();
        Observable<List<NewsChannelTable>> lodeMoreNewsChannels();
        Observable<String> swapDb(ArrayList<NewsChannelTable> newsChannelTableList,int fromPosition, int toPosition);
        Observable<String> updateDb(ArrayList<NewsChannelTable> mineChannelTableList, ArrayList<NewsChannelTable> moreChannelTableList);
    }

    interface View extends BaseView {
        void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine);
        void returnMoreNewsChannels(List<NewsChannelTable> newsChannelsMore);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void lodeChannelsRequest();
        public abstract void onItemSwap(ArrayList<NewsChannelTable> newsChannelTableList, int fromPosition, final int toPosition);
        public abstract void onItemAddOrRemove(ArrayList<NewsChannelTable> mineChannelTableList, ArrayList<NewsChannelTable> moreChannelTableList);
    }
}
