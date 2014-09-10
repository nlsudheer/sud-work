package org.selenium.framework.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sudheerl on 8/21/14.
 */
public class FolderProcessor {
    StringBuilder dirPrint = new StringBuilder();

    public void displayDirectoryRecursivelyWithFilter(String path, String[] fileTypes) { //List<String> fileTypes
//        fileTypes = new String[]{"json", "xls", "xlsx"};

        Collection files = FileUtils.listFiles(new File(path), fileTypes , true);
        Iterator it = files.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void displayDirectoryTreeRecursivelyApache(String path, String[] fileTypes) { //List<String> fileTypes
//        fileTypes = new String[]{"json", "xls", "xlsx"};

        Collection files = FileUtils.listFiles(new File(path), fileTypes , true);
        Iterator it = files.iterator();
        while (it.hasNext()) {

            System.out.println(it.next().toString());
        }
    }

    private List<String> getFileNames(List<String> fileNames, Path dir){
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
            for (Path path : stream) {
                if(path.toFile().isDirectory())
                    getFileNames(fileNames, path);
                else {
                    fileNames.add(path.toAbsolutePath().toString());
                    System.out.println(path.getFileName());
                }
            }
            stream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return fileNames;
    }

    public void displayDirectoryRecursively(String path){ //List<String> fileTypes
        displayDirectoryRecursively(path, null);
    }

    public void displayDirectoryRecursively(String path, String fileTypes){
        displayDirectoryRecursively(path, fileTypes, false);
    }

    public void displayDirectoryRecursively(String path, String fileTypes,boolean format){ //List<String> fileTypes
        File file = new File(path);
        if(format)
            dirPrint.append("-");

//        FileFilter fileFilter = new RegexFileFilter("^.*[tT]est(-\\d+)?\\.java$");
//        File[] files = file.listFiles(fileFilter);

        File [] files = file.listFiles();
        if ( files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (File aFile : files) {
                if(aFile.isDirectory()) {
                    System.out.println( "Dir: " + dirPrint.toString() + aFile);
                    displayDirectoryRecursively(aFile.getAbsolutePath(), fileTypes);
                } else {

                    if(aFile.isFile() && aFile.toString().endsWith(fileTypes))
                        System.out.println("File: " +  aFile.toString());
                }
            }
        }

    }

    public void displayDirectory(String path){
        File file = new File(path);
        if(!file.isDirectory())
            return;
        String [] files = file.list();
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (String aFile : files) {
                System.out.println(aFile);
            }
        }

    }

}
