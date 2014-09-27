package org.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.selenium.framework.baseModules.BaseLib;

/**
 * Created by sudheerl on 9/25/14.
 */
public class LoginPage extends BaseLib{
// https://www.linkedin.com/
    // @FindBy(css = "button[id='Save']")

    @FindBy(how = How.ID , using = "session_key-login")
    private WebElement emailAddress;

    @FindBy(how = How.ID , using = "session_password-login")
    private WebElement emailPassword;


    @FindBy(how = How.ID , using = "btn-primary")
    private WebElement signInButton;

    @FindBy(how = How.XPATH , using = "//body[@id='pagekey-member-home']")
    private WebElement loginPagekey;

//    public By loginPagekey = By.xpath("//body[@id='pagekey-member-home']");

    @FindBy(how = How.XPATH , using = "//li[@class='nav-item account-settings-tab']/a")
    private WebElement userNameHover;

    @FindBy(how = How.XPATH , using = "//a[@class='account-submenu-split-link']")
    private WebElement navSignout;

    @FindBy(how = How.ID , using = "pagekey-uas-consumer-logout-internal")
    private WebElement logoutPageKey;

    @FindBy(how = How.ID , using = "pagekey-contacts-contacts")
    private WebElement contactsPageKey;

    public String contacts_page = "//div[@id='page']";
    //

    public String homePage_nav_contacts = "//li[@id='nav-primary-contacts']/a/span";
    public String homePage_nav_connections = "//li[@id='nav-primary-contacts']/a/span";
    public String contacts_link = "//h3[@class='name']/a[contains(@href,'/contacts/view?id=')]";

    public String contacstPage_spin_load =  "//div[@class='inf-pagination-loading hidden']/img";

    public String profilePage_contacts_info_one =  "//div[@class='show-more-info relationship-contact']/a/span";
    public String profilePage_contacts_info =  "//div[@class='relationship-header']/a[2]/span[@class='contact']";

    public String[] profilePage_contacts_info_list = {"//div[@class='relationship-header']/a[2]/span[@class='contact']", "//div[@class='show-more-info relationship-contact']/a/span"};
    //div[@id='relationship']/x:div[1]/x:a[2]/x:span[2]				// "//span[@class='contact']"; // "//div[@class='relationship-header']/a[2]";

    public String profilePage_contacts_info_email = "//li[@class='contact-field']/a"; // "//div[@id='relationship-emails-view']/ul";
    // "//div[@id='relationship-emails-view']/ul/li/a"; //"

    public String profilePage_contacts_name =  "//div[@id='name']";

    public String connectionsSize = "//li[@class='contacts_nav_selected']/a/span";

    public String contactPositionBasicInfo = "//div[@id='headline']/p";
    public String contactPreviousBasicInfo = "//tr[@id='overview-summary-past']/td";



    public String contactPhoneInfo = "//div[@id='relationship-phone-numbers-view']/ul/li";


    public void login(String userName, String password){
        browser.open(getConfig("linkedn_login_url"));
        emailAddress.sendKeys(userName);
        emailPassword.sendKeys(password);
        signInButton.submit();
        browser.waitForElement(loginPagekey);
    }

    public void logout() {
        browser.waitForElement(userNameHover);
        browser.mouseHover(userNameHover);
        navSignout.click();
        browser.waitForElement(logoutPageKey);
    }

    public void navigateToContactsPage() {
        browser.open(getConfig("linkedn_contacts_url"));
        browser.waitForElement(contactsPageKey);

    }
}
