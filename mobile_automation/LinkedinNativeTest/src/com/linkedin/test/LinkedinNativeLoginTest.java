package com.linkedin.test;


import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;

public class LinkedinNativeLoginTest extends
		ActivityInstrumentationTestCase2 {

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.linkedin.android.authenticator.LaunchActivity";
//	 private static final String TARGET_PACKAGE_ID ="com.facebook.katana";
	private static Class launcherActivityClass;

	static {

		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public LinkedinNativeLoginTest() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		// setUp() is run before a test case is started.
		// This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		// tearDown() is run after a test case has finished.
		// finishOpenedActivities() will finish all the activities that have
		// been opened during the test execution.
		solo.finishOpenedActivities();
	}


	/**
	 * A test that searches for Robotium and asserts that Robotium is found.
	 */
	public void testNativeLoginLinkedin() {
		solo.sleep(3000);
		solo.clearEditText(0);
		solo.enterText(0, "login_signup");
		// solo.enterText("login_username", "login_signup");

	}


}
