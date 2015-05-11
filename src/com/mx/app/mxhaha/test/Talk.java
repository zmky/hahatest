package com.mx.app.mxhaha.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;


import android.util.Log;
import android.widget.TextView;

import com.robotium.solo.Solo;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import xuxu.autotest.element.Position;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Talk extends  ActivityInstrumentationTestCase2 
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
	
	public Talk() throws ClassNotFoundException {
	//���ø��������ͬ�βεĹ��캯��
	super(launcherActivityClass);
	}


	private Solo solo;//����Solo
	Operation op=null;
	private static final String TAG="MxHahaTestLog";



	@Override
	public void setUp() throws Exception
	{
		solo = new Solo(getInstrumentation(), getActivity());
	}

//	@Override
//	public void tearDown() throws Exception
//	{
//		solo.finishOpenedActivities();
//	}
	// tearDown
	@Override
	public void tearDown() throws Exception {
		try {
			//finalize���������������ٶ���ʱ�����ͷŸö���ʹ�õ��κ��й���Դ
			solo.finalize();
			solo.finishOpenedActivities();
			//Java�е������쳣������Throwable����������ɵĶ������е��쳣�඼��Throwable����������������ࡣThrowable����Object���ֱ�����࣬Error���Exception����Throwable�������ֱ�����ࡣ
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}
	//��¼��Ц��
	public void testTalk() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,strNowStr);
		//log��ӡ�÷�
		Log.i(TAG,solo.getEditText(0).getText().toString());
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		Assert.assertTrue(solo.searchText(strNowStr));
		op.logout();
	}
	//��¼��Ц��������
	public void testTalkTopic() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		SimpleDateFormat sdf2=new SimpleDateFormat("mm:ss");
		String strNowStr=sdf.format(now);
		String strNowStr2=sdf2.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnText("���ѡ����");
		solo.enterText(0, strNowStr2);
		solo.sleep(2000);
		solo.clickOnText("ȷ��");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		Assert.assertTrue(solo.searchText(strNowStr));
		op.logout();
	}
	//��¼��Ц�����д�
	public void testTalkSensitive() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"4989";
		String dateNowStr3=dateNowStr+"****";
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,dateNowStr2);
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		Assert.assertTrue(solo.searchText(dateNowStr2));
		solo.sleep(2000);
		solo.drag(500, 500, 520, 1100, 10);
		solo.waitForText("�ɿ���������");
		solo.sleep(9000);
		solo.waitForText(dateNowStr3);
		op.logout();
	}
	//��¼��Ц������
	public void testTalkLong() throws Exception
	{
		op=new Operation(solo);
		String content="����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�����a����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�gc�ǳԷ�ʱ������үү����˵���Ұְ��ڴ���׽���󣬿������ˡ�������ҡ���ˣ���ʱ�Ǹ��尡�� ����ͻȻ���𡭿�3��Ů���Ѿ����ˣ����ǵ����ź����룬�����е��Ů���ʰְ��ں���������˵׽����Ҫ��Ȼ��ҧ��ģ�Ȼ�����Ͳ����ˡ�����b";
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,content);
		solo.sleep(2000);
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�ף�ÿ��Ц������800��Ŷ�������±༭���ٷ�"));
		op.logout();
	}
	//��¼��Ц�������ַ�
	public void testTalkSpecial() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String dateNowStr=sdf.format(now);
		String dateNowStr2=dateNowStr+"<h1>abc</h1>";
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,dateNowStr2);
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		Assert.assertTrue(solo.searchText(dateNowStr2));
		op.logout();
	}
	//�������û���¼��Ц��
	public void testTalkBan() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.loginban();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("������˼Ŷ,���ѱ�����"));
		op.logout();
	}
	//��¼��������Ц��
	public void testTalkAnonymous() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnCheckBox(0);
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		solo.sleep(3000);
		Assert.assertTrue(solo.searchText(strNowStr));
		solo.sleep(2000);
//		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/header_nickname");
//		String nickname=view.getText().toString();
//		Assert.assertEquals("����", nickname);
		op.logout();
	}
	//��¼�����ս�Ц�� ĿǰŪ����
	public void testTalkPic() throws Exception
	{
		op=new Operation(solo);
		Position position=new Position();
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_camera_img"));
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		solo.sleep(3000);
		Assert.assertTrue(solo.searchText(strNowStr));
		solo.sleep(2000);
		op.logout();
	}
	//��¼���ϴ�����ͼƬ��Ц�� ĿǰŪ����
	public void testTalkPicLocal() throws Exception
	{
		op=new Operation(solo);
		Position position=new Position();
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		solo.enterText(0,strNowStr);
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_album_img"));
		solo.sleep(2000);
		solo.clickOnText("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		solo.sleep(3000);
		Assert.assertTrue(solo.searchText(strNowStr));
		solo.sleep(2000);
		op.logout();
	}
	//��¼�󷢲�����Ц��С��1s
	public void testTalkVoiceLessOne() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		//�����һ��
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("¼������Ц��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		//������Լ�д�Ŀؼ� ����������
//		Assert.assertTrue(solo.searchText("�60��"));
		//�����ס˵����ť
		solo.clickOnScreen(600, 1300);
		Assert.assertTrue(solo.waitForText("ʱ��̫�̣�������¼��"));
		solo.goBack();
		op.logout();
	}
	//��¼�󷢲�����Ц��
	public void testTalkVoice() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		//�����һ��
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("¼������Ц��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		//������Լ�д�Ŀؼ� ����������
//		Assert.assertTrue(solo.searchText("�60��"));
		//�����ס˵����ť,���һ��������ʱ��6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnButton("����");
		solo.clickOnText("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		op.logout();
	}
	//��¼����¼����Ц��ȷ��������
	public void testTalkVoiceAgain() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		//�����һ��
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("¼������Ц��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		//�����ס˵����ť,���һ��������ʱ��6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnButton("��¼");
		Assert.assertTrue(solo.searchText("��ǰ���ݽ�����գ�ȷ������¼��?"));
		Assert.assertTrue(solo.searchText("������ʾ"));
		solo.sleep(2000);
		solo.clickOnButton("ȷ��");
		solo.sleep(2000);
		solo.goBack();
		op.logout();
	}
	//��¼����¼����Ц��ȡ��������
	public void testTalkVoiceCancel() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		//�����һ��
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("¼������Ц��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		//�����ס˵����ť,���һ��������ʱ��6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnButton("��¼");
		Assert.assertTrue(solo.searchText("��ǰ���ݽ�����գ�ȷ������¼��?"));
		Assert.assertTrue(solo.searchText("������ʾ"));
		solo.sleep(2000);
		solo.clickOnButton("ȡ��");
		solo.sleep(2000);
		solo.goBack();
		Assert.assertTrue(solo.searchText("��ǰ������δ������ȷ���˳�?"));
		Assert.assertTrue(solo.searchText("������ʾ"));
		solo.clickOnButton("ȷ��");
		solo.sleep(2000);		
		op.logout();
	}
	//��¼����¼����Ц����ɺ��������ķ���
	public void testTalkVoiceBack() throws Exception
	{
		op=new Operation(solo);
		solo.sleep(2000);
		op.login();
		//�����һ��
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("¼������Ц��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		//�����ס˵����ť,���һ��������ʱ��6s
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnText("¼������Ц��");
		Assert.assertTrue(solo.searchText("��ǰ������δ������ȷ���˳�?"));
		Assert.assertTrue(solo.searchText("������ʾ"));
		solo.clickOnButton("ȷ��");
		solo.sleep(2000);		
		op.logout();
	}
	//��¼�󷢲�����Ц��������
	public void testTalkVoiceTopic() throws Exception
	{
		op=new Operation(solo);
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
		String strNowStr=sdf.format(now);
		solo.sleep(2000);
		op.login();
		//�����һ��
		solo.clickOnScreen(500, 1800);
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("��һ��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		Assert.assertTrue(solo.searchEditText("�������Ц��"));
		solo.clickOnView(solo.getView("com.mx.app.mxhaha:id/publish_voice_btn"));
		solo.sleep(2000);
		Assert.assertTrue(solo.searchText("¼������Ц��"));
		Assert.assertTrue(solo.searchText("���ѡ����"));
		solo.clickLongOnScreen(600, 1300,6000);
		solo.sleep(2000);
		solo.clickOnText("���ѡ����");
		solo.enterText(0, strNowStr);
		solo.sleep(2000);
		solo.clickOnText("ȷ��");
		solo.clickOnButton("����");
		Assert.assertTrue(solo.waitForText("�����ɹ�"));
		op.logout();
	}
}
