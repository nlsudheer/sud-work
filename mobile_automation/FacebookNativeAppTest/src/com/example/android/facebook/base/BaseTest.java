package com.example.android.facebook.base;

import android.test.ActivityInstrumentationTestCase2;

import com.example.android.facebook.base.AndroidSolo;
import com.example.android.facebook.helpers.FacebookHelpers;
import com.jayway.android.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class BaseTest extends ActivityInstrumentationTestCase2{

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.facebook.katana.FacebookLoginActivity";
	private static final String TARGET_PACKAGE_ID ="com.facebook.katana";
	private static Class launcherActivityClass;

	static {

		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	

	public AndroidSolo solo;
	public BaseHelper baseHelper;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public BaseTest() throws ClassNotFoundException,Exception {
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}
	
	
	/**
	 * setUp() is run before a test case is started.
	 * This is where the solo object is created.
	 */
	
	@Override
	protected void setUp() throws Exception {
		solo = new AndroidSolo(getInstrumentation(), getActivity());
		baseHelper = new BaseHelper(solo);
		System.out.println("In BaseTest setup");
	}



	/**
	 * tearDown() is run after a test case has finished.
	 * finishOpenedActivities() will finish all the activities that have been opened during the test execution.
	 */
	
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}
