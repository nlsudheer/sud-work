package com.example.android.facebook.test;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.android.facebook.base.BaseTest;
import com.example.android.facebook.helpers.FacebookHelpers;
import com.example.android.facebook.pages.HomePage;
import com.example.android.facebook.test.data.LoginData;



@SuppressWarnings("rawtypes")
public class UpdateStatusTest  extends BaseTest{	
	
	protected FacebookHelpers helper;
	
	public UpdateStatusTest() throws Exception {
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
	 * A test that verifies posting the status
	 */
	
	public void testPostStatus() {	
		String statusText = LoginData.VALID_LOGINS;
		String verifyText = HomePage.CHECKIN_TEXT;
		String updateStatus = LoginData.UPDATE_STATUS;
		
		if(!(solo.searchText(statusText))){
			helper.loginFacebook(LoginData.VALID_EMAIL, LoginData.VALID_PASSWORD,  statusText);
		}
		assertTrue("Failed to post the status " + updateStatus, helper.postStatus(statusText, verifyText, updateStatus));
	}
}
