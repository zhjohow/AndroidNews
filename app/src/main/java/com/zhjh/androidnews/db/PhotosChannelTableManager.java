/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
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
package com.zhjh.androidnews.db;


import com.zhjh.androidnews.R;
import com.zhjh.androidnews.app.AppApplication;
import com.zhjh.androidnews.bean.PhotoChannelTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotosChannelTableManager {

    /**
     * 加载视频类型
     * @return
     */
    public static List<PhotoChannelTable> loadPhotosChannelsMine() {
        List<String> channelName = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.photo_channel_name));
        List<String> channelId = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.photo_channel_id));
        ArrayList<PhotoChannelTable>newsChannelTables=new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            PhotoChannelTable entity = new PhotoChannelTable(channelId.get(i), channelName.get(i));
            newsChannelTables.add(entity);
        }
        return newsChannelTables;
    }

}
