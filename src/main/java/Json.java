import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class Json {

    public static void main(String[] args) throws JSONException {
        String jsonStr = "{\n" +
                "  \"name\": \"Json\",\n" +
                "  \"detail\": {\n" +
                "    \"first_name\": \"Json\",\n" +
                "    \"last_name\": \"Scott\",\n" +
                "    \"age\": \"23\"\n" +
                "  },\n" +
                "  \"status\": \"success\"\n" +
                "}";
        JSONObject jsonMainObj = new JSONObject(jsonStr);
        JSONObject detail = jsonMainObj.getJSONObject("detail");
        String firstName = detail.getString("first_name");
        String lastName = detail.getString("last_name");
        System.out.println(detail);
        System.out.println("firstName:" + firstName);
        System.out.println(lastName);

        Set<String> set = getKeySet(jsonMainObj);
        for (String s : set) {
            System.out.println("Keys:" + s);
        }

        Iterator<String> keys = getKeys(jsonMainObj);
        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonMainObj.get(key) instanceof JSONObject) {
                // do something with jsonObject here
                System.out.println("JSONObject key by iterator:-" + key);
            }
            if (jsonMainObj.get(key) instanceof JSONArray) {
                // do something with jsonObject here
                System.out.println("JSONArray key by iterator:-" + key);
            }
        }
    }

    public static Set<String> getKeySet(JSONObject jsonObj) {
        return jsonObj.keySet();
    }

    public static Iterator<String> getKeys(JSONObject jsonObj) {
        return jsonObj.keys();
    }
}
