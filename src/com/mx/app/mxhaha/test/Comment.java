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
	
	public Comment() throws ClassNotFoundException {
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
	//��������
	public void testComment() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
	//���ɸ�ʽΪ����ĵ�ǰʱ��
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("�������۰�~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��������"));
		Assert.assertTrue(solo.searchText("�ظ�¥����"));
		solo.enterText(0, dateNowStr);
		Assert.assertTrue(solo.searchEditText(dateNowStr));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("���۳ɹ�"));
		Assert.assertTrue(solo.searchText(dateNowStr));
		op.logout();
		}
	//�����������д�
	public void testCommentSensitive() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"4989";
		String dateNowStr3=dateNowStr+"****";
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("�������۰�~");
		solo.sleep(2000);
		solo.enterText(0, dateNowStr2);
		Assert.assertTrue(solo.searchEditText(dateNowStr2));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("���۳ɹ�"));
		Assert.assertTrue(solo.searchText(dateNowStr3));
		op.logout();
		}
	//�������۳���
	public void testCommentLong() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
		String content="����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�����";
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("�������۰�~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��������"));
		Assert.assertTrue(solo.searchText("�ظ�¥����"));
		solo.enterText(0, content);
		Assert.assertTrue(solo.searchEditText(content));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("������������400�֣������±༭"));
		solo.goBack();
		op.logout();
		}
	//�������������ַ�
	public void testCommentSpecial() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"<h1>abc</h1>";
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("�������۰�~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��������"));
		Assert.assertTrue(solo.searchText("�ظ�¥����"));
		solo.enterText(0, dateNowStr2);
		Assert.assertTrue(solo.searchEditText(dateNowStr2));
		solo.sleep(3000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("���۳ɹ�"));
		Assert.assertTrue(solo.searchText(dateNowStr2));
		op.logout();
		}
	//�������û���������
	public void testCommentBan() throws Exception
	{
		op=new Operation(solo);
		op.loginban();
		solo.clickOnText("��ҳ");
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnText("�������۰�~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��������"));
		Assert.assertTrue(solo.searchText("�ظ�¥����"));
		solo.enterText(0, dateNowStr);
		Assert.assertTrue(solo.searchEditText(dateNowStr));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("���ѱ�����"));	
		op.logout();
	}	
//	//��ע���û��������� Ŀǰע�������� �����ȡ����
//	public void testCommentNew() throws Exception
//	{	
//		op=new Operation(solo);
//		op.register();
//		solo.clickOnText("��ҳ");	
//		Date now=new Date();
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateNowStr=sdf.format(now);
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
//		solo.sleep(2000);
//		solo.clickOnText("�������۰�~");
//		solo.sleep(2000);
//		Assert.assertTrue(solo.searchText("��������"));
//		Assert.assertTrue(solo.searchText("�ظ�¥����"));
//		solo.enterText(0, dateNowStr);
//		Assert.assertTrue(solo.searchEditText(dateNowStr));
//		solo.sleep(2000);
//		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
//		solo.waitForText("�������û��������������������");
//		op.logout();
//	}
	//���ۻظ�
	public void testCommentReply() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
	//���ɸ�ʽΪ����ĵ�ǰʱ��
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr=sdf.format(now);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("item_comment_content"));
		solo.sleep(2000);
		solo.clickOnText("�ظ�");
		solo.sleep(2000);
		solo.enterText(0, dateNowStr);
		Assert.assertTrue(solo.searchEditText(dateNowStr));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/comment_send_confirm_btn"));
		Assert.assertTrue(solo.waitForText("���۳ɹ�"));
		Assert.assertTrue(solo.searchText(dateNowStr));		
		op.logout();
		}
	//���۸���
	public void testCommentCopy() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_content");
		String content=view.getText().toString();
		solo.clickOnView(solo.getView("item_comment_content"));
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.waitForText("�Ѹ���");
		solo.goBack();
		solo.clickOnText("�������۰�~");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��������"));
		Assert.assertTrue(solo.searchText("�ظ�¥����"));
		solo.clickLongOnText("�ظ�¥����");
		solo.clickOnText("ճ��");
		solo.sleep(2000);
		Assert.assertTrue(solo.searchEditText(content));
		solo.goBack();
		solo.goBack();
		op.logout();		
		}	
	//����ɾ��
	public void testCommentDel() throws Exception
	{	op=new Operation(solo);
		op.login();
		solo.clickOnText("��ҳ");
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/item_comment_comment_img"));
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_content",0);
		String content=view.getText().toString();
		solo.clickOnView(solo.getView("item_comment_content",0));
		solo.sleep(2000);
		solo.clickOnText("ɾ��");
		solo.waitForText("ɾ���ɹ���");
		solo.sleep(5000);
		TextView view2=(TextView)solo.getView("com.mx.app.mxhaha:id/item_comment_content",3);
		String content2=view2.getText().toString();
		Assert.assertFalse(content.equals(content2));
		solo.goBack();
		op.logout();		
		}	
}