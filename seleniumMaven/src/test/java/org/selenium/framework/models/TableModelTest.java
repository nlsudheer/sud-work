package org.selenium.framework.models;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import org.openqa.selenium.By;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.frameworkException.TableModelException;
import org.testng.annotations.Test;

/**
 * Created by sudheerl on 7/6/14.
 */
public class TableModelTest extends BaseTest {
    TableModel tableModel = new TableModel();
    String urlToLoad = getConfig("testTableModelURL");

//    @Test
    public void testGetTable() throws TableModelException {
        Table<String, String, String> tableData;
        browser.open(urlToLoad);
        tableData = tableModel.getTableData(By.cssSelector("table#table1>thead>tr"), By.cssSelector("table#table1>tbody>tr"));
//        System.out.println(tableData);
        System.out.println("testHashBasedTablem rowKeySet: " + tableData.rowKeySet());
        System.out.println("testHashBasedTable columnKeySet: "+ tableData.columnKeySet());

    }

    @Test(enabled = false)
    public void testTableModelImmutable() {
        ImmutableTable.Builder<Integer, Integer, String> tableData;
//        browser.open(getConfig("testTableModelURLLocal"));
        browser.open(urlToLoad);
        tableData = tableModel.getTableImmutableTable(By.cssSelector("table#table1>thead>tr"), By.cssSelector("table#table1>tbody>tr"));
//        System.out.println(tableData);
        System.out.println("testTableModelImmutable rowKeySet: " + tableData.build().columnKeySet());
        System.out.println("testTableModelImmutable columnKeySet: "+ tableData.build().rowKeySet());

    }

    @Test
    public void testHashBasedTable() throws TableModelException {
        Table<Integer, Integer, String> tableData;
        browser.open(urlToLoad);
        tableData = tableModel.getTableDataHashBasedTable(By.cssSelector("table#table1>thead>tr"), By.cssSelector("table#table1>tbody>tr"));
//        System.out.println(tableData);
        System.out.println("testHashBasedTablem rowKeySet: " + tableData.rowKeySet());
        System.out.println("testHashBasedTable columnKeySet: "+ tableData.columnKeySet());

    }

}