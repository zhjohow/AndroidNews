package com.zhjh.androidnews.ui.news.model;

import com.zhjh.androidnews.api.Api;
import com.zhjh.androidnews.api.HostType;
import com.zhjh.androidnews.bean.VideoData;
import com.zhjh.androidnews.ui.news.contract.VideosListContract;
import com.zhjh.common.baserx.RxSchedulers;
import com.zhjh.common.commonutils.TimeUtil;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * des:视频列表model
 * Created by xsf
 * on 2016.09.14:54
 */
public class VideosListModel implements VideosListContract.Model {

    @Override
    public Observable<List<VideoData>> getVideosListData(final String type, int startPage) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getVideoList(Api.getCacheControl(),type,startPage)
                .flatMap(new Func1<Map<String, List<VideoData>>, Observable<VideoData>>() {
                    @Override
                    public Observable<VideoData> call(Map<String, List<VideoData>> map) {
                        return Observable.from(map.get(type));
                    }
                })
                //转化时间
                .map(new Func1<VideoData, VideoData>() {
                    @Override
                    public VideoData call(VideoData videoData) {
                        String ptime = TimeUtil.formatDate(videoData.getPtime());
                        videoData.setPtime(ptime);
                        return videoData;
                    }
                })
                .distinct()//去重
                .toSortedList(new Func2<VideoData, VideoData, Integer>() {
                    @Override
                    public Integer call(VideoData videoData, VideoData videoData2) {
                        return videoData2.getPtime().compareTo(videoData.getPtime());
                    }
                })
                //声明线程调度
                .compose(RxSchedulers.<List<VideoData>>io_main());
    }
}
