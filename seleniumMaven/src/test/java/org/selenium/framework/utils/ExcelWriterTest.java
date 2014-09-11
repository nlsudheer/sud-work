package org.selenium.framework.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.selenium.framework.baseModules.BaseTest;
import org.selenium.framework.utils.excel.ExcelReader;
import org.selenium.framework.utils.excel.ExcelWriter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
    String defaultSheetName = "test";
    String defaultxlsFileName = getConfig("basedir") + getConfig("excelFilePathToCreateTest") + "defaultExcelFileTest.xls";


    public Map<String, Object[]> dataToWriteExcel(){
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "Credit"});
        data.put("2", new Object[] {1, "Sudheer", 100});
        data.put("3", new Object[] {2, "Srav", 200});
        data.put("4", new Object[] {3, "Sush", 300});
        return data;
    }

    @Test (enabled = true, dependsOnMethods = "verifyWritingAnExcelTest")
    public void updateExcelFileTest(){
        String fileName = defaultxlsFileName;
        Workbook wb = excelRead.getExcelObject(fileName);
        Sheet sheet  = wb.getSheet(defaultSheetName);
        Cell cell = null;

        cell = sheet.getRow(1).getCell(2);
        cell.setCellValue(cell.getNumericCellValue() * 2);
        cell = sheet.getRow(2).getCell(2);
        cell.setCellValue(cell.getNumericCellValue() * 3);
        excel.writeAndCloseExcelFile(fileName, wb);
        //TODO Assert data
    }

    @Test(enabled = true)
    public void verifyWritingAnExcelTest(){
        String fileName = defaultxlsFileName;
        String sheetName = defaultSheetName;

        verifyWritingAnExcel(fileName, sheetName);
        //TODO Assert data
    }

    public Workbook verifyWritingAnExcel(String fileName, String sheetName){
        Workbook wb;
        excel.createExcelFile(fileName);
        wb = excel.createSheet(fileName, sheetName);
        Sheet sheet = wb.getSheet(sheetName);
        System.out.println("Sheet names are " + sheetName );
        System.out.println("fileName names  " + fileName );

        Map<String, Object[]> data = dataToWriteExcel();

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                excel.setStringCellValue(cell, obj);
            }
        }
        excel.writeAndCloseExcelFile(fileName, wb);
        return wb;
    }

    @Test(enabled = false)
    public void addSheetTest(){
        String fileName = xlsFileName;
        String sheetName = generateSheetNames(0).get(0);
        excel.createExcelFile(fileName);
        excel.addSheet(fileName, sheetName);
        System.out.println("Sheet names are " + sheetName );
        System.out.println("fileName names  " + fileName );
    }

    @Test(enabled = false)
    public void addSheetToXlsxTest(){
        String fileName = xlsxFileName;
        String sheetName = generateSheetNames(0).get(0);
        excel.createExcelFile(fileName);
        excel.addSheet(fileName, sheetName);
        assertEquals(sheetName, excelRead.getSheetNames(fileName).get(0));
        System.out.println("Sheet names are " + sheetName);
        System.out.println("fileName names  " + fileName );
    }

    @Test(enabled = false)
    public void addSheetsTest(){
        String fileName = xlsFileName;
        ArrayList<String> sheetNames = generateSheetNames(4);
        excel.createExcelFile(fileName);
        excel.addSheets(fileName, sheetNames);
        System.out.println("Sheet names are " + sheetNames.toArray());
        System.out.println("fileName names  " + fileName );
    }

    @Test(enabled = false)
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
