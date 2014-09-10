package org.linkedin.pages;


import org.openqa.selenium.By;

public class LinkedinElementsPage {
	
//	By by = new By();
	
//	public By loginPage_emailid =  "//input[@name='session_key']";
	
	public String loginPage_emailid =  "//input[@name='session_key']";
	public String loginPage_password = "//input[@name='session_password']";  
	public String loginPage_submit_btn = "//input[@id='btn-primary']";
	public By loginPage_pagekey = By.xpath("//body[@id='pagekey-member-home']");
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
	
	public String userNameHover = "//li[@class='nav-item account-settings-tab']/a";
	
	public String navSignout = "//a[@class='account-submenu-split-link']";
	
	public String contactPhoneInfo = "//div[@id='relationship-phone-numbers-view']/ul/li";
	
}
