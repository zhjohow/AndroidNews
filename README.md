# AndroidNews
hello world

AndroidNews，一款新闻阅读 App框架，基于 Material Design + MVP + RxJava + Retrofit + Glide，基本涵盖了当前 Android 端开发最常用的主流框架，基于此框架可以快速开发一个app。



<img src="https://github.com/zhjohow/AndroidNews/blob/master/screenshots/S70405-160739.jpg" height = "400" align=center />
<img src="https://github.com/zhjohow/AndroidNews/blob/master/screenshots/S70405-160751.jpg" height = "400" align=center />
<img src="https://github.com/zhjohow/AndroidNews/blob/master/screenshots/S70405-160759.jpg" height = "400" align=center />

####目前模块包括：

新闻：头条、科技、财经、NBA等类型，可自主选择订阅
美图：美图壁纸
视频：包括热点、搞笑、娱乐、精品视频

####项目亮点：

mvp模式：解耦model和view层，契约类管理mvp，一目了然，实现纵向解耦，基类完美封装，避免频繁new对象
RxJava:包括Rx处理服务器请求、缓存、线程调度的完美封装
组件化开发，横向解耦
封装各种工具类，比如压缩图片、轮播器、查看大图、缓存工具、图片选择器，以common的module形式依赖
各种封装好的依赖库，比如Irecyclerview：包含万能适配器、recyclerview的下拉刷新上拉加载更多、自定义刷新头和加载更多头；selectordialog：经常使用到的几种Dialog；
无关业务内容封装成model，基于此框架可以快速开发一个app
