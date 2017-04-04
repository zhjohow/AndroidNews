package com.zhjohow.androidnews.ui.main.model;

import com.zhjohow.androidnews.app.AppApplication;
import com.zhjohow.androidnews.app.AppConstant;
import com.zhjohow.androidnews.bean.NewsChannelTable;
import com.zhjohow.androidnews.db.NewsChannelTableManager;
import com.zhjohow.androidnews.ui.main.contract.NewsMainContract;
import com.zhjohow.common.baserx.RxSchedulers;
import com.zhjohow.common.commonutils.ACache;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * des:
 * Created by xsf
 * on 2016.09.17:05
 */
public class NewsMainModel implements NewsMainContract.Model {
    @Override
    public Observable<List<NewsChannelTable>> lodeMineNewsChannels() {

        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(AppApplication.getAppContext()).getAsObject(AppConstant.CHANNEL_MINE);
               if(newsChannelTableList==null){
                   newsChannelTableList= (ArrayList<NewsChannelTable>) NewsChannelTableManager.loadNewsChannelsStatic();
                   ACache.get(AppApplication.getAppContext()).put(AppConstant.CHANNEL_MINE,newsChannelTableList);
               }
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }
}
