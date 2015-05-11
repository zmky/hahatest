package com.mx.app.mxhaha.test;

import org.junit.Assert;

import android.test.ActivityInstrumentationTestCase2;



import com.robotium.solo.Solo;

import android.widget.TextView;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class My extends  ActivityInstrumentationTestCase2 
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
	
	public My() throws ClassNotFoundException {
		//super��Ӳ��������������ø����о�����ͬ��ʽ�� ���캯��
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
	
	public void testMyJoke() throws Exception
	{	op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(2000);
		solo.clickOnText("�ҷ�����Ц��");
		solo.sleep(2000);
		assertTrue(solo.searchText("�ҵĹ���"));
		solo.sleep(2000);
		solo.clickOnText("�ҵĹ���");
		Assert.assertTrue(solo.searchText("�ȼ�")&&solo.searchText("����"));
		op.logout();			
	}
	
//	public void testMyComment() throws Exception
//	{	op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(2000);
//		solo.clickOnText("�ҷ���������");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("�ҷ���������"));
//		//������һ������
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
//		solo.clickOnText("�ҵ��ղ�");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("�ҵ��ղ�"));
//		solo.sleep(2000);
//		solo.clickOnText("�ҵ��ղ�");
//		solo.sleep(2000);
//		assertTrue(solo.searchText("�ȼ�"));
//		op.logout();
//				
//	}
//	
//	public void testMyJokeNoLogin() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("�ҷ�����Ц��");
//			solo.sleep(2000);
//			assertTrue(solo.searchText("��¼"));
//				
//	}
//	
//	public void testMyCommentNoLogin() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("�ҷ���������");
//			solo.sleep(2000);
//			assertTrue(solo.searchText("��¼"));
//				
//	}
//	
//	public void testMyFavNoLogin() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("�ҵ��ղ�");
//			solo.sleep(2000);
//			assertTrue(solo.searchText("��¼"));
//				
//	}
//	
//	//ʡ��ģʽ
//	public void testMySettingFlowPattern() throws Exception
//	{		solo.sleep(2000);
//			TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//			solo.clickOnView(view);
//			solo.sleep(5000);
//			solo.clickOnText("����");
//			solo.sleep(2000);
//			solo.searchText("ʡ��ģʽ");
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
//	//�������ȡ��
//	public void testClearCacheCancel() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("����");
//		solo.sleep(2000);
//		solo.searchText("�������");
//		solo.sleep(2000);
//		TextView view1=(TextView)solo.getView("cache_size");
//		String content1=view1.getText().toString();
//		double num=Double.parseDouble(content1.substring(0,(content1.length()-2)));
//		solo.clickOnText("�������");
//		solo.sleep(1000);
//		Assert.assertTrue(solo.searchText("������ʾ")&&solo.searchText("���������л���"));
//		solo.clickOnText("ȡ��");
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("cache_size");
//		String content2=view2.getText().toString();
//		double num2=Double.parseDouble(content2.substring(0,(content2.length()-2)));
//		//assertEquals(double expected,double actul) ��������,����assertEquals(double expected,double actul,double delta)
//		//Ҳ������ԭ���ķ����ϼ�һ�����ֵ��double���ͣ�
//		Assert.assertEquals(num,num2,0);		
//		
//	}
//	
//	
//	//�������ȷ��
//	public void testClearCacheOk() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("����");
//		solo.sleep(2000);
//		solo.searchText("�������");
//		solo.sleep(2000);
//		solo.clickOnText("�������");
//		solo.sleep(1000);
//		solo.clickOnText("ȷ��");
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
//		solo.clickOnText("����");
//		solo.sleep(2000);
//		solo.clickOnText("�������");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("��������Ҫ����������")&&solo.searchText("��������ϵ��ʽ"));		
//		
//	}
//	
//	//�ύ����ɹ�
//	public void testSuggest() throws Exception
//	{
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("����");
//		solo.sleep(2000);
//		solo.clickOnText("�������");
//		solo.sleep(2000);
//		solo.enterText(0,"test3");
//		solo.sleep(2000);
//		solo.enterText(1, "lianxi");
//		solo.sleep(2000);
//		solo.clickOnText("�ύ");
//		//�ȴ�ָ�����ı����֡�Ĭ�ϵĳ�ʱʱ����20�롣
//		Assert.assertTrue(solo.waitForText("��������ύ�ɹ�"));
//		
//	}
//	
//	//��������Ϊ��
//	public void testSuggestNull() throws Exception
//	{
//		solo.sleep(2000);
//		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(5000);
//		solo.clickOnText("����");
//		solo.sleep(2000);
//		solo.clickOnText("�������");
//		solo.sleep(2000);
//		solo.clickOnText("�ύ");
//		Assert.assertTrue(solo.waitForText("�������ݲ���Ϊ��"));
//	}
}