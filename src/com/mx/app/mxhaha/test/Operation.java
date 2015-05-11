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
//在原来的类定义上增加extends superClass，即表明该子类继承了superClass类
public class Operation extends ActivityInstrumentationTestCase2 {
	//static表示静态。他是属于类的。可以在本身类里直接调用，或在其它类里用类名.方法名调用。不加static表示是实例的方法，必须用实例来调用。在本类里也一样，必须用实例调用
	//final成员变量表示常量，只能被赋值一次，赋值后值不再改变。
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.mx.app.MxMainActivity";
	//声明一个class类型的变量，用于ActivityInstrumentationTestCase2加载启动被测程序
	private static Class launcherActivityClass;
	//静态初始化块
	//静态加载launcherActivityClass也就是被测主类
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
	//在子类中调用父类被覆盖的实例方法，则可使用super限定来调用父类被覆盖的实例方法，as：super.fly()
	//在构造函数的super，是调用父类的构造函数的意思
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
	
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();  
	    //StringBuffer类中的方法主要偏重于对于字符串的变化，例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别。
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) { 
	    	//nextInt(int n) 方法用于获取一个伪随机，在0(包括)和指定值(不包括)，从此随机数生成器的序列中取出均匀分布的int值。
	        int number = random.nextInt(base.length());
	        //返回指定索引处的char值。索引范围是从0到length() - 1。对于数组索引，序列的第一个char值是在索引为0，索引1，依此类推，
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  

	//目前不用
	public void dragDown() {
		//DisplayMetircs 类可以很方便的获取分辨率。Andorid.util 包下的DisplayMetrics 类提供了一种关于显示的通用信息，如显示大小，分辨率和字体。
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		//因为我们做测试的类是继承于：ActivityInstrumentationTestCase2，不是Activity，所以前面要用getActivity()，否则系统无法找到
		//调用getWindowManager() 之后，会取得现有Activity 的Handle ，此时，getDefaultDisplay() 方法将取得的宽高维度存放于DisplayMetrics 对象中，而取得的宽高维度是以像素为单位(Pixel) ，“像素”所指的是“绝对像素”而非“相对像素”。
		//得到手机屏幕高度：	dm.heightPixels; 得到手机屏幕宽度dm.widthPixels
		int halfheight = dm.heightPixels / 2;
		int halfwidth = dm.widthPixels / 2;
		int squareheight = dm.heightPixels / 4;
		// int squarewidth = dm.widthPixels/4;
		//前2个参数是x，后2个参数是y,最后一个是步数
		solo.drag(halfwidth,halfwidth,squareheight,halfheight,13);
	}

	public void login() {
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(5000);
		if (solo.searchText("等级")) {
			solo.goBack();
		} else {
		solo.clickOnButton("登录/注册");
		solo.sleep(2000);
		assertTrue(solo.searchText("登录"));
		solo.clearEditText(0);
		solo.sleep(2000);
		solo.enterText(0, "zmm@520.com");
		solo.clearEditText(1);
		solo.sleep(2000);
		solo.enterText(1,"111111");
		solo.clickOnButton("登录");
		solo.sleep(20000);
		while(!solo.searchText("等级"))
		{	solo.goBack();
			solo.clickOnButton("登录");
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
		if(solo.searchText("退出登录")){
			solo.clickOnButton("退出登录");
			solo.sleep(2000);
			solo.clickOnButton("确定");
			solo.sleep(9000);
		}
	}
	//被禁言用户登录
	public void loginban() {
		solo.sleep(2000);
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		solo.sleep(5000);
		if (solo.searchText("等级")) {
			solo.clickOnText("退出登录");
			solo.sleep(2000);
			solo.clickOnButton("确定");
			solo.sleep(9000);
		} 
		solo.clickOnButton("登录/注册");
		solo.sleep(2000);
		assertTrue(solo.searchText("登录"));
		solo.clearEditText(0);
		solo.sleep(2000);
		solo.enterText(0, "zmm910@180.com");
		solo.clearEditText(1);
		solo.sleep(2000);
		solo.enterText(1,"111111");
		solo.clickOnButton("登录");
		solo.sleep(20000);
		while(!solo.searchText("等级"))
		{	solo.goBack();
			solo.clickOnButton("登录");
			solo.sleep(20000);
		}	
	}
	
	public void register(){
		solo.sleep(2000);
//	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
//	    Random random = new Random();  
//	    //StringBuffer类中的方法主要偏重于对于字符串的变化，例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别。
//	    StringBuffer sb = new StringBuffer();   
//	    for (int i = 0; i < 6; i++) { 
//	    	//nextInt(int n) 方法用于获取一个伪随机，在0(包括)和指定值(不包括)，从此随机数生成器的序列中取出均匀分布的int值。
//	        int number = random.nextInt(base.length());
//	        //返回指定索引处的char值。索引范围是从0到length() - 1。对于数组索引，序列的第一个char值是在索引为0，索引1，依此类推，
//	        sb.append(base.charAt(number));   
//	    } 
//	    String email=sb.toString();
		TextView view=(TextView)solo.getView("com.mx.app.mxhaha:id/toolbar_unit_text",3);
		solo.clickOnView(view);
		//调用静态类
		String email=Operation.getRandomString(6);
		String email2="zm@"+email+".com";
		String mima="111111";
		solo.sleep(5000);
		if (solo.searchText("等级")) {
			solo.clickOnText("退出登录");
		} 
		solo.clickOnButton("登录/注册");
		solo.sleep(2000);
		solo.clickOnText("免费注册");
		solo.clickOnText("邮箱注册");
		solo.sleep(2000);
		EditText text=(EditText)solo.getEditText("邮箱地址");
		EditText text2=(EditText)solo.getEditText("设置密码");
		solo.enterText(text,email2);
		solo.sleep(2000);
		//密码输入不了 。奇怪，先不管了
		solo.clickOnEditText(1);
		solo.enterText(text2,mima);
		solo.clickOnButton("完成注册");
		solo.sleep(20000);	
	}
	public void closeTab() {
		while (!solo.searchText("New Tab"))
			;
		solo.clickOnView(solo.getView("title"));
	}
}
