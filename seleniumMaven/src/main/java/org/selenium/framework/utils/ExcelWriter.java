package org.selenium.framework.utils;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by sudheerl on 6/18/14.
 */
public class ExcelWriter {

    public Workbook getExcelObject(String fileName){
        Workbook wb = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            wb = new WorkbookFactory().create(fsFileSystem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public void addSheet(String fileName, String sheetName){
        Workbook wb = getExcelObject(fileName);
        wb.createSheet(sheetName);

    }

}
