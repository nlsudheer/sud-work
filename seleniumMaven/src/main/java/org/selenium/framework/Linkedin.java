package org.selenium.framework;

import au.com.bytecode.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.pages.LinkedinElementsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



public class Linkedin extends BaseTest {
    public LinkedinElementsPage element = new LinkedinElementsPage();


    @Test(enabled = false)
    @Parameters("skip")
	public void linkedinContacts(boolean skip) throws InterruptedException {

		// Thread.sleep(4000);
		browser.open(getConfig("linkedn_contacts_url"));
		browser.click(By.xpath(element.contacts_page));

		System.out.println("At the end of the page");

		String connectionsCount = browser.getText(By.xpath(element.connectionsSize));
		System.out.println("connectionsCount " + connectionsCount);
		boolean count = false;
		int temp = 0; // temp
		while (!count) {

			int iConnectionsCount = Integer.parseInt(connectionsCount);

			int contactsSize = browser.driver.findElements(By.xpath(element.contacts_link)).size();
			browser.driver.findElement(By.xpath(element.contacts_page)).sendKeys(Keys.END);
			System.out.println("connectionsCount " + connectionsCount.getClass());
			System.out.println("iConnectionsCount " + iConnectionsCount);
			System.out.println("iConnectionsCount " + contactsSize);

			if (iConnectionsCount == contactsSize) {
				count = true;
			}
			if (skip) {
				temp++;
				if (temp == 1) { // temp
					break;
				} // temp
			}
		};

		List<WebElement> contacts = browser.driver.findElements(By.xpath(element.contacts_link));
		System.out.println("All contacts list: " + contacts.size());
		System.out.println("All contacts list: " + contacts.getClass());
		System.out.println("All contacts list: " + contacts.getClass().getName());

		List<String> contactsLinks = new ArrayList<String>();
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println("All contacts list: " + contacts.get(i).getAttribute("href"));
			contactsLinks.add(contacts.get(i).getAttribute("href"));

		}

		System.out.println("contactsLinks: " + contactsLinks);

		File directory = new File(new File(".").getAbsolutePath());
		String csv = directory.getParentFile() + getConfig("linkedin_contact_results");
		try {
			List<String[]> data = new ArrayList<String[]>();
			data.add(contactsLinks.toArray(new String[0]));
			CSVWriter writer = new CSVWriter(new FileWriter(csv), '\r');
			writer.writeAll(data);

			writer.close();
		} catch (Exception e) {
			System.out.println("csv file not created at : " + csv + "   due to" + e);
		}

		List<String> con_email1 = new ArrayList<String>();

		int n = 0;
		for (String url : contactsLinks) {

			browser.open(url);
			String[] contacts_elements = {element.profilePage_contacts_info, element.profilePage_contacts_info_one};

			browser.click(By.xpath(browser.foundElement(contacts_elements)));
			try {
				String preInfo = browser.getText(By.xpath(element.contactPreviousBasicInfo)).replaceAll(",", "#");
				con_email1.add(browser.getText(By.xpath(element.profilePage_contacts_name)) + ";"
						+ browser.getText(By.xpath(element.profilePage_contacts_info_email), true) + ";"
						+ browser.getText(By.xpath(element.contactPhoneInfo)) + ";"
						+ browser.getText(By.xpath(element.contactPositionBasicInfo)) + ";" + preInfo + ";" + url); // contactPositionBasicInfo
				
				
				
			} catch (Exception e) {
				System.out.println("Element not visible: exception");
			}
			n++;
			// if (n >= 3) {
			// break;
			// }

		

		System.out.println("con_email: " + con_email1);

//		FileWriter writer = new FileWriter("outFile.txt", true);
//		BufferedWriter out = new BufferedWriter(writer);
		
		File directory_full = new File(new File(".").getAbsolutePath());
		String csv_full = directory_full.getParentFile() + "\\results\\linkedin_output.csv";
		try {
			List<String[]> data = new ArrayList<String[]>();
			data.add(con_email1.toArray(new String[0]));
			CSVWriter writer = new CSVWriter(new FileWriter(csv_full, true), '\r');
			writer.writeNext(con_email1.toArray(new String[0])); //writeAll(data);

			writer.close();
		} catch (Exception e) {
			System.out.println("csv file not created at : " + csv + "   due to" + e);
		}
		}
	}


   @Test
	public void signOut() {
		System.out.println("in method: signOut ");

		browser.waitForElement(By.xpath(element.userNameHover));
		browser.mouseHover(By.xpath(element.userNameHover));
		browser.clickAndWait(By.xpath(element.navSignout));
	}

	@AfterClass
	public void tearDown() {
		browser.driver.close();
		browser.driver.quit();
	}


    @BeforeClass
    public void login() {
		browser.open(getConfig("linkedn_login_url"));

		browser.type(By.xpath(element.loginPage_emailid),getConfig("username"));
		browser.type(By.xpath(element.loginPage_password), getConfig("password"));

		browser.driver.findElement(By.xpath(element.loginPage_submit_btn)).submit();
		browser.waitForElement((element.loginPage_pagekey));
		assert browser.isElementPresent(element.loginPage_pagekey);
        browser.captureScreenshot();
		System.out.println("logged in succesfully");

	}

//	public static void main(String[] args) throws InterruptedException {
//
//        LinkedinTest li = new LinkedinTest();
//		boolean skip = true;
//
//		li.login();
//
//		li.testcase(skip);
//
//		li.signOut();
//		// li.tearDown();
//
//	}
}
