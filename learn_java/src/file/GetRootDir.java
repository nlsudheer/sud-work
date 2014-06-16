package file;

/**
 * Created by sudheerl on 5/27/14.
 */
public class GetRootDir {

    public static void main (String args[]) {

        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);



    }
}
