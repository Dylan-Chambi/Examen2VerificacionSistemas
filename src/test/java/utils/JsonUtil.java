package utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class JsonUtil {
    public static JSONObject getJSONFromFile(String filePath) throws FileNotFoundException {
        String filePathAbs = new File(filePath).getAbsolutePath();
        return new JSONObject(new JSONTokener(new FileReader(filePathAbs)));
    }

    public static boolean areEqualJson(String expected, String actual) {
        boolean areEqual = true;
        JSONObject actualJson = new JSONObject(actual);
        JSONObject expectJson = new JSONObject(expected);

        Iterator<?> keys = expectJson.keys();

        while (keys.hasNext()) {
            String key = (String) keys.next();
            if (actualJson.has(key)) {
                String expectedValue = String.valueOf(expectJson.get(key));
                String actualValue = String.valueOf(actualJson.get(key));
                if (expectedValue.contains("IGNORE") || actualValue.contains("IGNORE")) {
                    System.out.println("INFO > ignorando la comparacion del key [" + key + "]");
                } else if (!expectedValue.equals(actualValue)) {
                    areEqual = false;
                    System.out.println("ERROR> el key [" + key + "] tiene como expected: [" + expectedValue
                            + " vs actual [" + actualValue + "]");
                }
            } else {
                areEqual = false;
                System.out.println("ERROR> El actual result no tiene el key: [" + key + "]");

            }
        }
        return areEqual;
    }
}
