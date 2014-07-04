package org.selenium.framework.utils;

import org.selenium.framework.baseModules.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sudheerl on 6/6/14.
 */
public class ExcelReaderTest extends BaseTest {
    private ExcelReader excel = new ExcelReader();

    //    @Test
    public void getSheetNamesTest(){
        ArrayList<String> sheetNames = new ArrayList<>();
        sheetNames = excel.getSheetNames(getConfig("basedir") + getConfig("excelFileToRead"));
        System.out.println("Sheet names are " + sheetNames );

    }

    //    @Test
    public void getRowsTest(){
        List<String[]> rows = new ArrayList<>();
        rows = excel.getRows(getConfig("basedir") + getConfig("excelFileToRead"), "defaults");
        System.out.println("rows details are " + rows );

    }

    @Test
    public void getPropsTest(){
        HashMap<String, String> props = new HashMap();
        props = excel.getProps(getConfig("basedir") + getConfig("excelFileToReadTest"), getConfig("excelSheetPropsTest"));
        Iterator it = props.keySet().iterator();
        while(it.hasNext()){
            String key = it.next().toString();
            String value = props.get(key);
            System.out.println("Key:  "+ key + "Value:" + value);
        }
    }
}
