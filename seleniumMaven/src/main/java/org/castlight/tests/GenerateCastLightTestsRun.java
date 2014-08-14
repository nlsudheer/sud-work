package org.castlight.tests;

import org.selenium.framework.frameworkException.FrameworkException;
import org.selenium.framework.utils.ExcelReader;

import java.util.List;

/**
 * Created by sudheerl on 6/16/14.
 */
public class GenerateCastLightTestsRun {
//        private static final CastlightLogger logger = CastlightLogger.getLogger(TemplateEngine.class);

    public static void main(String[] args) throws FrameworkException {
        ExcelReader excel = new ExcelReader();
        String file = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/cast_light.xls";


        String basePath = null;
        String	spreadSheet = null;
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
        String run = null;

        try {
            String sheetName = "drug"; //pricing preprod dental drug
            List<String[]> excelData = excel.getRows(file, sheetName);

            String[] header = excelData.get(0);

            for (int ctr = 1; ctr < excelData.size(); ctr++) {
                run = "ant -f libraries/testing/build.xml -Dexcel.filename=$spread_sheet -Dsheet.names=$sheet" +
                        " -Doutput.dir=$output -Dtemplate.filenames=$template_path" +
                        " -Dtests.dir=$tests_dir -Dservice.host=$host -Dtests.data.mode=live run";
                String[] row = excelData.get(ctr);
                sheet = "tests";
                basePath = row[1];
                spreadSheet = basePath + "/" + row[2] + "/testcases/" + row[5];
                outputDir = basePath + "/" + row[2] + "/" + row[4] + "/" + row[3];
                templatePath = header[0];
                testsDir = outputDir;
                host = "den-qa01-soa01";

                if("YES".equalsIgnoreCase(row[6]) || "YES".equalsIgnoreCase(row[7])) {
                    run =  run.replace("$spread_sheet",spreadSheet).replace("$sheet", sheet);
                    run = run.replace("$output", outputDir);
                    run = run.replace("$template_path", templatePath);
                    run = run.replace("$tests_dir", testsDir);
                    run = run.replace("$host", host);
//                    logger.debug(Arrays.toString(row));
                    System.out.println(run);
                    genTest = run.replace("build.xml", "test.xml").replace("run", "gen").replace("NA", "");
                    System.out.println(genTest);
                }


            }
        } catch (Exception exception) {
            exception.printStackTrace();
//                logger.error(exception);
        }


    }
}
