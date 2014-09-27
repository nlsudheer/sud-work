package org.selenium.framework.utils.excel;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sudheerl on 6/18/14.
 */
public class ExcelWriter extends ExcelProcessor{
    public static Logger logger = Logger.getLogger(ExcelWriter.class);

    public Workbook createSheet(String fileName, String sheetName){
        Workbook wb = getExcelObject(fileName);
        wb.createSheet(sheetName);
        logger.info("Created the sheet in file " + fileName);
        return wb;
    }
    public void addSheet(String fileName, String sheetName){
        Workbook wb = createSheet(fileName, sheetName);
        writeAndCloseExcelFile(fileName, wb);
    }

    public void addSheets(String fileName, ArrayList<String> sheetNames){
        Workbook wb = getExcelObject(fileName);
        for(String sheetName: sheetNames) {
            wb.createSheet(sheetName);
        }
        writeAndCloseExcelFile(fileName, wb);
    }


    public Workbook createExcelFile(String fileName){
        Workbook wb = null;
        wb = setExcelObject(fileName);
        writeAndCloseExcelFile(fileName, wb);
        return wb;
    }

    public void writeAndCloseExcelFile(String fileName, Workbook wb){
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(new File(fileName));
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Example method
    public Workbook updateExcelFile(String fileName, String sheetName){
        Workbook wb = getExcelObject(fileName);
        Sheet sheet  = wb.getSheet(sheetName);
        Cell cell = null;

        cell = sheet.getRow(0).getCell(2);
        cell.setCellValue(cell.getNumericCellValue() * 2);
        cell = sheet.getRow(1).getCell(2);
        cell.setCellValue(cell.getNumericCellValue() * 3);
        writeAndCloseExcelFile(fileName, wb);
        return wb;
    }


    public Workbook updateExcelColumns(Workbook wb, String sheetName, int rowNum, int columnPosition, String cellValue){
        Sheet sheet  = wb.getSheet(sheetName);
        Cell cell = null;

        cell = sheet.getRow(rowNum).getCell(columnPosition);
        cell.setCellValue(cellValue);
        return wb;
    }


    public Workbook updateExcelColumns(Workbook wb, String sheetName, int columnPosition, String cellValue){
        Sheet sheet  = wb.getSheet(sheetName);
        int rowNum = sheet.getPhysicalNumberOfRows();
        Cell cell = null;

        for(int i = 0; i <= rowNum; i++ ){
            cell = sheet.getRow(i).getCell(columnPosition);
            cell.setCellValue(cellValue);
        }
        return wb;
    }

    public void setStringCellValue(Cell cell, Object obj) {
        try {
            if(obj instanceof String)
                cell.setCellValue((String)obj);
            else if(obj instanceof Integer)
                cell.setCellValue((Integer)obj);
            else if (obj instanceof Boolean)
                cell.setCellValue((Boolean)obj);
            else if (obj instanceof Date)
                cell.setCellValue((Date) obj);
            else if (obj instanceof Calendar)
                cell.setCellValue((Calendar) obj);
            else
                cell.setCellValue((String)obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
