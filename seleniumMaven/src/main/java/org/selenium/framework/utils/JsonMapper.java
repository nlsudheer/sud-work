package org.selenium.framework.utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by sudheerl on 7/15/14.
 */
public class JsonMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String readJsonFile(String file, Class clazz) throws IOException {
        String jsonData = (String) objectMapper.readValue(new File(file), clazz);
        return jsonData;
    }

    public void writeJsonFile(String file, String json) throws IOException {
        objectMapper.writeValue(new File("file"), json);
    }

    public void editJsonFile(String file, String key, String value) throws IOException {
        byte[]  jsonData = Files.readAllBytes(Paths.get(file));
        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode expectedAccountDetails = rootNode.path("tests").path("expectedAccountDetails");
        ((ObjectNode) expectedAccountDetails).put(key, value);
        objectMapper.writeValue(new File("file"), rootNode);
    }

    public String jsonPrettyPrint(String file) throws IOException {
        Object jsonData = objectMapper.readValue(new File(file), Object.class);
        return jsonPrettyPrint(jsonData);
    }

    public String jsonPrettyPrint(String file, String jsonData) throws IOException {
        return jsonPrettyPrint(jsonData);
    }

//    public String jsonPrettyPrint(String jsonData) throws IOException {
////        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//        Object data = objectMapper.readValue(jsonData, Object.class);
//        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
//    }

    public String jsonPrettyPrint(Object jsonData) throws IOException {
        Object data = objectMapper.readValue((String) jsonData, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public void editJsonFileForCLHAccountService(String file, String key, String value) throws IOException {
        BufferedReader jsonData = new BufferedReader(new FileReader(file));
        objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode expectedAccountDetails = rootNode.path("tests").get(0); //.path("expectedAccountDetails");
        ((ObjectNode) expectedAccountDetails).put(key, value);

//        String data = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
//        objectMapper.writeValue(new File(file), data);

//        objectMapper.writeValue(new File(file), objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode));
        objectMapper.writeValue(new File(file), rootNode);
    }



    public static void main(String[] args) throws IOException {
//        String file = "/Users/sudheerl/Desktop/sample_json.json";
//        String file = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/dev/accountService/account_test_for_dental_and_medical_plan_with_out_policy_data.json";
        String file = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/dev/accountService/temp.json";
        String file1 = "/Users/sudheerl/Pramati/cast_light/Projects/Ventana/testing/dev/accountService/temp1.json";
        Map<String,String> myMap = new HashMap<String, String>();
        JsonMapper jm = new JsonMapper();
        String jsonData = jm.readJsonFile(file, Object.class);
        System.out.println("jsonData in Object "+jsonData);
        String jsonPrettyPrint = jm.jsonPrettyPrint( jsonData);
           System.out.println("jsonPrettyPrint = "+jsonPrettyPrint);
        jm.writeJsonFile(file1, jsonPrettyPrint);
//
//        //converting json to Map
//        byte[] mapData = Files.readAllBytes(Paths.get(file));
//        Map<String,String> myMap = new HashMap<String, String>();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        myMap = objectMapper.readValue(mapData, HashMap.class);
////        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(myMap));
////        System.out.println("Map is: "+myMap);
//
////        System.out.println("Map using TypeReference: "+myMap);
//
//        //read json file data to String
//        byte[] jsonData = Files.readAllBytes(Paths.get(file));
//
//        //read JSON like DOM Parser
//        JsonNode rootNode = objectMapper.readTree(jsonData);
//        JsonNode accountNode = rootNode.path("account");
//        JsonNode expectedAccountDetails = rootNode.path("tests").get(0).path("expectedAccountDetails");
//        String expectedAccountDetailsPretty = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedAccountDetails);
////                System.out.println("expectedAccountDetails = "+expectedAccountDetailsPretty);
//
//////        rootNode.path("account").path("allRelatedPatients").get(0).path("email");
////        objectMapper.readTree(jsonData).path("tests").get(0).path("expectedAccountDetails").path("dentalPolicy");
////        JsonNode idNode = rootNode.path("tests").path("expectedAccountDetails");
////        System.out.println("id = "+idNode.asInt());
////
////        JsonNode phoneNosNode = rootNode.path("dentalPolicy");
////        Iterator<JsonNode> elements = accountNode.getElements();
////        while(elements.hasNext()){
////            JsonNode phone = elements.next();
////           System.out.println("Phone No = "+phone);
////        }


//        jm.editJsonFileForCLHAccountService(file, "expectedAccountDetails", "EditAccountDetails"  );
    }
}