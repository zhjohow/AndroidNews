/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zhjh.androidnews.bean;

import java.util.List;

public class PhotoGirl {


    /**
     * id : 5226700
     * did : 0
     * thumbUrl : http://img02.sogoucdn.com/app/a/100520020/173e52256847f77d54ebd1f6fcb05d96
     * thumb_width : 480
     * thumb_height : 360
     * sthumbUrl : http://img01.sogoucdn.com/app/a/100520024/6d2f4f8f3df13deed3a2fad44c131fc7
     * sthumb_width : 400
     * sthumb_height : 300
     * bthumbUrl : http://img04.sogoucdn.com/app/a/100520076/6d3c67391961fce47cde157c533dce91
     * bthumb_width : 160
     * bthumb_height : 120
     * pic_url : http://img01.sogoucdn.com/app/a/100520021/b37f3aa35ff6d76bd6fe0ca4700b5f2d
     * width : 900
     * height : 675
     * size : 106273
     * ori_pic_url : http://himg2.huanqiu.com/attachment2010/2012/0627/20120627092444693.jpg
     * ext_url : null
     * page_title : null
     * page_url : http://photo.huanqiu.com/beautyshow/2012-06/2653281_13.html
     * title : 性感美人杰西卡闺房秘照
     * tags : ["性感","人体","美人儿"]
     * group_mark : 3060aa6d7a673892
     * group_index : 0
     * publish_time : null
     * surr1 : null
     * surr2 : null
     * category : null
     * weight : 898171
     * deleted : 0
     * pfrom : 0
     * wapLink : null
     * webLink : null
     */

    private int id;
    private int did;
    private String thumbUrl;
    private int thumb_width;
    private int thumb_height;
    private String sthumbUrl;
    private int sthumb_width;
    private int sthumb_height;
    private String bthumbUrl;
    private int bthumb_width;
    private int bthumb_height;
    private String pic_url;
    private int width;
    private int height;
    private int size;
    private String ori_pic_url;
    private String title;
    private String group_mark;
    private int group_index;
    private int weight;
    private int deleted;
    private int pfrom;
    private List<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public int getThumb_width() {
        return thumb_width;
    }

    public void setThumb_width(int thumb_width) {
        this.thumb_width = thumb_width;
    }

    public int getThumb_height() {
        return thumb_height;
    }

    public void setThumb_height(int thumb_height) {
        this.thumb_height = thumb_height;
    }

    public String getSthumbUrl() {
        return sthumbUrl;
    }

    public void setSthumbUrl(String sthumbUrl) {
        this.sthumbUrl = sthumbUrl;
    }

    public int getSthumb_width() {
        return sthumb_width;
    }

    public void setSthumb_width(int sthumb_width) {
        this.sthumb_width = sthumb_width;
    }

    public int getSthumb_height() {
        return sthumb_height;
    }

    public void setSthumb_height(int sthumb_height) {
        this.sthumb_height = sthumb_height;
    }

    public String getBthumbUrl() {
        return bthumbUrl;
    }

    public void setBthumbUrl(String bthumbUrl) {
        this.bthumbUrl = bthumbUrl;
    }

    public int getBthumb_width() {
        return bthumb_width;
    }

    public void setBthumb_width(int bthumb_width) {
        this.bthumb_width = bthumb_width;
    }

    public int getBthumb_height() {
        return bthumb_height;
    }

    public void setBthumb_height(int bthumb_height) {
        this.bthumb_height = bthumb_height;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOri_pic_url() {
        return ori_pic_url;
    }

    public void setOri_pic_url(String ori_pic_url) {
        this.ori_pic_url = ori_pic_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup_mark() {
        return group_mark;
    }

    public void setGroup_mark(String group_mark) {
        this.group_mark = group_mark;
    }

    public int getGroup_index() {
        return group_index;
    }

    public void setGroup_index(int group_index) {
        this.group_index = group_index;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getPfrom() {
        return pfrom;
    }

    public void setPfrom(int pfrom) {
        this.pfrom = pfrom;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
