package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.By;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Joke extends  ActivityInstrumentationTestCase2 
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
	
	public Joke() throws ClassNotFoundException {
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
//	//����µ�һ��Ц������
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
//	//����µڶ���Ц������
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
//	//����µ�һ��Ц�����ƣ�����ϸҳ�����ۿ���ճ�����鿴�����Ƿ�����ȷ
//	public void testCopy() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		//Ц������
//		TextView view1=(TextView)solo.getView("com.mx.app.mxhaha:id/joke_item_content",0);
//		String content1=view1.getText().toString();
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/copy_btn"));
//		Assert.assertTrue(solo.waitForText("�Ѹ���"));
//		solo.clickOnView(solo.getView("item_comment_comment_num",0));
//		solo.sleep(2000);
//		solo.clickOnText("�������۰�~");
//		solo.sleep(2000);
//		solo.clickLongOnView(solo.getView("comment_input_box"));
//		solo.clickOnText("ճ��");
//		solo.sleep(2000);
//		TextView view2=(TextView)solo.getView("comment_input_box");
//		String content2=view2.getText().toString();
//		Assert.assertTrue(content2.contains(content1));
//	}	
	//�ղ�
	public void testCollect() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		solo.clickOnText("��ҳ");
		TextView view1=(TextView)solo.getView("com.mx.app.mxhaha:id/joke_item_content",0);
		String content1=view1.getText().toString();
		//solo.drag(500, 500, 1100, 520, 10);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/favoriate_btn"));
		//||����·�򣩺�|���򣩶��Ǳ�ʾ���򡱣�������||ֻҪ�����һ������������������Ͳ����жϣ���|Ҫ�����е����������жϡ�
		Assert.assertTrue(solo.waitForText("�ղسɹ�"));
		solo.sleep(5000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/favoriate_btn"));
		Assert.assertTrue(solo.waitForText("���ղ�"));
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(2000);
		solo.clickOnText("�ҵ��ղ�");
		Assert.assertTrue(solo.searchText(content1));
		op.logout();
		}
	
//	//ȡ���ղ�
//	public void testCollectCancel() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		op.login();
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
//		solo.clickOnView(view);
//		solo.sleep(2000);
//		solo.clickOnText("�ҵ��ղ�");
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn",0));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/favoriate_btn"));
//		Assert.assertTrue(solo.waitForText("ɾ���ղسɹ�"));
//		op.logout();		
//	}
//	//�ٱ����
//	public void testReportAd() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("�ٱ�ԭ��"));
//		solo.clickOnText("���");
//		Assert.assertTrue(solo.waitForText("�ٱ��ɹ�"));
//	}
//	//�ٱ�����100����
//	public void testReportMore() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("�ٱ�ԭ��"));
//		solo.clickOnText("����100����");
//		Assert.assertTrue(solo.waitForText("�ٱ��ɹ�"));
//	}
//	//�ٱ�����Ц��
//	public void testReportNoJoke() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("�ٱ�ԭ��"));
//		solo.clickOnText("����Ц��");
//		Assert.assertTrue(solo.waitForText("�ٱ��ɹ�"));
//	}
//	//�ٱ����ݲ���г
//	public void testReportBad() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("�ٱ�ԭ��"));
//		solo.clickOnText("���ݲ���г");
//		Assert.assertTrue(solo.waitForText("�ٱ��ɹ�"));
//	}
//	//�ٱ�����ԭ��
//	public void testReportOther() throws Exception
//	{
//		op=new Operation(solo);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/report_btn"));
//		Assert.assertTrue(solo.waitForText("�ٱ�ԭ��"));
//		solo.clickOnText("����ԭ��");
//		Assert.assertTrue(solo.waitForText("�ٱ��ɹ�"));
//	}
//	public void testShare() throws Exception
//	{
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/more_share_btn"));
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("΢�ź���"));
//		Assert.assertTrue(solo.searchText("����Ȧ"));
//		Assert.assertTrue(solo.searchText("QQ"));
//		Assert.assertTrue(solo.searchText("QQ�ռ�"));
//		Assert.assertTrue(solo.searchText("����΢��"));
//		Assert.assertTrue(solo.searchText("ȡ��"));
//	}


}