package org.selenium.framework.utils;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.selenium.framework.frameworkException.ExcelException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
 * Created by sudheerl on 5/28/14.
 */
public class ExcelProcessor {

    public HashMap<String, String> getProps(String fileName, String sheetName) {
        HashMap<String, String> props = new HashMap();
        Workbook workBook = getJxlExcelObject(fileName);
        Sheet sheet = workBook.getSheet(sheetName);
        for (int row = 0; row < sheet.getRows(); row++) {
            sheet.getCell(0, row).getContents();
            props.put(sheet.getCell(0, row).getContents(), sheet.getCell(1, row).getContents());
        }
        return props;
    }

    public List<String[]> getRows(String fileName, String sheetName) {
        List<String[]> rows = new ArrayList<String[]>();
        List<String[]> column = new ArrayList<String[]>();
        HSSFWorkbook workBook = getExcelObject(fileName);
        HSSFSheet sheet = workBook.getSheet(sheetName);
        //Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            HSSFRow hssfRow = (HSSFRow) rowIterator.next();
            String[] row = new String[hssfRow.getLastCellNum()];
            //Get iterator to all cells of current row
            Iterator<Cell> cellIterator = hssfRow.cellIterator();
            int cellCtr = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "t");
                        row[cellCtr] = String.valueOf(cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "t");
                        row[cellCtr] = cell.getStringCellValue();
                        break;
                }
                cellCtr++;
            }
            rows.add(row);
        }
        return rows;
    }

    public ArrayList getSheetNames(String fileName){
        ArrayList<String> sheetNames = new ArrayList<String>();

        HSSFWorkbook workBook = getExcelObject(fileName);
        for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
            System.out.println("Sheet " + i + " is " + workBook.getSheetName(i));
            sheetNames.add(workBook.getSheetName(i));
        }
        return sheetNames;
    }

    public HSSFWorkbook getExcelObject(String fileName){
        HSSFWorkbook workBook = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            workBook = new HSSFWorkbook(fsFileSystem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workBook;
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

    private static String getStringCellValue(HSSFCell hssfCell, FormulaEvaluator formulaEvaluator)
            throws ExcelException {
        switch (hssfCell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_BOOLEAN:
                return "" + hssfCell.getBooleanCellValue();
            case Cell.CELL_TYPE_ERROR:
                throw new ExcelException("An error occured while reading cell: " + hssfCell.getErrorCellValue()
                        + " at row: " + hssfCell.getRowIndex() + " and column: " + hssfCell.getColumnIndex());
            case Cell.CELL_TYPE_FORMULA:
                return getCellValueAfterFormulaEvaluation(formulaEvaluator.evaluate(hssfCell));
            case Cell.CELL_TYPE_NUMERIC:
                return getNumericStringFromDouble(hssfCell.getNumericCellValue());
            case Cell.CELL_TYPE_STRING:
                return hssfCell.getStringCellValue();
            default:
                throw new ExcelException("Unable to read value of cell at row: " + hssfCell.getRowIndex()
                        + " and column: " + hssfCell.getColumnIndex());
        }
    }

    private static String getCellValueAfterFormulaEvaluation(CellValue cellValue) throws ExcelException {
        switch (cellValue.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_BOOLEAN:
                return "" + cellValue.getBooleanValue();
            case Cell.CELL_TYPE_NUMERIC:
                return getNumericStringFromDouble(cellValue.getNumberValue());
            case Cell.CELL_TYPE_STRING:
                return cellValue.getStringValue();
            default:
                throw new ExcelException("Unable to read cell value for: " + cellValue.toString());
        }
    }

    private static String getNumericStringFromDouble(double value) {
        if (value % 1.0 > 0 || value % 1.0 < 0) {
            // We have decimal part.
            return "" + value;
        }
        return "" + (int) value;
    }
}
