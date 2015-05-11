package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.By;
import com.robotium.solo.Solo;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Comment extends  ActivityInstrumentationTestCase2 
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
	
	public Comment() throws ClassNotFoundException {
	super(launcherActivityClass);
	}


	private Solo solo;//声明Solo
	Operation op=null;



	@Override
	public void setUp() throws Exception
	{
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception
	{
		solo.finishOpenedActivities();
	}
	//发布评论
	public void testComment() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
	//生成格式为下面的当前时间
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("发个评论吧~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("发布评论"));
		Assert.assertTrue(solo.searchText("回复楼主："));
		solo.enterText(0, dateNowStr);
		Assert.assertTrue(solo.searchEditText(dateNowStr));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("评论成功"));
		Assert.assertTrue(solo.searchText(dateNowStr));
		op.logout();
		}
	//发布评论敏感词
	public void testCommentSensitive() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"4989";
		String dateNowStr3=dateNowStr+"****";
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("发个评论吧~");
		solo.sleep(2000);
		solo.enterText(0, dateNowStr2);
		Assert.assertTrue(solo.searchEditText(dateNowStr2));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("评论成功"));
		Assert.assertTrue(solo.searchText(dateNowStr3));
		op.logout();
		}
	//发布评论超长
	public void testCommentLong() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
		String content="早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…gc是吃饭时，她跟爷爷奶奶说，我爸爸在床上捉老鼠，可厉害了。床都快摇塌了！到时那个囧啊！ 早上突然性起…可3岁女儿已经醒了，于是到老婆后面入，动静有点大。女儿问爸爸在后面干嘛？老婆说捉老鼠，要不然会咬你的！然后她就不问了…啊啊";
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("发个评论吧~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("发布评论"));
		Assert.assertTrue(solo.searchText("回复楼主："));
		solo.enterText(0, content);
		Assert.assertTrue(solo.searchEditText(content));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("评论字数超过400字，请重新编辑"));
		solo.goBack();
		op.logout();
		}
	//发布评论特殊字符
	public void testCommentSpecial() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"<h1>abc</h1>";
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("发个评论吧~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("发布评论"));
		Assert.assertTrue(solo.searchText("回复楼主："));
		solo.enterText(0, dateNowStr2);
		Assert.assertTrue(solo.searchEditText(dateNowStr2));
		solo.sleep(3000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("评论成功"));
		Assert.assertTrue(solo.searchText(dateNowStr2));
		op.logout();
		}
	//被禁言用户发布评论
	public void testCommentBan() throws Exception
	{
		op=new Operation(solo);
		op.loginban();
		solo.clickOnText("首页");
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("发个评论吧~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("发布评论"));
		Assert.assertTrue(solo.searchText("回复楼主："));
		solo.enterText(0, dateNowStr);
		Assert.assertTrue(solo.searchEditText(dateNowStr));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("您已被禁言"));	
		op.logout();
	}	
//	//新注册用户发布评论 目前注册有问题 这个先取消了
//	public void testCommentNew() throws Exception
//	{	
//		op=new Operation(solo);
//		op.register();
//		solo.clickOnText("首页");	
//		Date now=new Date();
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateNowStr=sdf.format(now);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
//		solo.sleep(2000);
//		solo.clickOnText("发个评论吧~");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("发布评论"));
//		Assert.assertTrue(solo.searchText("回复楼主："));
//		solo.enterText(0, dateNowStr);
//		Assert.assertTrue(solo.searchEditText(dateNowStr));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
//		solo.waitForText("您是新用户，所发内容正在审核中");
//		op.logout();
//	}
	//评论回复
	public void testCommentReply() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
	//生成格式为下面的当前时间
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("item_comment_content"));
		solo.sleep(2000);
		solo.clickOnText("回复");
		solo.sleep(2000);
		solo.enterText(0, dateNowStr);
		Assert.assertTrue(solo.searchEditText(dateNowStr));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("评论成功"));
		Assert.assertTrue(solo.searchText(dateNowStr));		
		op.logout();
		}
	//评论复制
	public void testCommentCopy() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_content");
		String content=view.getText().toString();
		solo.clickOnView(solo.getView("item_comment_content"));
		solo.sleep(2000);
		solo.clickOnText("复制");
		solo.waitForText("已复制");
		solo.goBack();
		solo.clickOnText("发个评论吧~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("发布评论"));
		Assert.assertTrue(solo.searchText("回复楼主："));
		solo.clickLongOnText("回复楼主：");
		solo.clickOnText("粘贴");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchEditText(content));
		solo.goBack();
		solo.goBack();
		op.logout();		
		}	
	//评论删除
	public void testCommentDel() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("首页");
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_content",0);
		String content=view.getText().toString();
		solo.clickOnView(solo.getView("item_comment_content",0));
		solo.sleep(2000);
		solo.clickOnText("删除");
		solo.waitForText("删除成功！");
		solo.sleep(5000);
		TextView view2=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_content",3);
		String content2=view2.getText().toString();
		Assert.assertFalse(content.equals(content2));
		solo.goBack();
		op.logout();		
		}	
}