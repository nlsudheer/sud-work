package org.selenium.framework;

import java.util.HashMap;

/**
 * Created by sudheerl on 6/11/14.
 */
public class CodeTest {

    public static void main(String args[]){

        HashMap<String, String> links = new HashMap<>();
        links.put("1", "dup");
        links.put("1", "dup"); // duplicate with unique values

        links.put("2", "dup"); // duplicate values
        links.put("3", "dup3");
        links.put("3", "dup31"); // duplicate keys
        links.put("4", "dup31");
        links.put("5NULL", null);
        links.put("5NULL", "");  // duplicate with diff values
        links.put(null, null);


        for(String link: links.keySet() ) {

            System.out.println("Opened the link with Text "+ links.get(link) + link);
        }

        System.out.println(links);
    }

}
