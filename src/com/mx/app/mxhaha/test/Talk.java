package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;


import android.util.Log;
import android.widget.TextView;

import com.robotium.solo.Solo;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import xuxu.autotest.element.Position;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Talk extends  ActivityInstrumentationTestCase2 
{	//Main activity信息
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME ="com.mx.app.MxMainActivity" ;

	private static Class launcherActivityClass;
	static {
	try {
	// 主要功能Class.forName(xxx.xx.xx)返回的是一个类Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段
	launcherActivityClass = Class
	.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
	} catch (ClassNotFoundException e) {
	throw new RuntimeException(e);
	}
	}
	
	public Talk() throws ClassNotFoundException {
	//调用父类具有相同形参的构造函数
	super(launcherActivityClass);
	}


	private Solo solo;//声明Solo
	Operation op=null;
	private static final String TAG="MxHahaTestLog";



	@Override
	public void setUp() throws Exception
	{
		solo = new Solo(getInstrumentation(), getActivity());
	}

//	@Override
//	public void tearDown() throws Exception
//	{
//		solo.finishOpenedActivities();
//	}
	// tearDown
	@Override
	public void tearDown() throws Exception {
		try {
			//finalize当垃圾回收器销毁对象时，它释放该对象使用的任何托管资源
			solo.finalize();
			solo.finishOpenedActivities();
			//Java中的所有异常都是由Throwable类的子类生成的对象，所有的异常类都是Throwable类的子类或子类的子类。Throwable类是Object类的直接子类，Error类和Exception类是Throwable类的两个直接子类。
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}
	//登录后讲笑话
	public void testTalk() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,strNowStr);
		//log打印用法
		Log.i(TAG,solo.getEditText(0).getText().toString());
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		Assert.assertTrue(solo.searchText(strNowStr));
		op.logout();
	}
	//登录后讲笑话带话题
	public void testTalkTopic() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		SimpleDateFormat sdf2=new SimpleDateFormat("mm:ss");
		String strNowStr=sdf.format(now);
		String strNowStr2=sdf2.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnText("点击选择话题");
		solo.enterText(0, strNowStr2);
		solo.sleep(2000);
		solo.clickOnText("确定");
		solo.clickOnText("发布");
		Assert.assertTrue(solo.waitForText("发布成功"));
		Assert.assertTrue(solo.searchText(strNowStr));
		op.logout();
	}
	//登录后讲笑话敏感词
	public void testTalkSensitive() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"4989";
		String dateNowStr3=dateNowStr+"****";
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,dateNowStr2);
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		Assert.assertTrue(solo.searchText(dateNowStr2));
		solo.sleep(2000);
		solo.drag(500, 500, 520, 1100, 10);
		solo.waitForText("松开更新内容");
		solo.sleep(9000);
		solo.waitForText(dateNowStr3);
		op.logout();
	}
	//登录后讲笑话超长
	public void testTalkLong() throws Exception
	{
		op=new Operation(solo);
		String content="早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…啊啊a早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…啊啊b";
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,content);
		solo.sleep(2000);
		solo.clickOnText("发布");
		Assert.assertTrue(solo.waitForText("亲，每条笑话限制800字哦，请重新编辑后再发"));
		op.logout();
	}
	//登录后讲笑话特殊字符
	public void testTalkSpecial() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"<h1>abc</h1>";
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,dateNowStr2);
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		Assert.assertTrue(solo.searchText(dateNowStr2));
		op.logout();
	}
	//被禁言用户登录后讲笑话
	public void testTalkBan() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.loginban();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("不好意思哦,您已被禁言"));
		op.logout();
	}
	//登录后匿名讲笑话
	public void testTalkAnonymous() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnCheckBox(0);
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		solo.sleep(3000);
		Assert.assertTrue(solo.searchText(strNowStr));
		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/header_nickname");
//		String nickname=view.getText().toString();
//		Assert.assertEquals("匿名", nickname);
		op.logout();
	}
	//登录后拍照讲笑话 目前弄不了
	public void testTalkPic() throws Exception
	{
		op=new Operation(solo);
		Position position=new Position();
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_camera_img"));
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		solo.sleep(3000);
		Assert.assertTrue(solo.searchText(strNowStr));
		solo.sleep(2000);
		op.logout();
	}
	//登录后上传本地图片讲笑话 目前弄不了
	public void testTalkPicLocal() throws Exception
	{
		op=new Operation(solo);
		Position position=new Position();
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_album_img"));
		solo.sleep(2000);
		solo.clickOnText("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		solo.sleep(3000);
		Assert.assertTrue(solo.searchText(strNowStr));
		solo.sleep(2000);
		op.logout();
	}
	//登录后发布语音笑话小于1s
	public void testTalkVoiceLessOne() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		//点击讲一个
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("录制语音笑话"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		//这个是自己写的控件 搜索不到的
//		Assert.assertTrue(solo.searchText("最长60秒"));
		//点击按住说话按钮
		solo.clickOnScreen(600, 1300);
		Assert.assertTrue(solo.waitForText("时间太短，请重新录制"));
		solo.goBack();
		op.logout();
	}
	//登录后发布语音笑话
	public void testTalkVoice() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		//点击讲一个
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("录制语音笑话"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		//这个是自己写的控件 搜索不到的
//		Assert.assertTrue(solo.searchText("最长60秒"));
		//点击按住说话按钮,最后一个参数是时间6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnButton("发布");
		solo.clickOnText("跳过");
		Assert.assertTrue(solo.waitForText("发布成功"));
		op.logout();
	}
	//登录后重录语音笑话确定并返回
	public void testTalkVoiceAgain() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		//点击讲一个
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("录制语音笑话"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		//点击按住说话按钮,最后一个参数是时间6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnButton("重录");
		Assert.assertTrue(solo.searchText("当前内容将被请空，确定重新录制?"));
		Assert.assertTrue(solo.searchText("哈哈提示"));
		solo.sleep(2000);
		solo.clickOnButton("确定");
		solo.sleep(2000);
		solo.goBack();
		op.logout();
	}
	//登录后重录语音笑话取消并返回
	public void testTalkVoiceCancel() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		//点击讲一个
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("录制语音笑话"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		//点击按住说话按钮,最后一个参数是时间6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnButton("重录");
		Assert.assertTrue(solo.searchText("当前内容将被请空，确定重新录制?"));
		Assert.assertTrue(solo.searchText("哈哈提示"));
		solo.sleep(2000);
		solo.clickOnButton("取消");
		solo.sleep(2000);
		solo.goBack();
		Assert.assertTrue(solo.searchText("当前内容尚未发布，确定退出?"));
		Assert.assertTrue(solo.searchText("哈哈提示"));
		solo.clickOnButton("确定");
		solo.sleep(2000);		
		op.logout();
	}
	//登录后重录语音笑话完成后点击顶部的返回
	public void testTalkVoiceBack() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		//点击讲一个
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("录制语音笑话"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		//点击按住说话按钮,最后一个参数是时间6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnText("录制语音笑话");
		Assert.assertTrue(solo.searchText("当前内容尚未发布，确定退出?"));
		Assert.assertTrue(solo.searchText("哈哈提示"));
		solo.clickOnButton("确定");
		solo.sleep(2000);		
		op.logout();
	}
	//登录后发布语音笑话带话题
	public void testTalkVoiceTopic() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		//点击讲一个
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("讲一个"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		Assert.assertTrue(solo.searchEditText("分享你的笑话"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("录制语音笑话"));
		Assert.assertTrue(solo.searchText("点击选择话题"));
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnText("点击选择话题");
		solo.enterText(0, strNowStr);
		solo.sleep(2000);
		solo.clickOnText("确定");
		solo.clickOnButton("发布");
		Assert.assertTrue(solo.waitForText("发布成功"));
		op.logout();
	}
}
