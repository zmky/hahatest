package com.mx.app.mxhaha.test;

import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;

import android.util.DisplayMetrics;
import android.view.KeyEvent;

import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random; 
@SuppressWarnings({ "unchecked", "rawtypes" })
//��ԭ�����ඨ��������extends superClass��������������̳���superClass��
public class Operation extends ActivityInstrumentationTestCase2 {
	//static��ʾ��̬������������ġ������ڱ�������ֱ�ӵ��ã�������������������.���������á�����static��ʾ��ʵ���ķ�����������ʵ�������á��ڱ�����Ҳһ����������ʵ������
	//final��Ա������ʾ������ֻ�ܱ���ֵһ�Σ���ֵ��ֵ���ٸı䡣
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.mx.app.MxMainActivity";
	//����һ��class���͵ı���������ActivityInstrumentationTestCase2���������������
	private static Class launcherActivityClass;
	//��̬��ʼ����
	//��̬����launcherActivityClassҲ���Ǳ�������
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private Solo solo;
	private static final String TAG = "MxHahaTestLog";
	//�������е��ø��౻���ǵ�ʵ�����������ʹ��super�޶������ø��౻���ǵ�ʵ��������as��super.fly()
	//�ڹ��캯����super���ǵ��ø���Ĺ��캯������˼
	public Operation() {
		super(launcherActivityClass);
	}
	//
	public Operation(Solo so) {
		super(launcherActivityClass);
		solo = so;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public int getScreenPixels() {
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;
		return width;
	}
	
	public static String getRandomString(int length) { //length��ʾ�����ַ����ĳ���
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();  
	    //StringBuffer���еķ�����Ҫƫ���ڶ����ַ����ı仯������׷�ӡ������ɾ���ȣ����Ҳ��StringBuffer��String�����Ҫ����
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) { 
	    	//nextInt(int n) �������ڻ�ȡһ��α�������0(����)��ָ��ֵ(������)���Ӵ��������������������ȡ�����ȷֲ���intֵ��
	        int number = random.nextInt(base.length());
	        //����ָ����������charֵ��������Χ�Ǵ�0��length() - 1�������������������еĵ�һ��charֵ��������Ϊ0������1���������ƣ�
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  

	//Ŀǰ����
	public void dragDown() {
		//DisplayMetircs ����Ժܷ���Ļ�ȡ�ֱ��ʡ�Andorid.util ���µ�DisplayMetrics ���ṩ��һ�ֹ�����ʾ��ͨ����Ϣ������ʾ��С���ֱ��ʺ����塣
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		//��Ϊ���������Ե����Ǽ̳��ڣ�ActivityInstrumentationTestCase2������Activity������ǰ��Ҫ��getActivity()������ϵͳ�޷��ҵ�
		//����getWindowManager() ֮�󣬻�ȡ������Activity ��Handle ����ʱ��getDefaultDisplay() ������ȡ�õĿ��ά�ȴ����DisplayMetrics �����У���ȡ�õĿ��ά����������Ϊ��λ(Pixel) �������ء���ָ���ǡ��������ء����ǡ�������ء���
		//�õ��ֻ���Ļ�߶ȣ�	dm.heightPixels; �õ��ֻ���Ļ���dm.widthPixels
		int halfheight = dm.heightPixels / 2;
		int halfwidth = dm.widthPixels / 2;
		int squareheight = dm.heightPixels / 4;
		// int squarewidth = dm.widthPixels/4;
		//ǰ2��������x����2��������y,���һ���ǲ���
		solo.drag(halfwidth,halfwidth,squareheight,halfheight,13);
	}

	public void login() {
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(5000);
		if (solo.searchText("�ȼ�")) {
			solo.goBack();
		} else {
		solo.clickOnButton("��¼/ע��");
		solo.sleep(2000);
		assertTrue(solo.searchText("��¼"));
		solo.clearEditText(0);
		solo.sleep(2000);
		solo.enterText(0, "zmm@520.com");
		solo.clearEditText(1);
		solo.sleep(2000);
		solo.enterText(1,"111111");
		solo.clickOnButton("��¼");
		solo.sleep(20000);
		while(!solo.searchText("�ȼ�"))
		{	solo.goBack();
			solo.clickOnButton("��¼");
			solo.sleep(20000);
		}
		}	
	}

	public void logout() {
		solo.sleep(2000);
		solo.goBack();
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(5000);
		if(solo.searchText("�˳���¼")){
			solo.clickOnButton("�˳���¼");
			solo.sleep(2000);
			solo.clickOnButton("ȷ��");
			solo.sleep(9000);
		}
	}
	//�������û���¼
	public void loginban() {
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(5000);
		if (solo.searchText("�ȼ�")) {
			solo.clickOnText("�˳���¼");
			solo.sleep(2000);
			solo.clickOnButton("ȷ��");
			solo.sleep(9000);
		} 
		solo.clickOnButton("��¼/ע��");
		solo.sleep(2000);
		assertTrue(solo.searchText("��¼"));
		solo.clearEditText(0);
		solo.sleep(2000);
		solo.enterText(0, "zmm910@180.com");
		solo.clearEditText(1);
		solo.sleep(2000);
		solo.enterText(1,"111111");
		solo.clickOnButton("��¼");
		solo.sleep(20000);
		while(!solo.searchText("�ȼ�"))
		{	solo.goBack();
			solo.clickOnButton("��¼");
			solo.sleep(20000);
		}	
	}
	
	public void register(){
		solo.sleep(2000);
//	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
//	    Random random = new Random();  
//	    //StringBuffer���еķ�����Ҫƫ���ڶ����ַ����ı仯������׷�ӡ������ɾ���ȣ����Ҳ��StringBuffer��String�����Ҫ����
//	    StringBuffer sb = new StringBuffer();   
//	    for (int i = 0; i < 6; i++) { 
//	    	//nextInt(int n) �������ڻ�ȡһ��α�������0(����)��ָ��ֵ(������)���Ӵ��������������������ȡ�����ȷֲ���intֵ��
//	        int number = random.nextInt(base.length());
//	        //����ָ����������charֵ��������Χ�Ǵ�0��length() - 1�������������������еĵ�һ��charֵ��������Ϊ0������1���������ƣ�
//	        sb.append(base.charAt(number));   
//	    } 
//	    String email=sb.toString();
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		//���þ�̬��
		String email=Operation.getRandomString(6);
		String email2="zm@"+email+".com";
		String mima="111111";
		solo.sleep(5000);
		if (solo.searchText("�ȼ�")) {
			solo.clickOnText("�˳���¼");
		} 
		solo.clickOnButton("��¼/ע��");
		solo.sleep(2000);
		solo.clickOnText("���ע��");
		solo.clickOnText("����ע��");
		solo.sleep(2000);
		EditText text=(EditText)solo.getEditText("�����ַ");
		EditText text2=(EditText)solo.getEditText("��������");
		solo.enterText(text,email2);
		solo.sleep(2000);
		//�������벻�� ����֣��Ȳ�����
		solo.clickOnEditText(1);
		solo.enterText(text2,mima);
		solo.clickOnButton("���ע��");
		solo.sleep(20000);	
	}
	public void closeTab() {
		while (!solo.searchText("New Tab"))
			;
		solo.clickOnView(solo.getView("title"));
	}
}
