package com.example.android.facebook.test;



import com.example.android.facebook.base.BaseTest;
import com.example.android.facebook.helpers.FacebookHelpers;
import com.example.android.facebook.pages.LoginPage;
import com.example.android.facebook.test.data.LoginData;

import android.test.suitebuilder.annotation.SmallTest;

@SuppressWarnings("rawtypes")
public class NativeAppLoginTest extends BaseTest{	
	
	public FacebookHelpers helper;
	
	public NativeAppLoginTest() throws Exception {
		super();
	}
	
	/**
	 * setUp() is run before a test case is started.
	 * This is where the helper objects are created
	 */
	@Override
	public void setUp() throws Exception{
		super.setUp();
		helper = new FacebookHelpers(solo);
	}
	
	
	/**
	 * A test that verifies error message for invalid login email into facebook
	 */
	
	public void testLoginWithInvalidEmail() {
		assertTrue("Expected Error message  " + LoginData.INCORRECT_EMAIL + "not shown for invalid email", 
				helper.loginFacebook(LoginData.INVALID_EMAIL, LoginData.VALID_PASSWORD, LoginData.INCORRECT_EMAIL));
	}
	
	/**
	 * A test that verifies error message for invalid login password into facebook
	 */
	
	public void testLoginWithInvalidPassword() {
		assertTrue("Expected Error message" + LoginData.INCORRECT_PASSWORD + "not shown for invalid password", 
				helper.loginFacebook(LoginData.VALID_EMAIL, LoginData.INVALID_PASSWORD, LoginData.INCORRECT_PASSWORD));
	}
	
	/**
	 * A test that verifies error message for invalid login password into facebook
	 */
	@SmallTest
	public void testLoginWithInvalidLogins() {
		assertTrue("Expected Error message " + LoginData.INCORRECT_EMAIL + "not shown for invalid email", 
				helper.loginFacebook(LoginData.INVALID_EMAIL, LoginData.INVALID_PASSWORD, LoginData.INCORRECT_EMAIL));
	}
	
	/**
	 * A test that verifies error message for blank login and blank password
	 */
	@SmallTest
	public void testLoginWithBlankLogins() {
		helper.loginFacebook(LoginData.BLANK_EMAIL, LoginData.BLANK_PASSWORD, LoginData.BLANK_LOGINS);
		assertTrue("Expected Error message  " + LoginData.BLANK_LOGINS + "not shown for blank email and password", 
				solo.searchText(LoginPage.SIGNUP_TEXT, LoginData.TRUE));
	}
	
	/**
	 * A test that verifies error message for blank login and blank password
	 */
	@SmallTest
	public void testLoginWithValidLogins() {
		helper.loginFacebook(LoginData.VALID_EMAIL, LoginData.VALID_PASSWORD,  LoginData.VALID_LOGINS);
		assertTrue("Expected message  " + LoginData.VALID_LOGINS + " not shown for valid email", helper.logoutFacebook(LoginData.LOGOUT_MENU_BUTTON));
	}
	
}