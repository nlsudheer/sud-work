package org.selenium.framework.utils;

import org.testng.annotations.Test;

/**
 * Created by sudheerl on 8/21/14.
 */
public class FolderProcessorTest {
    FolderProcessor fp = new FolderProcessor();
    String dir = System.getProperty("user.dir");

    @Test(enabled = false)
    public void displayDirectoryTest() {
        fp.displayDirectory(dir);

    }

    @Test(enabled = true)
    public void displayDirectoryRecursivelyTest(){
        dir = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/qa/drug/alternatives/";
        String fileType = ".xls";
        fp.displayDirectoryRecursively(dir, fileType);

    }

    @Test(enabled = false)
    public void getFileNamesTest(){
//        fp.getFileNames(null, dir);
    }
    @Test(enabled = false)
    public void displayDirectoryRecursivelywithFilterTest(){
        String[]  fileTypes = new String[]{ "xls", "xlsx"};
//        dir = "./";
//        dir = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/qa/drug/";
//        fp.displayDirectoryRecursivelywithFilter(dir, fileTypes);
    }
}
