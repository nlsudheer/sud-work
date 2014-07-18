package org.selenium.framework.utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by sudheerl on 6/18/14.
 */
public class JxlExcelProcessor {


    public HashMap<String, String> getProps(String fileName, String sheetName) {
        HashMap<String, String> props = new HashMap();
        Workbook workBook = getJxlExcelObject(fileName);
        Sheet sheet = workBook.getSheet(sheetName);
        for (int row = 1; row < sheet.getRows(); row++) {
            sheet.getCell(0, row).getContents();
            props.put(sheet.getCell(0, row).getContents(), sheet.getCell(1, row).getContents());
        }
        return props;
    }

    public Workbook getJxlExcelObject(String fileName){
        Workbook workBook = null;

        try{
            FileInputStream fi = new FileInputStream(new File(fileName));
            workBook = Workbook.getWorkbook(fi);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return workBook;
    }
}
