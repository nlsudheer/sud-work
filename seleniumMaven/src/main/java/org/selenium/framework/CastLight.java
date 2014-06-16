package org.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.pages.CastLightPage;
import org.selenium.framework.baseModules.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by sudheerl on 6/10/14.
 */
public class CastLight extends BaseTest {
    public CastLightPage element = new CastLightPage();

    @Test
    public void login(){
        browser.openInNewWindow(getConfig("castlight_login_url"));


        browser.type(By.cssSelector(element.loginPage_emailid),getConfig("cl_username"));
        browser.type(By.cssSelector(element.loginPage_password), getConfig("cl_password"));

        browser.driver.findElement((element.loginPage_submit_btn)).submit();
        browser.waitForElement(By.cssSelector(element.loginPage_pagekey));
        assert browser.isElementPresent(By.cssSelector(element.loginPage_pagekey));
        browser.captureScreenshot();
        System.out.println("logged in succesfully");
    }

    //    @Test(dependsOnMethods = "login")
    @AfterClass
    public void logout(){
        browser.open(getConfig("castlight_homepage_url"));
        browser.mouseHover(By.cssSelector(element.full_name_menu));
        browser.click(By.cssSelector(element.logout_link));
        Assert.assertTrue(browser.isElementPresent((element.loginPage_submit_btn)));
    }

    @AfterClass
    public void tearDown() {
        browser.driver.close();
        browser.driver.quit();
    }


//    @Test(dependsOnMethods = "login")
    public void ChangeLocation() {
        String newZip = "94103"; //98004 94103
        String preZip = browser.getText(element.zip_code, true);
        ChangeLocationModule(newZip);
        Assert.assertTrue (browser.getText(element.zip_code, true).contentEquals(newZip));
        ChangeLocationModule(preZip);
        Assert.assertTrue (browser.getText(element.zip_code, true).contentEquals(preZip));
    }
    public void ChangeLocationModule(String newZip) {
        browser.click(By.cssSelector(element.change_location));
        browser.type((element.change_location_typebox), newZip);
        browser.driver.findElement(element.change_location_update).submit();
        browser.waitTillElementPresent(element.change_location_typebox);
        browser.captureScreenshot();
    }

    @Test(dependsOnMethods = "login")
    public void openAllLinks(){
        HashMap<String, String> links = new HashMap<>();
        HashSet<WebElement> li = new HashSet<>();
        String currentPage = browser.driver.getCurrentUrl();
        links = browser.getAllLinksAndText();

        links.remove(null);
        for(String link: links.keySet()) {
            if (link.contains("logout")) {
                continue;
            } else if (link.contains("javascript:;")) {
                continue;
            } else {
                browser.open(link);
                System.out.println("Opened the link with Text: "+ links.get(link) +" - " + link);
                browser.captureScreenshot();
            }
        }
        browser.open(currentPage);
    }

    //    @Test(dependsOnMethods = "login")
    public void openAllLinksOnly(){
        List<String> links = new ArrayList<String>();
        List<String> li = new ArrayList<String>();
        String currentPage = browser.driver.getCurrentUrl();
        li = browser.getAllLinks();

        links = new ArrayList(new HashSet(li)); // removed duplicates
        links.removeAll(Collections.singleton(null)); // remove null values

        for(String link: links ){
            if(link.contains("logout")){
                continue;
            }else if(link.contains("javascript:;")) {
                continue;
            }else {
                browser.open(link);
                System.out.println("Opened the link " + link);
                browser.captureScreenshot();
            }
        }
        browser.open(currentPage);
    }

}
