package org.selenium.framework.models;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.framework.baseModules.BaseLib;
import org.selenium.framework.frameworkException.TableModelException;
import org.selenium.framework.utils.Logger;

import java.util.List;


/**
 * Created by sudheerl on 7/5/14.
 * http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/collect/Table.html
 * https://code.google.com/p/guava-libraries/wiki/NewCollectionTypesExplained#Table
 * get(Object rowKey, Object columnKey)
 * containsValue(Object value)
 */
public class TableModel extends BaseLib {
    private static  Logger logger = Logger.getLogger(TableModel.class);
    int headerSize;

    public Table<Integer, Integer, String> getTableDataHashBasedTable(By tableHeaderLocator, By tableBodyLocator) {
        Table<Integer, Integer, String> tableData = HashBasedTable.create();
        Table<Integer, Integer, String> tableBodyData = HashBasedTable.create();
        tableData = getTableHeaderData(tableHeaderLocator);

        tableBodyData= getTableBodyData(tableBodyLocator);
        tableData.putAll(tableBodyData);
        logger.debug("DrugAlternativesRequest: "+tableData);
        return tableData;
    }

    public Table<Integer, Integer, String> getTableBodyData(By tableBodyLocator) {
        Table<Integer, Integer, String> tableBodyData = HashBasedTable.create();
        browser.waitForElement(tableBodyLocator);
        List<WebElement> allRows = browser.driver.findElements(tableBodyLocator);
        for (int i = 0; i < allRows.size(); i++) {
            List<WebElement> cells = allRows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cells.size(); j++) {
                tableBodyData.put(headerSize + i, j, cells.get(j).getText());
            }
        }
        return tableBodyData;
    }

    public Table<Integer, Integer, String> getTableHeaderData(By tableHeaderLocator) {
        Table<Integer, Integer, String> tableHeaderData = HashBasedTable.create();
        browser.waitForElement(tableHeaderLocator);
        List<WebElement> allRows = browser.driver.findElements(tableHeaderLocator);
        headerSize = allRows.size();
        for (int i = 0; i < headerSize; i++) {
            List<WebElement> cells = allRows.get(i).findElements(By.tagName("th"));
            for (int j = 0; j < cells.size(); j++) {
                tableHeaderData.put(i, j, cells.get(j).getText());
            }
        }
        return tableHeaderData;
    }


    public Table<String, String, String> getTableData(By tableHeaderLocator, By tableBodyLocator) throws TableModelException {
        Table<String, String, String> tableHeader = HashBasedTable.create();
        Table<String, String, String> tableData = HashBasedTable.create();

        browser.waitForElement(tableHeaderLocator);
        browser.waitForElement(tableBodyLocator);

        List<WebElement> header = browser.driver.findElements(tableHeaderLocator);
        List<WebElement> dataRows = browser.driver.findElements(tableBodyLocator);

        int headerSize = header.size();
        int dataSize = dataRows.size();
        String valueHeader;

        if (headerSize > 1) {
            throw new TableModelException("Header size is greater than 1, check table Header element locator.");
        } else if (dataSize == 0) {
            throw new TableModelException("Data size is 0, check table body element locator.");
//        } else if(headerSize != dataSize){
//            throw new TableModelException("Header size: " +  headerSize + "and data size: " + dataSize + " is not matching check table element locators");
//        }
        } else {
            for (int i = 0; i < headerSize; i++) {
                List<WebElement> headerCells = header.get(i).findElements(By.tagName("th"));
                for (int j = 0; j < headerCells.size(); j++) {
                    String cell = headerCells.get(j).getText();
                    tableData.put("header", String.valueOf(j), cell);
                }
            }

            tableHeader.putAll(tableData);
            for (int i = 0; i < dataSize; i++) {
                List<WebElement> dataCells = dataRows.get(i).findElements(By.tagName("td"));
                for (int j = 0; j < dataCells.size(); j++) {
                    valueHeader = tableHeader.get("header", String.valueOf(j));
                    tableData.put(String.valueOf(i + 1), valueHeader, dataCells.get(j).getText());
                }
            }
        }
        return tableData;
    }

    // use it for Other table types
    // for optimized implementations for sparser and denser data sets
    public ImmutableTable.Builder<Integer, Integer, String> getTableImmutableTable (By tableHeaderLocator, By
            tableBodyLocator){
        ImmutableTable.Builder<Integer, Integer, String> tableData = ImmutableTable.builder();

        browser.waitForElement(tableHeaderLocator);
        browser.waitForElement(tableBodyLocator);

        List<WebElement> data = browser.driver.findElements(tableBodyLocator);
        List<WebElement> header = browser.driver.findElements(tableHeaderLocator);

        for (int i = 0; i < header.size(); i++) {
            List<WebElement> cells = header.get(i).findElements(By.tagName("th"));
            for (int j = 0; j < cells.size(); j++) {
                tableData.put(i, j, cells.get(j).getText());
            }
        }

        for (int i = 0; i < data.size(); i++) {
            List<WebElement> dataCells = data.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < dataCells.size(); j++) {
                tableData.put(i, j, dataCells.get(j).getText());
            }
        }
        return tableData;
    }
}

