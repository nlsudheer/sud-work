package org.selenium.framework.pages;

import org.openqa.selenium.By;
import org.selenium.framework.baseModules.BasePage;

/**
 * Created by sudheerl on 6/10/14.
 */
public class CastLightPage extends BasePage {

    public String loginPage_emailid =  "#email_login";
    public String loginPage_password = "#password_login";
    public By loginPage_submit_btn = By.cssSelector("#login > fieldset > div.actions > p > input");
    public String loginPage_pagekey = "#tabs_holder > li.tab_home.active";

    public String full_name_menu = "#full_name";
    public String logout_link = "#logout_link";
    public By logout_confirmation = By.cssSelector("a.button.secondary");
    public String change_location = "a.address_popup_trigger";
    public By change_location_typebox = By.cssSelector("input.location_field.ui-autocomplete-input");
    public By change_location_update = By.id("address_submit");
    public By zip_code = By.id("address_text");




}
