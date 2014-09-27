package org.castlight.tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.selenium.framework.frameworkException.ExcelException;
import org.selenium.framework.frameworkException.FrameworkException;
import org.selenium.framework.utils.Logger;
import org.selenium.framework.utils.excel.ExcelReader;
import org.selenium.framework.utils.excel.ExcelWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sudheerl on 6/16/14.
 */
public class GenerateCastLightTestsRun {
    private static final Logger logger = Logger.getLogger(GenerateCastLightTestsRun.class);
    private ExcelWriter excel = new ExcelWriter();
    private ExcelReader excelRead = new ExcelReader();

    public void updateExcelColoumns(String filename, String sheetName, String coloumnHeader) throws ExcelException {
        Cell cell = null;
        Workbook wb = excelRead.getExcelObject(filename);
        Sheet sheet  = wb.getSheet(sheetName);
        int rowNum = sheet.getLastRowNum();

        HashMap<String, Integer> header = excelRead.getHeader(sheet, 0);
//         excelRead.getRow(sheet, 0);



    }

    public static void main(String[] args) throws FrameworkException, ExcelException {
        GenerateCastLightTestsRun test = new GenerateCastLightTestsRun();
//        ExcelReader excelReader = new ExcelReader();
        String fileName = "/Users/sudheerl/GoogleDrive/workspace/sud-work/seleniumMaven/src/main/java/org/castlight/testData/cast_light.xls";


        String basePath, spreadSheet = null;
        String	sheet = null;
        String employer = null;
        String	plan = null;
        String	type = null;
        String	outputDir = null;
        String	templatePath = null;
        String	testsDir = null;
        String	host = null;
        String jenkinsRun = null;
        String genTest = null;
        String run;
        String sheetName = "dental_pricing"; //pricing preprod dental_pricing drugs

        Workbook workbook = test.excelRead.getExcelObject(fileName);
        Sheet excelSheet = workbook.getSheet(sheetName);
        HashMap<String, Integer> header = test.excelRead.getHeader(excelSheet, 0);
        int runPosition = header.get("command");
        int genPosition = header.get("generate");

        try {

            List<String[]> excelData = test.excelRead.getRows(workbook, sheetName);

            String runTarget = " onlyrun";
            String genTarget = " gen";

            for (int ctr = 1; ctr < excelData.size(); ctr++) {
                run = "ant -f libraries/testing/build.xml -Dexcel.filename=$spread_sheet -Dsheet.names=$sheet" +
                        " -Doutput.dir=$output -Dtemplate.filenames=$template_path" +
                        " -Dtests.dir=$tests_dir -Dservice.host=$host -Dtests.data.mode=live";
                String[] row = excelData.get(ctr);
                sheet = "tests";
                basePath = row[1];
                spreadSheet = basePath + "/" + row[3];
                outputDir = basePath + "/" + row[2];
                templatePath = row[0];
                testsDir = outputDir;
                host = "den-qa01-soa01";

                if("YES".equalsIgnoreCase(row[4]) || "YES".equalsIgnoreCase(row[5])) {
                    run =  run.replace("$spread_sheet",spreadSheet).replace("$sheet", sheet);
                    run = run.replace("$output", outputDir);
                    run = run.replace("$template_path", templatePath);
                    run = run.replace("$tests_dir", testsDir);
                    run = run.replace("$host", host);
                    logger.debug(Arrays.toString(row));
                    runTarget = run + runTarget;
                    System.out.println("\n" + runTarget  + "\n");
                    genTest = run.replace("build.xml", "test.xml").replace(runTarget, genTarget ).replace("NA", "");
                    genTarget = genTest + genTarget;
                    System.out.println("\n" + genTarget +"\n");
                }
//                workbook = test.excel.updateExcelColumns(workbook, sheetName, ctr, runPosition, runTarget);
//                workbook = test.excel.updateExcelColumns(workbook, sheetName, ctr, genPosition, genTarget);
            }
//            test.excel.writeAndCloseExcelFile(fileName, workbook);
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error(exception);
        }


    }
}
