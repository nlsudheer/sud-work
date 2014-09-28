package org.isdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by sudheerl on 9/7/14.
 */
public class WikipediaPage {

    public By soundTrackSectionText =  By.cssSelector("span#Soundtrack");
    public By soundTrackListTables = By.cssSelector("table.tracklist");
    public By soundTrackListTableHeader = By.cssSelector("table.tracklist>tbody>tr");
    public By soundTrackListTablebody = By.cssSelector("table.tracklist>tbody>tr");
    public By audioInfoBoxTable = By.cssSelector("table.infobox.vevent.haudio");
    public By infoBoxTableXpath =  By.xpath("//table[contains(@class,'infobox') and contains(@class,'vevent')]");
    public By infoBoxTable =  By.cssSelector("table.infobox.vevent");
    public By movieLinks = By.cssSelector("div#mw-pages a");

    @FindBy(how = How.ID, using = "mw-pages")
    public WebElement linksPage;


    public void getMovieLinks(){


    }
// $('table.infobox.vevent.haudio')
// $('table.infobox.vevent')

}
