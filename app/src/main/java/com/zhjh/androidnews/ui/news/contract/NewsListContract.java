package com.zhjh.androidnews.ui.news.contract;

import com.zhjh.androidnews.bean.NewsSummary;
import com.zhjh.common.base.BaseModel;
import com.zhjh.common.base.BasePresenter;
import com.zhjh.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * des:新闻列表contract
 * Created by xsf
 * on 2016.09.14:38
 */
public interface NewsListContract {
    interface Model extends BaseModel {
        //请求获取新闻
        Observable <List<NewsSummary>> getNewsListData(String type, final String id, int startPage);
    }

    interface View extends BaseView {
        //返回获取的新闻
        void returnNewsListData(List<NewsSummary> newsSummaries);
        //返回顶部
        void scrolltoTop();
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取新闻请求
        public abstract void getNewsListDataRequest(String type, final String id, int startPage);
    }
}
