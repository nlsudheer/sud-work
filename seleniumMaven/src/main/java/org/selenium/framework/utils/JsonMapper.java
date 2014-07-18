package org.selenium.framework.utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Created by sudheerl on 7/15/14.
 */
public class JsonMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Object readjsonFile(String file, Class clazz) throws IOException {
        byte[] jsonData = new byte[0];
        jsonData = Files.readAllBytes(Paths.get(file));
        return objectMapper.readValue(jsonData, clazz);
    }

    public String jsonPrettyPrint(String file, String jsonData) throws IOException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
    }



    public static void main(String[] args) throws IOException {
//        String file = "/Users/sudheerl/Desktop/sample_json.json";
//        String file = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/dev/accountService/account_test_for_dental_and_medical_plan_with_out_policy_data.json";
        String file = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/dev/accountService/temp.json";
        //converting json to Map
        byte[] mapData = Files.readAllBytes(Paths.get(file));
        Map<String,String> myMap = new HashMap<String, String>();

        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(mapData, HashMap.class);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(myMap));
        System.out.println("Map is: "+myMap);

//        System.out.println("Map using TypeReference: "+myMap);

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get(file));

        //read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode accountNode = rootNode.path("account");

////        rootNode.path("account").path("allRelatedPatients").get(0).path("email");
//        objectMapper.readTree(jsonData).path("tests").get(0).path("expectedAccountDetails").path("dentalPolicy");
//        JsonNode idNode = rootNode.path("tests").path("expectedAccountDetails");
//        System.out.println("id = "+idNode.asInt());
//
//        JsonNode phoneNosNode = rootNode.path("dentalPolicy");
        Iterator<JsonNode> elements = accountNode.getElements();
        while(elements.hasNext()){
            JsonNode phone = elements.next();
//            System.out.println("Phone No = "+phone);
        }
    }
}