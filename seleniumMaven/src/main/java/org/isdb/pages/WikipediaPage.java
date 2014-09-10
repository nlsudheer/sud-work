package org.isdb.pages;

import org.openqa.selenium.By;

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
    //


// $('table.infobox.vevent.haudio')
// $('table.infobox.vevent')

}
