package org.isdb.tests;

import com.google.common.collect.Table;
import org.isdb.pages.WikipediaPage;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.frameworkException.TableModelException;
import org.selenium.framework.models.TableModel;
import org.selenium.framework.utils.excel.ExcelReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by sudheerl on 9/7/14.
 */
public class ExtractSongInfo extends BaseTest {
    public WikipediaPage element = new WikipediaPage();
    public ExcelReader excel = new ExcelReader();
    TableModel tableModel = new TableModel();

    @AfterClass
    public void tearDown() {
        browser.driver.close();
        browser.driver.quit();
    }

    @Test(dependsOnMethods = "openPage", enabled = false)
    public void getSongtrackInfo() throws TableModelException {


        browser.isElementPresent((element.soundTrackSectionText));
        System.out.println("soundTrackSectionText: " + browser.getText((element.soundTrackSectionText)));

        browser.waitForElement((element.soundTrackListTablebody));
        Table<Integer, Integer, String> tableData;
        tableData = tableModel.getTableDataHashBasedTable(element.soundTrackListTableHeader, element.soundTrackListTablebody);

        System.out.println("audioInfoBoxTable: " + tableData);
        System.out.println("testHashBasedTablem rowKeySet: " + tableData.rowKeySet());
        System.out.println("Header: " + tableData.row(0));
        System.out.println("Header: " + tableData.row(1));
        System.out.println("Header: " + tableData.row(2));
        System.out.println("testHashBasedTable columnKeySet: "+ tableData.columnKeySet());

    }

    @Test(dependsOnMethods = "openPage", enabled = true)
    public void getAudioInfo() throws TableModelException {
        browser.waitForElement((element.audioInfoBoxTable));
        System.out.println("table: " + browser.isElementPresent((element.audioInfoBoxTable)));
        System.out.println("table text: " + browser.getText((element.audioInfoBoxTable)));
    }

    @Test(dependsOnMethods = "openPage")
    public void getMovieInfo() throws TableModelException {
        browser.waitForElement((element.infoBoxTable));
        System.out.println("movie table: " + browser.isElementPresent((element.infoBoxTable)));
        System.out.println("movie table text: " + browser.getText((element.infoBoxTable)));

    }


    @Test
    public void checkDB(){

    }

    @Test(dependsOnMethods = "openPage", enabled = false)
    public void verifyTemp(){
        System.out.println(browser.driver.findElements(element.infoBoxTable));

        System.out.println(browser.driver.findElements(element.infoBoxTableXpath));



    }

    @Test(dependsOnMethods = "checkDB")
    public void openPage(){
        String url = "http://en.wikipedia.org/wiki/Kick_(2014_film)";

        browser.driver.get(url);
        browser.maximize();
        System.out.println(browser.driver.getTitle());

    }
}
