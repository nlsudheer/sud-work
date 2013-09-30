package learnjava;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * http://www.programmingsimplified.com/java/source-code/java-program-open-notepad
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 30/9/13
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenNotepad {
    // throws IOException

//    @Test
    public void openNotepad() {
        Runtime run = Runtime.getRuntime();

        try {
            run.exec("notepad");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void openNotepadNoCatche() throws IOException{
        Runtime run = Runtime.getRuntime();

            run.exec("notepada");
    }
}
