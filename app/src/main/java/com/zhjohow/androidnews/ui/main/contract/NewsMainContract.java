package com.zhjohow.androidnews.ui.main.contract;

import com.zhjohow.androidnews.bean.NewsChannelTable;
import com.zhjohow.common.base.BaseModel;
import com.zhjohow.common.base.BasePresenter;
import com.zhjohow.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * des:
 * Created by xsf
 * on 2016.09.11:53
 */
public interface NewsMainContract {

    interface Model extends BaseModel {
        Observable< List<NewsChannelTable> > lodeMineNewsChannels();
    }

    interface View extends BaseView {
        void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void lodeMineChannelsRequest();
    }
}
