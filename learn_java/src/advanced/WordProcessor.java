package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sudheern
 *
 */
public class WordProcessor {


    public String readFile(String location) {
        File file = new File(location);
        String fileData = "";
        String str = "";
//		List<String> fileContent = {};

        boolean flag = false;

        if(!file.exists()){
            System.out.println("Mentioned source file doesn't exists" );
        }

        try{
            BufferedReader input =  new BufferedReader(new FileReader(location));

            while((str =input.readLine())!=null)
            {
                if(str.contains("<body>")){
                    flag = true;
                    continue;
                }else if(str.contains("</body>")){
                    flag = false;
                }

                if(flag){
                    System.out.println("Str: "+ str );

                    fileData += (str);
                    fileData += " ";
                }

            }


        } catch(IOException e){
            e.printStackTrace();
        }
        return fileData;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String htmlStr=new String();

        WordProcessor wordPro = new WordProcessor();
        htmlStr = wordPro.readFile("D:\\demo\\file.xhtml");

        System.out.println("htmlStr:"+ htmlStr );

        htmlStr = htmlStr.replaceAll("\\<.*?\\>", "");
        htmlStr.trim();
        String[] words = {};
        //htmlStr.replaceAll(" ","");
        words = htmlStr.split(" ");

        System.out.println("htmlStr: "+ Arrays.deepToString(words ));
        System.out.println("words length: "+  words.length);

    }
}