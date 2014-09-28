package org.isdb.tests;

import com.google.common.collect.Table;
import org.apache.poi.ss.usermodel.Workbook;
import org.isdb.pages.WikipediaPage;
import org.openqa.selenium.support.PageFactory;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.frameworkException.ExcelException;
import org.selenium.framework.frameworkException.TableModelException;
import org.selenium.framework.models.TableModel;
import org.selenium.framework.utils.excel.ExcelReader;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sudheerl on 9/7/14.
 */
public class ExtractSongInfo extends BaseTest {
    public WikipediaPage element = new WikipediaPage();
    public ExcelReader excel = new ExcelReader();
    TableModel tableModel = new TableModel();
    WikipediaPage wikiPage = PageFactory.initElements(browser.driver, WikipediaPage.class);

    //    @Test(dependsOnMethods = "openPage", enabled = false)
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

    //    @Test(dependsOnMethods = "openPage", enabled = true)
    public void getAudioInfo() throws TableModelException {
        browser.waitForElement((element.audioInfoBoxTable));
        System.out.println("table: " + browser.isElementPresent((element.audioInfoBoxTable)));
        System.out.println("table text: " + browser.getText((element.audioInfoBoxTable)));
    }

    //    @Test(dependsOnMethods = "openPage")
    public void getMovieInfo() throws TableModelException {
        browser.waitForElement((element.infoBoxTable));
        System.out.println("movie table: " + browser.isElementPresent((element.infoBoxTable)));
        System.out.println("movie table text: " + browser.getText((element.infoBoxTable)));

    }


    //    @Test
    public void checkDB(){

    }

    //    @Test(dependsOnMethods = "openPage", enabled = false)
    public void verifyTemp(){
        System.out.println(browser.driver.findElements(element.infoBoxTable));

        System.out.println(browser.driver.findElements(element.infoBoxTableXpath));



    }

    //    @Test(dependsOnMethods = "checkDB")
    public void openPage(String url){
//        String url = "http://en.wikipedia.org/wiki/Kick_(2014_film)";
        browser.open(url);
        System.out.println(browser.driver.getTitle());
        //TODO assert or filter page title for " " and proceed

    }

    public List<String> getMovieLinks(String url){
        browser.open(url);
        List<String> links = browser.getLinksByLocator(element.movieLinks);
        System.out.println((links));
        return links;
    }

    @Test
    public void fetchSongsInfo() throws ExcelException, TableModelException {
        String sheetName = "wiki_movie_links";
        List<String> movieLinks = new ArrayList<String>();
        Workbook wb = excel.getWorkbook("src/main/java/org/isdb/resources/isdb_movie_links.xls");
        List<String[]>  rows = excel.getRows(wb , sheetName);
        HashMap<String, Integer>  header = excel.getHeader(wb.getSheet(sheetName), 0);
        int cellPosition = header.get("links");
        rows.remove(0);

        for(String[] row : rows){
            movieLinks.addAll(getMovieLinks(row[cellPosition]));
        }

//        // Temp till getLinksByLocator in browser is fixed
//        List<String[]>  rowsMovie = excel.getRows(wb , "test_movie_links");
//        rowsMovie.remove(0);
//
//        for(String[] row : rowsMovie){
//            openPage(row[cellPosition]);
//            getSongtrackInfo();
//            getAudioInfo();
//            getMovieInfo();
//        }
//
    }
}
