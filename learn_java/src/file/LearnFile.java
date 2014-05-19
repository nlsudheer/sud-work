package file;

import java.io.*;

/**
 * Created by sudheerl on 5/14/14.
 * http://www.xyzws.com/Javafaq/what-is-the-difference-between-absolute-relative-and-canonical-path-of-file-or-directory/60
 *
 * Absolute path is the full directory such as C:\XyzWs\test.txt. The definition of absolute pathname is system dependent. On UNIX systems, a pathname is absolute if its prefix is "/". On Win32 systems, a pathname is absolute if its prefix is a drive specifier followed by "\\", or if its prefix is "\\".
 For example, We have two directories: XyzWs and XyzWs1 and test.txt file is in XyzWs directory.
 C:\XyzWs
 C:\XyzWs1
 In Java under Windows, you may have the following possible absolute paths that refer to the same file test.txt.
 c:\XyzWs\test.txt
 C:\XYZWS\test.txt
 c:\XyzWs\TEST.TXT
 c:\XyzWs\.\test.txt
 c:\XyzWs1\..\XyzWs\test.txt
 Relative path is relative to the directory you are in, so if you are in the above directory, then if you reference file test.txt as relative, it assumes the same directory you are in. When you do ../ then it goes back one directory.
 Canonical paths are a bit harder. For starters, all canonical paths are absolute (but not all absolute paths are canonical). A single file existing on a system can have many different paths that refer to it, but only one canonical path. Canonical gives a unique absolute path for a given file. The details of how this is achieved are probably system-dependent.
 For the above example, we have one and only one canonical path:
 c:\XyzWs\test.txt
 */
public class LearnFile {

    public static void showPaths(String pathName) throws IOException {
        File file = new File(pathName);
        System.out.println("path: " + file.getPath());
        System.out.println("absolute path: " + file.getAbsolutePath());
        System.out.println("canonical path: " + file.getCanonicalPath());
        System.out.println();
    }

    public static void main(String[] s) throws IOException {
        File file = new File(new File("test.txt").getAbsolutePath());
        String parent = file.getParent();
        File parentFile = new File(parent);
        String parentName = parentFile.getName();
        String grandparent = parentFile.getParent();
        file.createNewFile();

        showPaths("test.txt");
        showPaths("TEST.TXT");
        showPaths("." + File.separator + "TEST.TXT");

        showPaths(parent
                + File.separator + "."
                + File.separator + "test.txt");

        showPaths(grandparent
                + File.separator + parentName
                + File.separator + ".."
                + File.separator + parentName
                + File.separator + "test.txt");
    }
}
