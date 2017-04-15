package com.zhjh.androidnews.ui.news.model;

import com.zhjh.androidnews.app.AppApplication;
import com.zhjh.androidnews.R;
import com.zhjh.androidnews.api.ApiConstants;
import com.zhjh.androidnews.app.AppConstant;
import com.zhjh.androidnews.bean.NewsChannelTable;
import com.zhjh.androidnews.db.NewsChannelTableManager;
import com.zhjh.androidnews.ui.news.contract.NewsChannelContract;
import com.zhjh.common.baserx.RxSchedulers;
import com.zhjh.common.commonutils.ACache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * des:新闻频道
 * Created by xsf
 * on 2016.09.17:05
 */
public class NewsChannelModel implements NewsChannelContract.Model {
    @Override
    public Observable<List<NewsChannelTable>> lodeMineNewsChannels() {

        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(AppApplication.getAppContext()).getAsObject(AppConstant.CHANNEL_MINE);
               if(newsChannelTableList==null){
                   newsChannelTableList= (ArrayList<NewsChannelTable>) NewsChannelTableManager.loadNewsChannelsStatic();
               }
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }

    @Override
    public Observable<List<NewsChannelTable>> lodeMoreNewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(AppApplication.getAppContext()).getAsObject(AppConstant.CHANNEL_MORE);
               if(newsChannelTableList==null) {
                   List<String> channelName = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_name));
                   List<String> channelId = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_id));
                   newsChannelTableList = new ArrayList<>();
                   for (int i = 0; i < channelName.size(); i++) {
                       NewsChannelTable entity = new NewsChannelTable(channelName.get(i), channelId.get(i)
                               , ApiConstants.getType(channelId.get(i)), i <= 5, i, false);
                       newsChannelTableList.add(entity);
                   }
               }
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }

    @Override
    public Observable<String> swapDb(final ArrayList<NewsChannelTable> newsChannelTableList,int fromPosition, int toPosition) {
       return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                ACache.get(AppApplication.getAppContext()).put(AppConstant.CHANNEL_MINE,newsChannelTableList);
                subscriber.onNext("");
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<String>io_main());

    }

    @Override
    public Observable<String> updateDb(final ArrayList<NewsChannelTable> mineChannelTableList,final ArrayList<NewsChannelTable> moreChannelTableList) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                ACache.get(AppApplication.getAppContext()).put(AppConstant.CHANNEL_MINE,mineChannelTableList);
                ACache.get(AppApplication.getAppContext()).put(AppConstant.CHANNEL_MORE,moreChannelTableList);
                subscriber.onNext("");
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<String>io_main());
    }
}
