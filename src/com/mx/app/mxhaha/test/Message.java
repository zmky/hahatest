package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;


import android.widget.TextView;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Message extends  ActivityInstrumentationTestCase2 
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
	
	public Message() throws ClassNotFoundException {
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

	//先点击消息后登录
	public void testMessageNoLogin() throws Exception
	{	op=new Operation(solo);
		solo.sleep(2000);
		solo.clickOnText("消息");
		solo.sleep(5000);
		assertTrue(solo.searchText("登录"));
		solo.clearEditText(0);
		solo.sleep(2000);
		solo.enterText(0, "zmm@520.com");
		solo.clearEditText(1);
		solo.sleep(2000);
		solo.enterText(1,"111111");
		solo.clickOnButton("登录");
		solo.sleep(20000);
		while(!solo.searchText("消息"))
		{	solo.goBack();
			solo.clickOnButton("登录");
			solo.sleep(20000);
		}
		Assert.assertTrue(solo.searchText("消息")&&solo.searchText("我收到的评论"));
		Assert.assertTrue(solo.waitForText("没有更多的信息了"));
		op.logout();
				
	}
	
//	//先登录后点击消息再点击我收到的评论
//	public void testMessage() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("消息");
//		assertTrue(solo.searchText("消息")&&solo.searchText("我收到的评论"));
//		solo.clickOnText("我收到的评论");
//		solo.sleep(2000);
//		TextView view1=(TextView)solo.getView("my_comment_light_num_tv",0);
//		String content1=view1.getText().toString();
//		int num1=Integer.parseInt(content1);
//		solo.clickOnView(view1);
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("my_comment_light_num_tv",0);
//		String content2=view2.getText().toString();
//		int num2=Integer.parseInt(content2);
//		//solo.clickOnView(view2);
//		solo.sleep(2000);
//		Assert.assertTrue(num2>=num1);
//		op.logout();
//				
//	}

	//下拉操作
//	public void testMessageUp() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("消息");
//		solo.sleep(2000);
//		solo.drag(500, 500, 520, 1100, 10);
//		solo.waitForText("松开更新内容");
//		solo.sleep(2000);
//		op.logout();
//	}



	
}