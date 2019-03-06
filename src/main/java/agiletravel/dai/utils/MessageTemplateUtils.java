package agiletravel.dai.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageTemplateUtils {

    public static Map setMessageData(String Name,String city, String time){
        Map map = new HashMap<>();
        map.put("keyword1",putKeyword("value",Name));
        map.put("keyword2",putKeyword("value",city));
        map.put("keyword3",putKeyword("value",time));
        return map;
    }

    public static Map putKeyword(String key, String value){
        Map map = new HashMap();
        map.put(key,value);
        return map;
    }

}
