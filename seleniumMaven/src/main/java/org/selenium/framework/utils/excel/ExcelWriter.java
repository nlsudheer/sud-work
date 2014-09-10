package org.selenium.framework.utils.excel;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sudheerl on 6/18/14.
 */
public class ExcelWriter extends ExcelProcessor{

    public void addSheet(String fileName, String sheetName){
        Workbook wb = getExcelObject(fileName);
        wb.createSheet(sheetName);
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
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(fileName));
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
