package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.By;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Joke extends  ActivityInstrumentationTestCase2 
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
	
	public Joke() throws ClassNotFoundException {
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
//	//最火下第一个笑话称赞
//	public void testPraise() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		TextView view1=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_green_num",0);
//		String content1=view1.getText().toString();
//		int num1=Integer.parseInt(content1);
//		solo.clickOnView(view1);
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_green_num",0);
//		String content2=view2.getText().toString();
//		int num2=Integer.parseInt(content2);
//		Assert.assertTrue(num2>=num1);		
//	}	
//	//最火下第二个笑话鄙视
//	public void testDespise() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		TextView view1=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_red_num",1);
//		String content1=view1.getText().toString();
//		int num1=Integer.parseInt(content1);
//		solo.clickOnView(view1);
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_red_num",1);
//		String content2=view2.getText().toString();
//		int num2=Integer.parseInt(content2);
//		Assert.assertTrue(num2>=num1);		
//	}	
//	//最火下第一个笑话复制，在详细页的评论框中粘贴，查看文字是否复制正确
//	public void testCopy() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		//笑话内容
//		TextView view1=(TextView)solo.getView("com.mx.app.mxhaha:id/joke_item_content",0);
//		String content1=view1.getText().toString();
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/copy_btn"));
//		Assert.assertTrue(solo.waitForText("已复制"));
//		solo.clickOnView(solo.getView("item_comment_comment_num",0));
//		solo.sleep(2000);
//		solo.clickOnText("发个评论吧~");
//		solo.sleep(2000);
//		solo.clickLongOnView(solo.getView("comment_input_box"));
//		solo.clickOnText("粘贴");
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("comment_input_box");
//		String content2=view2.getText().toString();
//		Assert.assertTrue(content2.contains(content1));
//	}	
	//收藏
	public void testCollect() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		solo.clickOnText("首页");
		TextView view1=(TextView)solo.getView("com.mx.app.mxhaha:id/joke_item_content",0);
		String content1=view1.getText().toString();
		//solo.drag(500, 500, 1100, 520, 10);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/favoriate_btn"));
		//||（短路或）和|（或）都是表示“或”，区别是||只要满足第一个条件，后面的条件就不再判断，而|要对所有的条件进行判断。
		Assert.assertTrue(solo.waitForText("收藏成功"));
		solo.sleep(5000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/favoriate_btn"));
		Assert.assertTrue(solo.waitForText("已收藏"));
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(2000);
		solo.clickOnText("我的收藏");
		Assert.assertTrue(solo.searchText(content1));
		op.logout();
		}
	
//	//取消收藏
//	public void testCollectCancel() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(2000);
//		solo.clickOnText("我的收藏");
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn",0));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/favoriate_btn"));
//		Assert.assertTrue(solo.waitForText("删除收藏成功"));
//		op.logout();		
//	}
//	//举报广告
//	public void testReportAd() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("举报原因"));
//		solo.clickOnText("广告");
//		Assert.assertTrue(solo.waitForText("举报成功"));
//	}
//	//举报看过100遍了
//	public void testReportMore() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("举报原因"));
//		solo.clickOnText("看过100遍了");
//		Assert.assertTrue(solo.waitForText("举报成功"));
//	}
//	//举报不是笑话
//	public void testReportNoJoke() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("举报原因"));
//		solo.clickOnText("不是笑话");
//		Assert.assertTrue(solo.waitForText("举报成功"));
//	}
//	//举报内容不和谐
//	public void testReportBad() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("举报原因"));
//		solo.clickOnText("内容不和谐");
//		Assert.assertTrue(solo.waitForText("举报成功"));
//	}
//	//举报其他原因
//	public void testReportOther() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("举报原因"));
//		solo.clickOnText("其他原因");
//		Assert.assertTrue(solo.waitForText("举报成功"));
//	}
//	public void testShare() throws Exception
//	{
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("微信好友"));
//		Assert.assertTrue(solo.searchText("朋友圈"));
//		Assert.assertTrue(solo.searchText("QQ"));
//		Assert.assertTrue(solo.searchText("QQ空间"));
//		Assert.assertTrue(solo.searchText("新浪微博"));
//		Assert.assertTrue(solo.searchText("取消"));
//	}


}