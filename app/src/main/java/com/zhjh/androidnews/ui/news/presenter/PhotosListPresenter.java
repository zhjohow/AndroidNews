package com.zhjh.androidnews.ui.news.presenter;

import com.zhjh.androidnews.R;
import com.zhjh.androidnews.bean.PhotoGirl;
import com.zhjh.androidnews.ui.news.contract.PhotoListContract;
import com.zhjh.common.baserx.RxSubscriber;

import java.util.List;

/**
 * des:图片列表
 * Created by xsf
 * on 2016.09.12:01
 */
public class PhotosListPresenter extends PhotoListContract.Presenter{
    @Override
    public void getPhotosListDataRequest(String mPhotoType,int size, int page) {
             mRxManage.add(mModel.getPhotosListData(mPhotoType,size,page).subscribe(new RxSubscriber<List<PhotoGirl>>(mContext,false) {
                 @Override
                 public void onStart() {
                     super.onStart();
                     mView.showLoading(mContext.getString(R.string.loading));
                 }
                 @Override
                 protected void _onNext(List<PhotoGirl> photoGirls) {
                     mView.returnPhotosListData(photoGirls);
                     mView.stopLoading();
                 }

                 @Override
                 protected void _onError(String message) {
                     mView.showErrorTip(message);
                 }
             }));
    }
}
