package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;


import android.widget.TextView;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Message extends  ActivityInstrumentationTestCase2 
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
	
	public Message() throws ClassNotFoundException {
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

	//�ȵ����Ϣ���¼
	public void testMessageNoLogin() throws Exception
	{	op=new Operation(solo);
		solo.sleep(2000);
		solo.clickOnText("��Ϣ");
		solo.sleep(5000);
		assertTrue(solo.searchText("��¼"));
		solo.clearEditText(0);
		solo.sleep(2000);
		solo.enterText(0, "zmm@520.com");
		solo.clearEditText(1);
		solo.sleep(2000);
		solo.enterText(1,"111111");
		solo.clickOnButton("��¼");
		solo.sleep(20000);
		while(!solo.searchText("��Ϣ"))
		{	solo.goBack();
			solo.clickOnButton("��¼");
			solo.sleep(20000);
		}
		Assert.assertTrue(solo.searchText("��Ϣ")&&solo.searchText("���յ�������"));
		Assert.assertTrue(solo.waitForText("û�и������Ϣ��"));
		op.logout();
				
	}
	
//	//�ȵ�¼������Ϣ�ٵ�����յ�������
//	public void testMessage() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("��Ϣ");
//		assertTrue(solo.searchText("��Ϣ")&&solo.searchText("���յ�������"));
//		solo.clickOnText("���յ�������");
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

	//��������
//	public void testMessageUp() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		solo.clickOnText("��Ϣ");
//		solo.sleep(2000);
//		solo.drag(500, 500, 520, 1100, 10);
//		solo.waitForText("�ɿ���������");
//		solo.sleep(2000);
//		op.logout();
//	}



	
}