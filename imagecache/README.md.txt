图片缓存介绍
使用fresco框架，用ImagePipeline进行缓存，使用fresco的DraweeView显示
图片缓存使用方法：
1、导入
app的build.gradle的dependencies中加入implementation project(path: ':imagecache')
app的AndroidManifest.xml中加入<service android:name="com.ggx.imagecache.ImageCacheIntentService" />
2、初始化
Application的onCreate中加入
	ImageCacheUtil.init(context,path,name);
	参数：
	context：上下文，建议使用this，即 getApplicationContext()
	path：	文件夹路径，默认sd卡，即Environment.getExternalStorageDirectory()
	name：	缓存文件夹名称，默认path
3、预加载图片
在需要的地方加入：ImageCacheUtil.prefetchImage(param)
	参数：
	param：可以使用url，也可以使用ArrayList<String>
4、显示
使用fresco的DraweeView显示图片
	SimpleDraweeView simpleDraweeView;
	simpleDraweeView.setImageURI(imgUrl);