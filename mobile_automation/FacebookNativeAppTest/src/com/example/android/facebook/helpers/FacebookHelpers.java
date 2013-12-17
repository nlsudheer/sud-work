package com.example.android.facebook.helpers;

import com.example.android.facebook.base.AndroidSolo;
import com.example.android.facebook.base.BaseHelper;
import com.example.android.facebook.base.BaseTest;
import com.example.android.facebook.pages.HomePage;
import com.example.android.facebook.pages.LoginPage;
import com.example.android.facebook.pages.StatusPage;
import com.example.android.facebook.test.data.LoginData;
import com.jayway.android.robotium.solo.Solo;


public class FacebookHelpers {

	private  AndroidSolo solo;

	public FacebookHelpers(AndroidSolo solo) {
		this.solo = solo;
	}
	
	/**
	 * Helper method to post the status
	 * @param validLogin string to verify after the login to assert flow is on home page
	 * @param verifyText text string to verify home page
	 * @param postText text to be updated as a status
	 */
	
	public boolean postStatus(String validLogin, String verifyText, String postText) {		
		solo.waitForText(validLogin, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		solo.searchText(validLogin);
		solo.clickOnText(validLogin);
		solo.waitForText(StatusPage.POST_STATUS_TEXT, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.FALSE);
		solo.clearEditText(StatusPage.STATUS_EDITTEXT);
		solo.enterText(StatusPage.STATUS_EDITTEXT, postText);
		solo.clickOnText(StatusPage.POST_STATUS, StatusPage.POST_STATUS_INDEX);
		solo.sleep(LoginData.TIME_OUT);
		solo.waitForText(verifyText, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		solo.waitForText(postText, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		return solo.searchText(postText, LoginData.TRUE);
	}
	
	/**
	 * Helper method to login into facebook native app
	 * @param loginEmail -- Login Email
	 * @param loginPassword -- Login password
	 * @param expectedMessage -- Expected message after trying to login 
	 * @return true or false  
	 * 
	 */
	
	public boolean loginFacebook(String loginEmail, String loginPassword, String expectedMessage) {
		boolean result;
	
		// logout if already login
		if(solo.searchText(HomePage.CHECKIN_TEXT, LoginData.TRUE)){
			logoutFacebook(LoginData.LOGOUT_MENU_BUTTON);
		}
		solo.clearEditText(LoginPage.EMAIL_TEXT);
		solo.enterText(LoginPage.EMAIL_TEXT, loginEmail);
		solo.enterText(LoginPage.PASSWORD_TEXT, loginPassword);
		solo.clickOnButton(LoginPage.LOGIN_BUTTON);
		solo.waitForText(expectedMessage, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		result = solo.searchText(expectedMessage, LoginData.TRUE);
		if (solo.searchText(LoginPage.ALERT_OK, LoginData.TRUE)){
			solo.clickOnText(LoginPage.ALERT_OK);
		}
		return result;
	}
	
	/**
	 * Helper method to logout from the facebook native app
	 * @param expectedText to log out
	 */
	
	public boolean logoutFacebook(String expectedText){
		boolean result;
		solo.sleep(LoginData.TIME_OUT);
		solo.clickOnImageButton(HomePage.MENU_IMAGE_BUTTON);
		solo.waitForText(LoginData.FAVORITE_MENU_BUTTON, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		solo.scrollToBottom();
		solo.waitForText(expectedText, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		solo.searchText(expectedText, LoginData.TRUE);
		solo.clickOnText(expectedText);
		solo.waitForText(LoginData.LOGOUT_CONFIRM_ALERT, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		solo.clickOnText(LoginData.LOGOUT_CONFIRM_ALERT);
		solo.waitForText(LoginPage.FACEBOOK_TEXT, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		solo.waitForText(LoginData.LOGIN_TEXT, LoginData.MIN_MATCH, LoginData.TIME_OUT, LoginData.FALSE, LoginData.TRUE);
		result = solo.searchText(LoginData.LOGIN_TEXT, LoginData.TRUE);
		return result;
	}
}
