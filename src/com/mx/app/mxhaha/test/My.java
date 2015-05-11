package com.mx.app.mxhaha.test;

import org.junit.Assert;

import android.test.ActivityInstrumentationTestCase2;



import com.robotium.solo.Solo;

import android.widget.TextView;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class My extends  ActivityInstrumentationTestCase2 
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
	
	public My() throws ClassNotFoundException {
		//super后加参数的是用来调用父类中具有相同形式的 构造函数
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
	
	public void testMyJoke() throws Exception
	{	op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(2000);
		solo.clickOnText("我发布的笑话");
		solo.sleep(2000);
		assertTrue(solo.searchText("我的哈哈"));
		solo.sleep(2000);
		solo.clickOnText("我的哈哈");
		Assert.assertTrue(solo.searchText("等级")&&solo.searchText("哈分"));
		op.logout();			
	}
	
//	public void testMyComment() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(2000);
//		solo.clickOnText("我发布的评论");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("我发布的评论"));
//		//点亮第一个评论
//		TextView view1=(TextView)solo.getView("my_comment_light_num_tv",0);
//		String content=view1.getText().toString();
//		int num=Integer.parseInt(content);
//		solo.clickOnView(view1);
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("my_comment_light_num_tv",0);
//		String content2=view2.getText().toString();
//		int num2=Integer.parseInt(content2);
//		Assert.assertTrue(num2>=num);
//		solo.sleep(2000);
//		op.logout();
//								
//	}
//	
//	public void testMyFav() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(2000);
//		solo.clickOnText("我的收藏");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("我的收藏"));
//		solo.sleep(2000);
//		solo.clickOnText("我的收藏");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("等级"));
//		op.logout();
//				
//	}
//	
//	public void testMyJokeNoLogin() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("我发布的笑话");
//			solo.sleep(2000);
//			assertTrue(solo.searchText("登录"));
//				
//	}
//	
//	public void testMyCommentNoLogin() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("我发布的评论");
//			solo.sleep(2000);
//			assertTrue(solo.searchText("登录"));
//				
//	}
//	
//	public void testMyFavNoLogin() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("我的收藏");
//			solo.sleep(2000);
//			assertTrue(solo.searchText("登录"));
//				
//	}
//	
//	//省流模式
//	public void testMySettingFlowPattern() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("设置");
//			solo.sleep(2000);
//			solo.searchText("省流模式");
//			solo.clickOnCheckBox(0);
//			solo.sleep(2000);
//			assertTrue(solo.isCheckBoxChecked(0));
//			solo.sleep(2000);
//			solo.clickOnCheckBox(0);
//			solo.sleep(2000);
//			Assert.assertFalse(solo.isCheckBoxChecked(0));	
//			//assertFalse(solo.isCheckBoxChecked(0));							
//	}
//	
//	//清除缓存取消
//	public void testClearCacheCancel() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("设置");
//		solo.sleep(2000);
//		solo.searchText("清除缓存");
//		solo.sleep(2000);
//		TextView view1=(TextView)solo.getView("cache_size");
//		String content1=view1.getText().toString();
//		double num=Double.parseDouble(content1.substring(0,(content1.length()-2)));
//		solo.clickOnText("清除缓存");
//		solo.sleep(1000);
//		Assert.assertTrue(solo.searchText("哈哈提示")&&solo.searchText("点击清除所有缓存"));
//		solo.clickOnText("取消");
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("cache_size");
//		String content2=view2.getText().toString();
//		double num2=Double.parseDouble(content2.substring(0,(content2.length()-2)));
//		//assertEquals(double expected,double actul) 被废弃了,换成assertEquals(double expected,double actul,double delta)
//		//也就是在原来的方法上加一个误差值（double类型）
//		Assert.assertEquals(num,num2,0);		
//		
//	}
//	
//	
//	//清除缓存确定
//	public void testClearCacheOk() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("设置");
//		solo.sleep(2000);
//		solo.searchText("清除缓存");
//		solo.sleep(2000);
//		solo.clickOnText("清除缓存");
//		solo.sleep(1000);
//		solo.clickOnText("确定");
//		solo.sleep(2000);
//		TextView view1=(TextView)solo.getView("cache_size");
//		String content1=view1.getText().toString();
//		double num=Double.parseDouble(content1.substring(0,(content1.length()-2)));	
//		Assert.assertEquals(0.0,num,0);
//		
//	}
//	
//	public void testSuggestUI() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("设置");
//		solo.sleep(2000);
//		solo.clickOnText("意见反馈");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("请输入您要反馈的问题")&&solo.searchText("请输入联系方式"));		
//		
//	}
//	
//	//提交意见成功
//	public void testSuggest() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("设置");
//		solo.sleep(2000);
//		solo.clickOnText("意见反馈");
//		solo.sleep(2000);
//		solo.enterText(0,"test3");
//		solo.sleep(2000);
//		solo.enterText(1, "lianxi");
//		solo.sleep(2000);
//		solo.clickOnText("提交");
//		//等待指定的文本出现。默认的超时时间是20秒。
//		Assert.assertTrue(solo.waitForText("您的意见提交成功"));
//		
//	}
//	
//	//反馈内容为空
//	public void testSuggestNull() throws Exception
//	{
//		solo.sleep(2000);
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("设置");
//		solo.sleep(2000);
//		solo.clickOnText("意见反馈");
//		solo.sleep(2000);
//		solo.clickOnText("提交");
//		Assert.assertTrue(solo.waitForText("反馈内容不能为空"));
//	}
}