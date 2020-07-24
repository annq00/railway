package Common;

import java.util.Random;

public class Utilities {
    public static String generateRandomString(int length){
        char[] keys = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789qwertyuiopasdfghjklzxcvbnm".toCharArray();

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for(int i = 0; i<length; i++){
            char temp = keys[random.nextInt(keys.length)];
            sb.append(temp);
        }
        String result = sb.toString();
        return result;
    }

}
