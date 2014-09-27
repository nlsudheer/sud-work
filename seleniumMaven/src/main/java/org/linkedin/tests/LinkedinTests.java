package org.linkedin.tests;

import org.linkedin.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.selenium.framework.baseModules.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by sudheerl on 9/25/14.
 */
public class LinkedinTests extends BaseTest{

    LoginPage login = PageFactory.initElements(browser.driver, LoginPage.class);

    @BeforeClass(enabled = true)
    public void login(){
        login.login(getConfig("username"),getConfig("password"));
    }

    @AfterClass
    public void signOut() {
        System.out.println("in method: signOut");
        login.logout();
    }

    @Test
    public void linkedinContacts(){


    }

}
