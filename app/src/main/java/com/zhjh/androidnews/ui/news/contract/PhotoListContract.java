package com.zhjh.androidnews.ui.news.contract;

import com.zhjh.androidnews.bean.PhotoGirl;
import com.zhjh.common.base.BaseModel;
import com.zhjh.common.base.BasePresenter;
import com.zhjh.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * des:图片列表contract
 * Created by xsf
 * on 2016.09.14:38
 */
public interface PhotoListContract {
    interface Model extends BaseModel {
        //请求获取图片
        Observable <List<PhotoGirl>> getPhotosListData(String type,int size, int page);
    }

    interface View extends BaseView {
        //返回获取的图片
        void returnPhotosListData(List<PhotoGirl> photoGirls);
    }
    abstract static class Presenter extends BasePresenter<View, Model> {
        //发起获取图片请求
        public abstract void getPhotosListDataRequest(String type,int size, int page);
    }
}
