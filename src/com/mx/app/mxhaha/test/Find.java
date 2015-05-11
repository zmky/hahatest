package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.By;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Find extends  ActivityInstrumentationTestCase2 
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
	
	public Find() throws ClassNotFoundException {
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

	//检查发现界面UI
	public void testFindUI() throws Exception
	{	op=new Operation(solo);
		solo.sleep(2000);
		solo.clickOnText("发现");
		Assert.assertTrue(solo.searchText("24小时最哈"));
		Assert.assertTrue(solo.searchText("一周最哈"));
		Assert.assertTrue(solo.searchText("热门评论"));
		Assert.assertTrue(solo.searchText("活动专区"));
		Assert.assertTrue(solo.searchText("推荐话题"));
		Assert.assertTrue(solo.searchText("更多热门推荐"));
		Assert.assertTrue(solo.searchText("热门话题"));
				
	}
//	//检查活动页文字
//	public void testaAtivity() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnText("发现");
//		solo.clickOnText("活动专区");
//		//没有活动的时候做这个验证
//		//Assert.assertTrue(solo.waitForWebElement(By.textContent("暂时没有活动，敬请期待")));
//				
//	}	
//	//推荐话题的第一个关注和取消关注之前没有登录
//	public void testTopicRecommandNoLogin() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnText("发现");	
//		solo.sleep(2000);
//		solo.clickOnText("不傲娇就会死");
//		solo.clickOnText("关注");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("登录"));
//		solo.clearEditText(0);
//		solo.sleep(2000);
//		solo.enterText(0, "zmm@520.com");
//		solo.clearEditText(1);
//		solo.sleep(2000);
//		solo.enterText(1,"111111");
//		solo.clickOnButton("登录");
//		solo.sleep(20000);
//		while(!solo.searchText("关注"))
//		{	solo.goBack();
//			solo.clickOnButton("登录");
//			solo.sleep(20000);
//		}
//		solo.clickOnText("关注");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("已关注"));
//		solo.sleep(2000);
//		solo.clickOnText("已关注");
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("navi_menu_txt");
//		String content=view.getText().toString();
//		Assert.assertEquals("关注", content);
//		op.logout();		
//	}
//
//	//推荐话题的第一个关注和取消关注
//	public void testTopicRecommand() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("发现");	
//		solo.sleep(2000);
//		solo.clickOnText("不傲娇就会死");
//		solo.clickOnText("关注");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("已关注"));
//		TextView view1=(TextView)solo.getView("navi_menu_txt");
//		String content1=view1.getText().toString();
//		Assert.assertEquals("已关注", content1);
//		solo.sleep(2000);
//		solo.clickOnText("已关注");
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("navi_menu_txt");
//		String content2=view2.getText().toString();
//		Assert.assertEquals("关注", content2);
//		op.logout();		
//	}
//	//点击更多热门评论中的第2个话题的关注。 imageview不能判断文字的
//	public void testTopicMore()throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("发现");	
//		solo.sleep(2000);
//		solo.clickOnText("更多热门推荐");
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/topic_img_btn",1));
//		solo.sleep(2000);
//		op.logout();
//	}	
//	//点击更多热门评论中的第2个话题的关注。 imageview不能判断文字的
//	public void testTopicMoreNoLogin()throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnText("发现");	
//		solo.sleep(2000);
//		solo.clickOnText("更多热门推荐");
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/topic_img_btn",1));
//		solo.sleep(2000);
//		assertTrue(solo.searchText("登录"));
//		solo.clearEditText(0);
//		solo.sleep(2000);
//		solo.enterText(0, "zmm@520.com");
//		solo.clearEditText(1);
//		solo.sleep(2000);
//		solo.enterText(1,"111111");
//		solo.clickOnButton("登录");
//		solo.sleep(20000);
//		while(!solo.searchText("热门推荐"))
//		{	solo.goBack();
//			solo.clickOnButton("登录");
//			solo.sleep(20000);
//		}
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/topic_img_btn",1));
//		solo.sleep(2000);
//		op.logout();
//	}
}