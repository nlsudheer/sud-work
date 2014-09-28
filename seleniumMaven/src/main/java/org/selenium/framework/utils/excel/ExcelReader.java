package org.selenium.framework.utils.excel;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.selenium.framework.frameworkException.ExcelException;

import java.util.*;


/**
 * http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
 * HSSF for your .xls files, and also XSSF for .xslx files,
 * http://poi.apache.org/spreadsheet/converting.html
 * Created by sudheerl on 5/28/14.
 */
public class ExcelReader extends ExcelProcessor{
    public static Logger logger = Logger.getLogger(ExcelReader.class);

    public HashMap<String, String> getProps(String fileName, String sheetName) {
        ExcelProcessor jxlExcel = new ExcelProcessor();
        return jxlExcel.getProps(fileName, sheetName);
    }


    public List<String> getColumn(String fileName, String sheetName, int columnPosition ) {
        List<String> column = new ArrayList<String>();
        Workbook workBook = getExcelObject(fileName);
        Sheet sheet = workBook.getSheet(sheetName);
        FormulaEvaluator formulaEvaluator = workBook.getCreationHelper().createFormulaEvaluator();
        try {
            for(Row r: sheet){
                if (r != null) {
                    Cell cell =  r.getCell(columnPosition);
                    column.add(getStringCellValue(cell, formulaEvaluator));
                }
            }
        } catch (ExcelException e) {
            e.printStackTrace();
        }
        return column;
    }

    public HashMap<String, Integer> getHeader(Sheet sheet, int rowNum) throws ExcelException {
        HashMap<String, Integer> header = new HashMap<>();
        Row row  = sheet.getRow(rowNum);
        ArrayList exceptions = new ArrayList();

        int cellNum = row.getPhysicalNumberOfCells();
        Iterator cellIterator = row.cellIterator();
        int  cellPosition = 0;
        while(cellIterator.hasNext()){
            Cell cell = (Cell) cellIterator.next();

            try {
                String cellValue = row.getCell(cellPosition, Row.RETURN_BLANK_AS_NULL).toString();
                header.put(cellValue, cellPosition);
            } catch(Exception e){
                exceptions.add("Cell value at position\t" + cellPosition + "\t is null or blank ");
            }
            cellPosition++;
        }

        if(exceptions.size() != 0)
            throw new ExcelException(Arrays.deepToString(exceptions.toArray()));

        return header;
    }


    public Multimap<String, Integer> getRow(Sheet sheet, int rowNum) {
        Multimap<String, Integer> rowMap = ArrayListMultimap.create();
        Row row = sheet.getRow(rowNum);

        int cellNum = row.getPhysicalNumberOfCells();
        Iterator cellIterator = row.cellIterator();

        for (int cellPosition = 0; cellIterator.hasNext(); cellPosition++) {
            Cell cell = (Cell) cellIterator.next();
            String cellValue = null;
            try {
                cellValue = row.getCell(cellPosition, Row.RETURN_BLANK_AS_NULL).toString();
                rowMap.put(cellValue, cellPosition);
            } catch (Exception e) {
                rowMap.put(null, cellPosition);
            }
        }
        return rowMap;
    }


    public List<String[]> getRows(Workbook workBook, String sheetName) throws ExcelException {
        List<String[]> rows = new ArrayList<String[]>();
        List<String[]> column = new ArrayList<String[]>();

        Sheet sheet = workBook.getSheet(sheetName);

        FormulaEvaluator formulaEvaluator = workBook.getCreationHelper().createFormulaEvaluator();


        if (sheet == null) {
            logger.debug("sheetName: " + sheetName + " not found in the excel file ");
            throw new ExcelException("sheetName: " + sheetName + " not found in the excel file.");

        } else if (sheet != null) {
            logger.debug(workBook.getSheetIndex(sheet) + " is the index of sheet " + sheet);
            for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
                logger.debug("Sheet " + i + " is " + workBook.getSheetName(i));
            }
        }
        //Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row hssfRow = (Row) rowIterator.next();
            String[] row = new String[hssfRow.getLastCellNum()];
            //Get iterator to all cells of current row
            Iterator<Cell> cellIterator = hssfRow.cellIterator();
            int cellCtr = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                try {
                    row[cellCtr] = getStringCellValue(cell, formulaEvaluator);
                } catch (ExcelException e) {
                    e.printStackTrace();
                }
                cellCtr++;
            }
            rows.add(row);
        }
        return rows;

    }
    public List<String[]> getRows(String fileName, String sheetName) throws ExcelException {
        Workbook workBook = getExcelObject(fileName);
        return getRows(workBook, sheetName);
    }

    public Workbook  getWorkbook(String fileName){
        return getExcelObject(fileName);
    }

    public ArrayList getSheetNames(String fileName){
        ArrayList<String> sheetNames = new ArrayList<String>();

        Workbook workBook = getExcelObject(fileName);
        for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
            System.out.println("Sheet " + i + " is " + workBook.getSheetName(i));
            sheetNames.add(workBook.getSheetName(i));
        }
        return sheetNames;
    }

    private static String getStringCellValue(Cell cell, FormulaEvaluator formulaEvaluator)
            throws ExcelException {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_BOOLEAN:
                return "" + cell.getBooleanCellValue();
            case Cell.CELL_TYPE_ERROR:
                throw new ExcelException("An error occured while reading cell: " + cell.getErrorCellValue()
                        + " at row: " + cell.getRowIndex() + " and column: " + cell.getColumnIndex());
            case Cell.CELL_TYPE_FORMULA:
                return getCellValueAfterFormulaEvaluation(formulaEvaluator.evaluate(cell));
            case Cell.CELL_TYPE_NUMERIC:
                return getNumericStringFromDouble(cell.getNumericCellValue());
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                throw new ExcelException("Unable to read value of cell at row: " + cell.getRowIndex()
                        + " and column: " + cell.getColumnIndex());
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
