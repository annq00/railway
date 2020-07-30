package Common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utilities {
    public static String generateRandomString(int length){

        SimpleDateFormat formatter = new SimpleDateFormat("EEddMMMMyyyyHHmmss");
        Date date = new Date();
        String dateTime = formatter.format(date);

        char[] keys = dateTime.toCharArray();

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for(int i = 0; i<length; i++){
            char temp = keys[random.nextInt(keys.length)];
            sb.append(temp);
        }
        String result = sb.toString();
        return result;
    }

    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    public static JSONObject readJsonFile(String jsonFile) {
        JSONObject testObject = null;

        try {
            FileReader reader = new FileReader(Utilities.getProjectPath()+"\\DataObjects\\"+jsonFile);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            testObject =  jsonObject;
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return testObject;
    }

    public static String getDataTest(String jsonFile, String type, String key){

        JSONObject object = readJsonFile(jsonFile);

        return ((JSONObject) object.get(type)).get(key).toString();

    }

}
