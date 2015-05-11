package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.By;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Find extends  ActivityInstrumentationTestCase2 
{	//Main activity��Ϣ
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME ="com.mx.app.MxMainActivity" ;

	private static Class launcherActivityClass;
	static {
	try {
	// ��Ҫ����Class.forName(xxx.xx.xx)���ص���һ����Class.forName(xxx.xx.xx)��������Ҫ��JVM���Ҳ�����ָ�����࣬Ҳ����˵JVM��ִ�и���ľ�̬�����
	launcherActivityClass = Class
	.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
	} catch (ClassNotFoundException e) {
	throw new RuntimeException(e);
	}
	}
	
	public Find() throws ClassNotFoundException {
	super(launcherActivityClass);
	}


	private Solo solo;//����Solo
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

	//��鷢�ֽ���UI
	public void testFindUI() throws Exception
	{	op=new Operation(solo);
		solo.sleep(2000);
		solo.clickOnText("����");
		Assert.assertTrue(solo.searchText("24Сʱ���"));
		Assert.assertTrue(solo.searchText("һ�����"));
		Assert.assertTrue(solo.searchText("��������"));
		Assert.assertTrue(solo.searchText("�ר��"));
		Assert.assertTrue(solo.searchText("�Ƽ�����"));
		Assert.assertTrue(solo.searchText("���������Ƽ�"));
		Assert.assertTrue(solo.searchText("���Ż���"));
				
	}
//	//���ҳ����
//	public void testaAtivity() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnText("����");
//		solo.clickOnText("�ר��");
//		//û�л��ʱ���������֤
//		//Assert.assertTrue(solo.waitForWebElement(By.textContent("��ʱû�л�������ڴ�")));
//				
//	}	
//	//�Ƽ�����ĵ�һ����ע��ȡ����ע֮ǰû�е�¼
//	public void testTopicRecommandNoLogin() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnText("����");	
//		solo.sleep(2000);
//		solo.clickOnText("�������ͻ���");
//		solo.clickOnText("��ע");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("��¼"));
//		solo.clearEditText(0);
//		solo.sleep(2000);
//		solo.enterText(0, "zmm@520.com");
//		solo.clearEditText(1);
//		solo.sleep(2000);
//		solo.enterText(1,"111111");
//		solo.clickOnButton("��¼");
//		solo.sleep(20000);
//		while(!solo.searchText("��ע"))
//		{	solo.goBack();
//			solo.clickOnButton("��¼");
//			solo.sleep(20000);
//		}
//		solo.clickOnText("��ע");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("�ѹ�ע"));
//		solo.sleep(2000);
//		solo.clickOnText("�ѹ�ע");
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("navi_menu_txt");
//		String content=view.getText().toString();
//		Assert.assertEquals("��ע", content);
//		op.logout();		
//	}
//
//	//�Ƽ�����ĵ�һ����ע��ȡ����ע
//	public void testTopicRecommand() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("����");	
//		solo.sleep(2000);
//		solo.clickOnText("�������ͻ���");
//		solo.clickOnText("��ע");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("�ѹ�ע"));
//		TextView view1=(TextView)solo.getView("navi_menu_txt");
//		String content1=view1.getText().toString();
//		Assert.assertEquals("�ѹ�ע", content1);
//		solo.sleep(2000);
//		solo.clickOnText("�ѹ�ע");
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("navi_menu_txt");
//		String content2=view2.getText().toString();
//		Assert.assertEquals("��ע", content2);
//		op.logout();		
//	}
//	//����������������еĵ�2������Ĺ�ע�� imageview�����ж����ֵ�
//	public void testTopicMore()throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("����");	
//		solo.sleep(2000);
//		solo.clickOnText("���������Ƽ�");
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/topic_img_btn",1));
//		solo.sleep(2000);
//		op.logout();
//	}	
//	//����������������еĵ�2������Ĺ�ע�� imageview�����ж����ֵ�
//	public void testTopicMoreNoLogin()throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnText("����");	
//		solo.sleep(2000);
//		solo.clickOnText("���������Ƽ�");
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/topic_img_btn",1));
//		solo.sleep(2000);
//		assertTrue(solo.searchText("��¼"));
//		solo.clearEditText(0);
//		solo.sleep(2000);
//		solo.enterText(0, "zmm@520.com");
//		solo.clearEditText(1);
//		solo.sleep(2000);
//		solo.enterText(1,"111111");
//		solo.clickOnButton("��¼");
//		solo.sleep(20000);
//		while(!solo.searchText("�����Ƽ�"))
//		{	solo.goBack();
//			solo.clickOnButton("��¼");
//			solo.sleep(20000);
//		}
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/topic_img_btn",1));
//		solo.sleep(2000);
//		op.logout();
//	}
}