package org.selenium.framework.utils;

import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.utils.excel.ExcelReader;
import org.selenium.framework.utils.excel.ExcelWriter;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

/**
 * Created by sudheerl on 6/18/14.
 * http://howtodoinjava.com/2013/06/19/readingwriting-excel-files-in-java-poi-tutorial/
 * http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
 */
public class ExcelWriterTest extends BaseTest {
    private ExcelWriter excel = new ExcelWriter();
    private ExcelReader excelRead = new ExcelReader();

    TestUtils util = new  TestUtils();
    String xlsFileName = getConfig("basedir") + getConfig("excelFilePathToCreateTest") +"excelFileCreated_" + util.randomStringGenerator(0) + ".xls";
    String xlsxFileName = getConfig("basedir") + getConfig("excelFilePathToCreateTest") +"excelFileCreated_" + util.randomStringGenerator(0) + ".xlsx";

    @Test
    public void addSheetTest(){
        String fileName = xlsFileName;
        String sheetName = generateSheetNames(0).get(0);
        excel.createExcelFile(fileName);
        excel.addSheet(fileName, sheetName);
        System.out.println("Sheet names are " + sheetName );
        System.out.println("fileName names  " + fileName );
    }

    @Test
    public void addSheetToXlsxTest(){
        String fileName = xlsxFileName;
        String sheetName = generateSheetNames(0).get(0);
        excel.createExcelFile(fileName);
        excel.addSheet(fileName, sheetName);
        assertEquals(sheetName, excelRead.getSheetNames(fileName).get(0));
        System.out.println("Sheet names are " + sheetName);
        System.out.println("fileName names  " + fileName );
    }

    @Test
    public void addSheetsTest(){
        String fileName = xlsFileName;
        ArrayList<String> sheetNames = generateSheetNames(4);
        excel.createExcelFile(fileName);
        excel.addSheets(fileName, sheetNames);
        System.out.println("Sheet names are " + sheetNames.toArray());
        System.out.println("fileName names  " + fileName );
    }

    @Test
    public void addSheetsToXlsxTest() {
        String fileName = xlsxFileName;
        ArrayList<String> sheetNames = generateSheetNames(4);
        excel.createExcelFile(fileName);
        excel.addSheets(fileName, sheetNames);
        assertEquals(sheetNames, excelRead.getSheetNames(fileName));
        System.out.println("Sheet names are " + sheetNames.toArray());
        System.out.println("fileName names  " + fileName );

    }

    public ArrayList<String> generateSheetNames(int count) {
        ArrayList<String> sheetNames = new ArrayList<>();
        int i = 0;
        while(i <= count) {
            sheetNames.add(util.randomStringGenerator(4));
            i++;
        }
        return sheetNames;
    }
}
