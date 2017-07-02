package com.zhjh.androidnews.api;

import com.zhjh.androidnews.bean.GirlData;
import com.zhjh.androidnews.bean.NewsDetail;
import com.zhjh.androidnews.bean.NewsSummary;
import com.zhjh.androidnews.bean.PhotoGirl;
import com.zhjh.androidnews.bean.User;
import com.zhjh.androidnews.bean.VideoData;
import com.zhjh.common.basebean.BaseRespose;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {

    @GET("login")
    Observable<BaseRespose<User>> login(@Query("username") String username, @Query("password") String password);

    @GET("nc/article/{postId}/full.html")
    Observable<Map<String, NewsDetail>> getNewDetail(
            @Header("Cache-Control") String cacheControl,
            @Path("postId") String postId);

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsSummary>>> getNewsList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type, @Path("id") String id,
            @Path("startPage") int startPage);

    @GET
    Observable<ResponseBody> getNewsBodyHtmlPhoto(
            @Header("Cache-Control") String cacheControl,
            @Url String photoPath);
    //@Url，它允许我们直接传入一个请求的URL。这样以来我们可以将上一个请求的获得的url直接传入进来，baseUrl将被无视
    // baseUrl 需要符合标准，为空、""、或不合法将会报错

//    @GET("data/福利/{size}/{page}")
//    Observable<GirlData> getPhotoList(
//            @Header("Cache-Control") String cacheControl,
//            @Path("size") int size,
//            @Path("page") int page);

    @GET("getAllRecomPicByTag.jsp")
    Observable<GirlData> getPhotoList(
            @Header("Cache-Control") String cacheControl,
            @Query("category") String tag1,
            @Query("tag") String type,
            @Query("len") int size,
            @Query("start") int page);

    @GET("nc/video/list/{type}/n/{startPage}-10.html")
    Observable<Map<String, List<VideoData>>> getVideoList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type,
            @Path("startPage") int startPage);



    /**
     * 新浪图片新闻列表 例子：http://api.sina.cn/sinago/list.json?channel=hdpic_pretty&adid=4ad30dabe134695c3b7c3a65977d7e72&wm=b207&from=6042095012&chwm=12050_0001&oldchwm=12050_0001&imei=867064013906290&uid=802909da86d9f5fc&p=1
     *
     * @param page 页码
     * @return 被观察对象
     */
//    @GET("list.json")
//    Observable<GirlData> getSinaPhotoList(
//            @Header("Cache-Control") String cacheControl,
//            @Query("channel") String photoTypeId,
//            @Query("adid") String adid,
//            @Query("wm") String wm,
//            @Query("from") String from,
//            @Query("chwm") String chwm,
//            @Query("oldchwm") String oldchwm,
//            @Query("imei") String imei, @Query("uid") String uid, @Query("p") int page);

}
