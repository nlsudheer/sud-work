package file;


import java.io.File;
import java.io.IOException;

/**
 * Created by sudheerl on 5/14/14.
 * http://www.avajava.com/tutorials/lessons/whats-the-difference-between-a-files-path-absolute-path-and-canonical-path.html
 */



public class FilePaths {

    public static void main(String[] args) throws IOException {

        String[] fileArray = {
                "C:\\projects\\workspace\\testing\\f1\\f2\\f3\\file5.txt",
                "folder/file3.txt",
                "../testing/file1.txt",
                "../testing",
                "f1/f2"
        };

        for (String f : fileArray) {
            displayInfo(f);
        }

    }

    public static void displayInfo(String f) throws IOException {
        File file = new File(f);
        System.out.println("========================================");
        System.out.println("          name:" + file.getName());
        System.out.println("  is directory:" + file.isDirectory());
        System.out.println("        exists:" + file.exists());
        System.out.println("          path:" + file.getPath());
        System.out.println(" absolute file:" + file.getAbsoluteFile());
        System.out.println(" absolute path:" + file.getAbsolutePath());
        System.out.println("canonical file:" + file.getCanonicalFile());
        System.out.println("canonical path:" + file.getCanonicalPath());
    }

}
