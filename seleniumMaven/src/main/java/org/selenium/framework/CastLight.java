package org.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.framework.baseModules.Assert;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.pages.CastLightPage;
import org.selenium.framework.utils.ExcelReader;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by sudheerl on 6/10/14.
 */
public class CastLight extends BaseTest {
    public CastLightPage element = new CastLightPage();
    public ExcelReader excel = new ExcelReader();

    //    @Test
    public void getProcedureLinks() {
        HashMap<String, String> props = new HashMap();
        List<String> links = new ArrayList<>();
        String file = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/cast_light.xls";
        props = excel.getProps(file , "preprod_props");
        login(props.get("cl_username"), props.get("cl_password"));
        String env = props.get("env");
        String patient_id = props.get("patient_id");
        String origin = props.get("origin");
        links =  excel.getColumn(file, "sanity_urls", 0);
        for(String li: links){
            li = li.replace("$env", env);
            li = li.replace("$patient_id", patient_id);
            li = li.replace("$origin", origin);

            browser.open(li);
            browser.captureScreenshot();
            List<String> provider_search_results =  browser.getLinksByLocator(element.provider_search_first_results);
            System.out.println("Search  for the procedure  :" + li);
            System.out.println("Search results for the procedure are :" + provider_search_results);

        }
    }

    @Test
    public void simpleLogin(){
        login(getConfig("cl_username"), getConfig("cl_password"));
        logout();

    }
//    @Test
    public void simpleLoginParallel(){
        HashMap<String, String> props = new HashMap();
        props = getExcelProps();
        Iterator it = props.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            String value = props.get(key);
            System.out.println("Key:  " + key + "Value:" + value);
            login(key, value);
            logout();
        }

    }

    private HashMap<String, String> getExcelProps(){
        HashMap<String, String> excelProps = new HashMap();
        excelProps = excel.getProps(getConfig("basedir") + getConfig("excelFileToRead"), getConfig("excelSheetPropsTest"));
        return excelProps;

    }
    //    @Test
    public void verifyProdSanityTests() {
        HashMap<String, String> props = new HashMap();
        props = getExcelProps();
        Iterator it = props.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            String value = props.get(key);
            System.out.println("Key:  " + key + "Value:" + value);

            login(key, value);
            openAllLinks();
            ChangeLocation();
            logout();
        }
    }


    //    @Test
    public void login(String userName, String passWord){
        browser.open(getConfig("castlight_login_url"));

        browser.type(By.cssSelector(element.loginPage_emailid), userName);
        browser.type(By.cssSelector(element.loginPage_password), passWord);
        browser.driver.findElement((element.loginPage_submit_btn)).submit();
        if(browser.isElementPresent(element.accept_terms_after_login)){
            browser.driver.findElement(element.accept_terms_after_login).submit();
        }
        browser.waitForElement(By.cssSelector(element.loginPage_pagekey));
        assert browser.isElementPresent(By.cssSelector(element.loginPage_pagekey));
        browser.captureScreenshot();
        System.out.println("logged in succesfully");
    }

    //    @Test(dependsOnMethods = "login")
//    @AfterClass
    public void logout(){
        browser.open(getConfig("castlight_homepage_url"));
        browser.mouseHover(By.cssSelector(element.full_name_menu));
        browser.click(By.cssSelector(element.logout_link));
        Assert.assertTrue(browser.isElementPresent((element.loginPage_submit_btn)));
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

    //        @Test(dependsOnMethods = "login")
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
